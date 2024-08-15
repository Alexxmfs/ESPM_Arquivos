alimentos = c("Pão", "Chocolate", 'Peixe', "Melancia")

animais = c("Cachorro", "Gato", "Papagaio", "Peixe")

dados = data.frame(alimentos, animais)

library(tidyverse)

write_csv(dados, "Aula02.csv")


cces = read_csv("cces_sample.csv")

# NA = not available

#Podemos fazer o processo de imputação que é substituir 
# o NA pela média, pela moda, pela mediana.
# drop_na() limpa todos os NA.

# Data Wrangling

cces = drop_na(cces)
cces_south = filter(cces, region == 3)               
cces_south_4primeiras = select(cces_south, region, gender, educ, edloan)

cces = read_csv("cces_sample.csv")
tudo_de_uma_vez = cces %>%
  drop_na() %>%
  filter(region == 3) %>%
  select(region, gender, educ, edloan)

