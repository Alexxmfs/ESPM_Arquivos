# [0; 6 [ -> boa madrugada]
# [6; 12 [ -> bom dia]
# [12; 18 [ -> bom tarde]
# [18; 24 [ -> bom noite]
# [15 -> bom chá]

hora = int(input("Digite a hora: "))

if hora < 12:
    print("bom dia");
elif hora < 18:
    print('boa tarde')
elif hora == 15:
    print('bom cha')
else:
    print('boa noite!')

print("bye bye")


print(3 + 4) # adicao
print(3 - 4) # subtração
print(3 ** 4) # multiplicação
print(3 % 4) # resto de divisão
print(3 / 4) # divisão
print(3 // 4) # inteira da divisão