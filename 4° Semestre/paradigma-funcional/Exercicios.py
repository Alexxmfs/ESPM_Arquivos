def gerar_frases(lista):
    return list(map(lambda pessoa: f"{pessoa['nome']} tem {pessoa['idade']} anos.", lista))

lista = [
    {'nome': 'João', 'idade': 31},
    {'nome': 'Maria', 'idade': 37},
    {'nome': 'José', 'idade': 26}
]

frases = gerar_frases(lista)
print(frases)

pessoas = [
    {'nome': 'Pedro', 'idade': 11},
    {'nome': 'Mariana', 'idade': 18},
    {'nome': 'Arthur', 'idade': 26},
    {'nome': 'Rebeca', 'idade': 6},
    {'nome': 'Tiago', 'idade': 19},
    {'nome': 'Gabriela', 'idade': 17}
]

def reduce(func, lista, inicial):
    acumulador = inicial
    for item in lista:
        acumulador = func(acumulador, item)
    return acumulador

menores_de_18 = list(filter(lambda pessoa: pessoa['idade'] < 18, pessoas))

idades_menores_de_18 = list(map(lambda pessoa: pessoa['idade'], menores_de_18))

soma_idades = reduce(lambda acc, idade: acc + idade, idades_menores_de_18, 0)

print(soma_idades)


def progressao_aritmetica(n):
    return list(map(lambda i: i, range(0, n+1)))

n = 10
resultado = progressao_aritmetica(n)
print(resultado)

