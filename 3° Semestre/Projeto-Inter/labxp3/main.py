nomes = [];

while True:
        nome = input("Digite o nome: ");
        if nome == "":
            break;
        tmp = nome
        i = 1
        while tmp in nomes:
              tmp = nome + str(i)
              i += 1
              print("Nome já existe")
        nomes.append(tmp);
        print(nomes);