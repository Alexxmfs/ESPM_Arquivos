import re
import numpy as np
import hnswlib
from sentence_transformers import SentenceTransformer
from transformers import pipeline
import torch

def carregar_capitulos(caminho_arquivo):
    with open(caminho_arquivo, 'r', encoding='latin-1') as f:  
        texto = f.read()
    
    capitulos = re.split(r'\bCAP[IÍ]TULO\s+\d+\b', texto, flags=re.IGNORECASE)
    capitulos = [c.strip() for c in capitulos if c.strip()]
    
    blocos = []
    for idx, cap in enumerate(capitulos):
        blocos.append((f"Capítulo {idx+1}", cap))
    
    return blocos

def gerar_embeddings(blocos, modelo_name='all-MiniLM-L6-v2'):
    modelo = SentenceTransformer(modelo_name)
    textos = [conteudo for _, conteudo in blocos]
    embeddings = modelo.encode(textos, convert_to_numpy=True, show_progress_bar=True)
    return embeddings

def criar_indice(embeddings, dim=384):
    p = hnswlib.Index(space='cosine', dim=dim)
    p.init_index(max_elements=len(embeddings), ef_construction=200, M=16)
    p.add_items(embeddings, list(range(len(embeddings))))
    p.set_ef(50)  
    return p

def recuperar_bloco(pergunta, modelo_embed, indice, blocos):
    embedding_pergunta = modelo_embed.encode([pergunta], convert_to_numpy=True)[0]
    idx_similar, _ = indice.knn_query(embedding_pergunta, k=1)
    idx = idx_similar[0][0]
    return blocos[idx]

def responder_qa(pergunta, contexto, modelo_nome):
    qa_pipeline = pipeline('question-answering', model=modelo_nome, tokenizer=modelo_nome)
    resposta = qa_pipeline(question=pergunta, context=contexto)
    return resposta['answer']

def main():
    print("Carregando capítulos...")
    blocos = carregar_capitulos("domcasmurro.txt")

    print("Gerando embeddings...")
    modelo_embed = SentenceTransformer('all-MiniLM-L6-v2')
    embeddings = gerar_embeddings(blocos, modelo_name='all-MiniLM-L6-v2')

    print("Construindo índice vetorial...")
    indice = criar_indice(embeddings)

    while True:
        pergunta = input("\nDigite sua pergunta (ou 'sair'): ")
        if pergunta.lower() == 'sair':
            break
        
        titulo, contexto = recuperar_bloco(pergunta, modelo_embed, indice, blocos)

        print(f"\n--- Contexto extraído: {titulo} ---")
        print(contexto[:500] + '...')  

        print("\n📘 Modelo: distilbert-base-uncased")
        resposta1 = responder_qa(pergunta, contexto, 'distilbert-base-uncased')
        print("Resposta:", resposta1)

        print("\n📙 Modelo: deepset/roberta-base-squad2")
        resposta2 = responder_qa(pergunta, contexto, 'deepset/roberta-base-squad2')
        print("Resposta:", resposta2)

if __name__ == "__main__":
    main()
