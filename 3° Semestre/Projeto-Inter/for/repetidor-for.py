#
# Analisar o perfil do investidor para compra de ativos, padrão BACEN,
# faça um programa que pergute:
#
# 1. Tem formação na area financeira?
# 2. Tem experiencia com investidor?
# 3. Possui patrimonio constituido?
# 4. Esta disposto a correr risco?
# 5. Voce suporta perdas de até 20% do capital investido a curto prazo?
#
# de acordo com as respostas, classifique o perfil do investidor em:
#
# 1. Conservador, se ele colocou sim para ate 1 pergunta
# 2. Moderado, se ele colocou sim para ate 3 pergunta
# 3. Agressivo, se ele colocou sim para ate 4 pergunta
# 4. Especular, se ele colocou sim para ate 5 pergunta

# Perguntas
perguntas = [
    input("1. Tem formação na area financeira?"),
    input("2. Tem experiencia com investidor?"),
    input("3. Possui patrimonio constituido?"),
    input("4. Esta disposto a correr risco?"),
    input("5. Voce suporta perdas de até 20% do capital investido a curto prazo?")
]

pts = 0
for perg in perguntas:
    if input(perg).lower() in ["sim", "s", "yes"]:
        pts += 1

if pts <= 1:
    print("Conservador")
elif pts <= 3:
    print("Moderado")
elif pts <= 4:
    print("Agressivo")
else:
    print("Espetacular")
