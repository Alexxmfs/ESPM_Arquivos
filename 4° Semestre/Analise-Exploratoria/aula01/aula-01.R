# Como configurar (setar) a pasta?

# Session -> Set Working Directory -> Choose Directory
# Escolher a pasta e clicar em ok

# Atribuição é feita com o sinal de igual

hello = "olá"
print(hello)

x = c(1, 2, 3, 4, 5)
y <- c(6, 7, 8, 9, 10)
x -> z

dados1 = data.frame(x, y)

vetor = c("E", "S", "P", "M", "top")

dados1$teste = vetor

# Para mandar essa base para o Excel, precisamos
# instalar o pacote chamado "writexl" ou vai em "tools" e procura e instala

install.packages("writexl")

library(writexl)
write_xlsx(dados1, "Aula01.xlsx")

# O pacote tidyverse é um pacote que irá nos ajudar
# a ler, organizar etc.

install.packages("tidyverse")

library(tidyverse)
dados2 = read_delim("https://www.colorado.edu/amath/sites/default/files/attached-files/gapminder_five.txt")


write_xlsx(dados2, "Aula01-colorado.xlsx")

# Exercicio - Exportar a base do GapMinder para o Excel