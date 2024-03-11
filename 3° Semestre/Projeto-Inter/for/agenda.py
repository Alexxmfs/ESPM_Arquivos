agenda = []

while True:
    comando = input("> ").lower().strip()
    if comando == 'add':
        nome = input("Nome: ")
        telefone = input("Telefone: ")
        agenda.append([nome, telefone])   
    elif comando == 'list':
        for nome, telefone in agenda:
            print(f"{nome}: {telefone}")
    elif comando.split(" ")[0] == "search":
        nome = comando.split(" ")[1].lower()
        for record in agenda:
            if nome in agenda[0].lower():
                print(f"{record[0]}: {record[1]}")
    elif comando == 'exit': break
    else: print("Comando invalido")