import sqlite3

conn = sqlite3.connect('blog.db')

cursor = conn.cursor()

cursor.execute("""
     CREATE TABLE IF NOT EXISTS author(
    authorID INT,
    name VARCHAR(50)
    )
    """)

cursor.execute("""
     CREATE TABLE IF NOT EXISTS post(
    postID INT,
    title VARCHAR(50),
    authorID INT,
    created DATE
    )
    """)

conn.commit()
conn.close()

print("Table created successfully")



idauthor = int(input("Enter auhtor ID: "))
nome = input("Enter author name: ")

def insert_author(idauthor, nome):
    try:
        conn = sqlite3.connect('blog.db')
    
        cursor = conn.cursor()
    
        cursor.execute(""" INSERT INTO author (authorID, name) VALUES (?, ?) """, (idauthor, nome))

        conn.commit()
        conn.close()
    except sqlite3.Error as e:
        print("Error: ", e)
        
insert_author(idauthor, nome)


conn = sqlite3.connect('blog.db')

cursor = conn.cursor()

idauthor = int(input("Enter auhtor ID: "))
nome = input("Enter author name: ")

cursor.execute(""" UPDATE author SET name = ? WHERE authorID = ? """, (nome, idauthor))

conn.commit()
conn.close()
print("Author update successfully")



conn = sqlite3.connect('blog.db')

cursor = conn.cursor()

cursor.execute(""" SELECT * FROM author """)

for linha in cursor.fetchall():
    print(linha)

    conn.close()
    

conn = sqlite3.connect('blog.db')
cursor = conn.cursor()

cursor.execute(""" DELETE FROM author WHERE authorID = ? """, (idauthor, ))

conn.commit()
conn.close()
print("Author delete successfully")
