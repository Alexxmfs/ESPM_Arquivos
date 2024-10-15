# docker run --name meu-mysql-container -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=sakila -p 3307:3306 -d mysql:latest

import mysql.connector

def conectar():
    try:
        con = mysql.connector.connect(
            host='localhost', 
            database='teste', 
            user='root', 
            password='root', 
            port='3307'
        )
        if con.is_connected():
            print("Conexão bem-sucedida!")
        return con
    except mysql.connector.Error as err:
        print(f"Erro ao conectar ao MySQL: {err}")
        return None

def criar_tabelas():
    con = conectar()
    if con:
        cursor = con.cursor()
        tabela_author = """
            CREATE TABLE IF NOT EXISTS author(
                authorID INT AUTO_INCREMENT PRIMARY KEY,
                name VARCHAR(50)
            )
        """
        tabela_post = """
            CREATE TABLE IF NOT EXISTS post(
                postID INT AUTO_INCREMENT PRIMARY KEY,
                authorID INT,
                title VARCHAR(255),
                created DATETIME,
                FOREIGN KEY (authorID) REFERENCES author(authorID)
            )
        """
        try:
            cursor.execute(tabela_author)
            cursor.execute(tabela_post)
            con.commit()
            print("Tabelas criadas com sucesso!")
        except mysql.connector.Error as err:
            print(f"Erro ao criar tabelas: {err}")
        finally:
            cursor.close()
            con.close()

def verificar_estrutura_tabelas():
    con = conectar()
    if con:
        cursor = con.cursor()
        try:
            cursor.execute("DESCRIBE author")
            print("\nEstrutura da tabela 'author':")
            for linha in cursor.fetchall():
                print(linha)

            cursor.execute("DESCRIBE post")
            print("\nEstrutura da tabela 'post':")
            for linha in cursor.fetchall():
                print(linha)
        except mysql.connector.Error as err:
            print(f"Erro ao verificar estrutura das tabelas: {err}")
        finally:
            cursor.close()
            con.close()

def inserir_autor(nome):
    con = conectar()
    if con:
        cursor = con.cursor()
        sql = 'INSERT INTO author (name) VALUES (%s)'
        args = (nome,)
        try:
            cursor.execute(sql, args)
            con.commit()
            print(f"Autor {nome} inserido com sucesso!")
        except mysql.connector.Error as err:
            print(f"Erro ao inserir autor: {err}")
        finally:
            cursor.close()
            con.close()

def listar_autores():
    con = conectar()
    if con:
        cursor = con.cursor()
        sql = 'SELECT authorID, name FROM author'
        try:
            cursor.execute(sql)
            autores = cursor.fetchall()
            if autores:
                print("\nAuthorID\tNome")
                for autor in autores:
                    print('\t'.join(str(campo) for campo in autor))
            else:
                print("Nenhum autor encontrado.")
        except mysql.connector.Error as err:
            print(f"Erro ao listar autores: {err}")
        finally:
            cursor.close()
            con.close()

def atualizar_autor(authorID, novo_nome):
    con = conectar()
    if con:
        cursor = con.cursor()
        sql = 'UPDATE author SET name = %s WHERE authorID = %s'
        args = (novo_nome, authorID)
        try:
            cursor.execute(sql, args)
            con.commit()
            print(f"Autor ID {authorID} atualizado com sucesso!")
        except mysql.connector.Error as err:
            print(f"Erro ao atualizar autor: {err}")
        finally:
            cursor.close()
            con.close()

def excluir_autor(authorID):
    con = conectar()
    if con:
        cursor = con.cursor()
        sql = 'DELETE FROM author WHERE authorID = %s'
        args = (authorID,)
        try:
            cursor.execute(sql, args)
            con.commit()
            print(f"Autor ID {authorID} excluído com sucesso!")
        except mysql.connector.Error as err:
            print(f"Erro ao excluir autor: {err}")
        finally:
            cursor.close()
            con.close()

def inserir_post(authorID, titulo, data_criacao):
    con = conectar()
    if con:
        cursor = con.cursor()
        # Verifica se o authorID existe
        cursor.execute('SELECT COUNT(*) FROM author WHERE authorID = %s', (authorID,))
        if cursor.fetchone()[0] == 0:
            print(f"Erro: Autor ID {authorID} não encontrado.")
            cursor.close()
            con.close()
            return

        sql = 'INSERT INTO post (authorID, title, created) VALUES (%s, %s, %s)'
        args = (authorID, titulo, data_criacao)
        try:
            cursor.execute(sql, args)
            con.commit()
            print(f"Post '{titulo}' inserido com sucesso!")
        except mysql.connector.Error as err:
            print(f"Erro ao inserir post: {err}")
        finally:
            cursor.close()
            con.close()

def listar_posts():
    con = conectar()
    if con:
        cursor = con.cursor()
        sql = 'SELECT postID, authorID, title, created FROM post'
        try:
            cursor.execute(sql)
            posts = cursor.fetchall()
            if posts:
                print("\nPostID\tAuthorID\tTítulo\tCriado")
                for post in posts:
                    print('\t'.join(str(campo) for campo in post))
            else:
                print("Nenhum post encontrado.")
        except mysql.connector.Error as err:
            print(f"Erro ao listar posts: {err}")
        finally:
            cursor.close()
            con.close()

def atualizar_post(postID, novo_titulo, nova_data_criacao):
    con = conectar()
    if con:
        cursor = con.cursor()
        sql = 'UPDATE post SET title = %s, created = %s WHERE postID = %s'
        args = (novo_titulo, nova_data_criacao, postID)
        try:
            cursor.execute(sql, args)
            con.commit()
            print(f"Post ID {postID} atualizado com sucesso!")
        except mysql.connector.Error as err:
            print(f"Erro ao atualizar post: {err}")
        finally:
            cursor.close()
            con.close()

def excluir_post(postID):
    con = conectar()
    if con:
        cursor = con.cursor()
        sql = 'DELETE FROM post WHERE postID = %s'
        args = (postID,)
        try:
            cursor.execute(sql, args)
            con.commit()
            print(f"Post ID {postID} excluído com sucesso!")
        except mysql.connector.Error as err:
            print(f"Erro ao excluir post: {err}")
        finally:
            cursor.close()
            con.close()

def buscar_authorID(nome):
    con = conectar()
    if con:
        cursor = con.cursor()
        sql = 'SELECT authorID FROM author WHERE name = %s'
        args = (nome,)
        try:
            cursor.execute(sql, args)
            row = cursor.fetchone()
            if row:
                return row[0]
            else:
                return None
        except mysql.connector.Error as err:
            print(f"Erro ao buscar authorID: {err}")
        finally:
            cursor.close()
            con.close()
    else:
        return None

def inserir_autor_prompt():
    nome = input("Digite o nome do autor: ")
    if buscar_authorID(nome) is None:
        inserir_autor(nome)
    else:
        print("Autor já existe.")

def menu():
    while True:
        print("\n--- CRUD Author & Post ---")
        print("1. Operações com Author")
        print("2. Operações com Post")
        print("3. Sair")
        opcao = input("Escolha uma opção: ")

        if opcao == '1':
            while True:
                print("\n--- Operações com Author ---")
                print("1. Inserir Autor")
                print("2. Listar Autores")
                print("3. Atualizar Autor")
                print("4. Excluir Autor")
                print("5. Voltar ao menu principal")
                opcao_author = input("Escolha uma opção: ")

                if opcao_author == '1':
                    nome = input("Digite o nome do autor: ")
                    inserir_autor(nome)
                elif opcao_author == '2':
                    listar_autores()
                elif opcao_author == '3':
                    authorID = input("Digite o ID do autor para atualizar: ")
                    novo_nome = input("Digite o novo nome: ")
                    atualizar_autor(authorID, novo_nome)
                elif opcao_author == '4':
                    authorID = input("Digite o ID do autor para excluir: ")
                    excluir_autor(authorID)
                elif opcao_author == '5':
                    break
                else:
                    print("Opção inválida, tente novamente.")
        elif opcao == '2':
            while True:
                print("\n--- Operações com Post ---")
                print("1. Inserir Post")
                print("2. Listar Posts")
                print("3. Atualizar Post")
                print("4. Excluir Post")
                print("5. Voltar ao menu principal")
                opcao_post = input("Escolha uma opção: ")

                if opcao_post == '1':
                    inserir_autor_prompt()  
                    authorID = input("Digite o ID do autor: ")
                    titulo = input("Digite o título do post: ")
                    data_criacao = input("Digite a data de criação (AAAA-MM-DD HH:MM:SS): ")
                    inserir_post(authorID, titulo, data_criacao)
                elif opcao_post == '2':
                    listar_posts()
                elif opcao_post == '3':
                    postID = input("Digite o ID do post para atualizar: ")
                    novo_titulo = input("Digite o novo título: ")
                    nova_data_criacao = input("Digite a nova data de criação (AAAA-MM-DD HH:MM:SS): ")
                    atualizar_post(postID, novo_titulo, nova_data_criacao)
                elif opcao_post == '4':
                    postID = input("Digite o ID do post para excluir: ")
                    excluir_post(postID)
                elif opcao_post == '5':
                    break
                else:
                    print("Opção inválida, tente novamente.")
        elif opcao == '3':
            print("Saindo...")
            break
        else:
            print("Opção inválida, tente novamente.")

if __name__ == "__main__":
    criar_tabelas()
    verificar_estrutura_tabelas()  
    menu()
