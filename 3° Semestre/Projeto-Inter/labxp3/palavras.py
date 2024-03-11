palavra = "parelelepipedo"

print("1. ", palavra[0])
print("2. ", palavra[::-1])
print("3. ", palavra[::2])

palavra = "arara"
palindromo = palavra == palavra[::-1]
print(palindromo)
