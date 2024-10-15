import mysql.connector
from datetime import datetime

def conectar():
    try:
        con = mysql.connector.connect(
            host='localhost', 
            database='redeDB', 
            user='root', 
            password='root', 
            port='3312'
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
        tabela_post = """
            CREATE TABLE IF NOT EXISTS post(
                postID INT PRIMARY KEY,
                title VARCHAR(50),
                created DATETIME,
                text VARCHAR(50)
            )
        """
        
        tabela_comment = """
            CREATE TABLE IF NOT EXISTS comment(
                commentID INT AUTO_INCREMENT PRIMARY KEY,
                postID INT,
                text VARCHAR(255),
                created DATETIME,
                user VARCHAR(50),
                FOREIGN KEY (postID) REFERENCES post(postID)
            )
        """
        try:
            cursor.execute(tabela_post)
            cursor.execute(tabela_comment)
            con.commit()
            print("Tabelas criadas com sucesso!")
        except mysql.connector.Error as err:
            print(f"Erro ao criar tabelas: {err}")
        finally:
            cursor.close()
            con.close()

def inserir_post_prompt():
    postID = input("Digite o ID do post: ")
    title = input("Digite o título do post: ")
    text = input("Digite o texto do post: ")
    data_criacao = datetime.now().strftime('%Y-%m-%d %H:%M:%S')
    inserir_post(postID, title, text, data_criacao)

def verificar_estrutura_tabelas():
    con = conectar()
    if con:
        cursor = con.cursor()
        try:
            cursor.execute("DESCRIBE post")
            print("\nEstrutura da tabela 'post':")
            for linha in cursor.fetchall():
                print(linha)

            cursor.execute("DESCRIBE comment")
            print("\nEstrutura da tabela 'comment':")
            for linha in cursor.fetchall():
                print(linha)
        except mysql.connector.Error as err:
            print(f"Erro ao verificar estrutura das tabelas: {err}")
        finally:
            cursor.close()
            con.close()

def inserir_post(postID, title, text, data_criacao):
    con = conectar()
    if con:
        cursor = con.cursor()
        sql = 'INSERT INTO post (postID, title, text, created) VALUES (%s, %s, %s, %s)'
        args = (postID, title, text, data_criacao)
        try:
            cursor.execute(sql, args)
            con.commit()
            print(f"Post '{title}' inserido com sucesso!")
        except mysql.connector.Error as err:
            print(f"Erro ao inserir Post: {err}")
        finally:
            cursor.close()
            con.close()

def listar_post():
    con = conectar()
    if con:
        cursor = con.cursor()
        sql = 'SELECT postID, title, text FROM post'
        try:
            cursor.execute(sql)
            posts = cursor.fetchall()
            if posts:
                print("\nPostID\tTitle")
                for post in posts:
                    print('\t'.join(str(campo) for campo in post))
            else:
                print("Nenhum post encontrado.")
        except mysql.connector.Error as err:
            print(f"Erro ao listar posts: {err}")
        finally:
            cursor.close()
            con.close()

def atualizar_post(postID, novo_title, nova_data_criacao):
    con = conectar()
    if con:
        cursor = con.cursor()
        sql = 'UPDATE post SET title = %s, created = %s WHERE postID = %s'
        args = (novo_title, nova_data_criacao, postID)
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

def inserir_comment(postID, text, data_criacao, user):
    con = conectar()
    if con:
        cursor = con.cursor()
        sql = 'INSERT INTO comment (postID, text, created, user) VALUES (%s, %s, %s, %s)'
        args = (postID, text, data_criacao, user)
        try:
            cursor.execute(sql, args)
            con.commit()
            print(f"Comentário inserido com sucesso no Post ID {postID}!")
        except mysql.connector.Error as err:
            print(f"Erro ao inserir comentário: {err}")
        finally:
            cursor.close()
            con.close()

def listar_comment():
    con = conectar()
    if con:
        cursor = con.cursor()
        postID = input("Digite o ID do post para listar os comentários: ")
        sql = 'SELECT commentID, text, created, user FROM comment WHERE postID = %s'
        try:
            cursor.execute(sql, (postID,))
            comments = cursor.fetchall()
            if comments:
                print(f"\nComentários para o Post ID {postID}:")
                for comment in comments:
                    print(f"ID: {comment[0]} | Texto: {comment[1]} | Criado em: {comment[2]} | Usuário: {comment[3]}")
            else:
                print(f"Nenhum comentário encontrado para o Post ID {postID}.")
        except mysql.connector.Error as err:
            print(f"Erro ao listar comentários: {err}")
        finally:
            cursor.close()
            con.close()

def atualizar_comment(commentID, novo_texto, nova_data_criacao, novo_user):
    con = conectar()
    if con:
        cursor = con.cursor()
        sql = 'UPDATE comment SET text = %s, created = %s, user = %s WHERE commentID = %s'
        args = (novo_texto, nova_data_criacao, novo_user, commentID)
        try:
            cursor.execute(sql, args)
            con.commit()
            print(f"Comentário ID {commentID} atualizado com sucesso!")
        except mysql.connector.Error as err:
            print(f"Erro ao atualizar comentário: {err}")
        finally:
            cursor.close()
            con.close()

def excluir_comment(commentID):
    con = conectar()
    if con:
        cursor = con.cursor()
        sql = 'DELETE FROM comment WHERE commentID = %s'
        args = (commentID,)
        try:
            cursor.execute(sql, args)
            con.commit()
            print(f"Comentário ID {commentID} excluído com sucesso!")
        except mysql.connector.Error as err:
            print(f"Erro ao excluir comentário: {err}")
        finally:
            cursor.close()
            con.close()

def menu_principal():
    while True:
        print("\n--- Menu Principal ---")
        print("1. CRUD Post")
        print("2. CRUD Comentário")
        print("3. Sair")
        opcao = input("Escolha uma opção: ")

        if opcao == '1':
            menu_post()
        elif opcao == '2':
            menu_comment()
        elif opcao == '3':
            print("Saindo...")
            break
        else:
            print("Opção inválida, tente novamente.")

def menu_comment():
    while True:
        print("\n--- CRUD Comentário ---")
        print("1. Inserir Comentário")
        print("2. Listar Comentários")
        print("3. Atualizar Comentário")
        print("4. Excluir Comentário")
        print("5. Voltar")
        opcao = input("Escolha uma opção: ")

        if opcao == '1':
            postID = input("Digite o ID do post para inserir o comentário: ")
            text = input("Digite o texto do comentário: ")
            user = input("Digite seu nome de usuário: ")  
            data_criacao = datetime.now().strftime('%Y-%m-%d %H:%M:%S')
            inserir_comment(postID, text, data_criacao, user)  
        elif opcao == '2':
            listar_comment()
        elif opcao == '3':
            commentID = input("Digite o ID do comentário para atualizar: ")
            novo_texto = input("Digite o novo texto do comentário: ")
            nova_data_criacao = input("Digite a nova data de criação (AAAA-MM-DD HH:MM:SS): ")
            novo_user = input("Digite o novo nome de usuário: ")
            atualizar_comment(commentID, novo_texto, nova_data_criacao, novo_user)


        elif opcao == '4':
            commentID = input("Digite o ID do comentário para excluir: ")
            excluir_comment(commentID)
        elif opcao == '5':
            break
        else:
            print("Opção inválida, tente novamente.")

def menu_post():
    while True:
        print("\n--- CRUD Post ---")
        print("1. Inserir Post")
        print("2. Listar Posts")
        print("3. Atualizar Post")
        print("4. Excluir Post")
        print("5. Voltar")
        opcao = input("Escolha uma opção: ")

        if opcao == '1':
            inserir_post_prompt()
        elif opcao == '2':
            listar_post()
        elif opcao == '3':
            postID = input("Digite o ID do post para atualizar: ")
            novo_title = input("Digite o novo título do post: ")
            nova_data_criacao = input("Digite a nova data de criação (AAAA-MM-DD HH:MM:SS): ")
            atualizar_post(postID, novo_title, nova_data_criacao)
        elif opcao == '4':
            postID = input("Digite o ID do post para excluir: ")
            excluir_post(postID)
        elif opcao == '5':
            break
        else:
            print("Opção inválida, tente novamente.")

criar_tabelas()  
menu_principal()
