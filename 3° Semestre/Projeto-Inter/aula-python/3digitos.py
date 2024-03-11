# dado um numero de tres digitos, imprimir a soma dos digitos. Se não tiver 3 digitos escrever 'invalido

n = int(input("Digite um numero de 3 digitos: "))
if n < 100 or n > 999:
    print('invalido')
else: 
    soma = 0
    while n > 0:
        soma += n % 10
        n = n // 10
    print(f'soma:  {soma}');