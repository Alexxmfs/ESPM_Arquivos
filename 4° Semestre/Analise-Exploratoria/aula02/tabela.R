alimentos = c("Pão", "Chocolate", 'Peixe', "Melancia")

animais = c("Cachorro", "Gato", "Papagaio", "Peixe")

dados = data.frame(alimentos, animais)

library(tidyverse)

write_csv(dados, "Aula02.csv")
