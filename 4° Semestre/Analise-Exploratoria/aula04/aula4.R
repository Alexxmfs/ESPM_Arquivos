# Aula 04 - Mais sobre Data Wrangling

library(tidyverse)

cces = read_csv("cces_sample.csv")


tudo_de_uma_vez = cces %>%
  drop_na() %>%
  filter(region == 3) %>%
  select(region, gender, educ, edloan)

# a) Limpar os missings values
# b) Ordenar a base utilizando a variavel região
# c) Renomear a variavel faminc_new e chamá-la renda
# d) Recodificar a variavel region e pelos nomes das regiões
# e) Calcular a renda média por região.

# a)
dados1 = drop_na(cces)
dados2 = arrange(dados1, region) # serve para ordenar.

# b)
# Para ordenar do maior para menor, utlizar-se o argumento desc()

dados2 = arrange(dados1, desc(region))

# c)
dados1 = rename(dados1, renda = faminc_new )

# d)
dados1$region = recode(dados1$region, 
                       `1` = "Northwest",
                       `2` = "Midwest",
                       `3` = "South",
                       `4` = "West"
                      )

# e) Primeiro gerar grupos e depois calcular a média
dados1 = group_by(dados1, region)
tabela = summarise(dados1, media = mean(renda))

library(knitr)
options(digits = 3)
kable(tabela)


# 1) Use o comando select() para criar um subconjunto dos dados que inclua somente as
# colunas: escolaridade (educational level), se o respondente tem algum financiamento
# educacional (educational loan), situação de trabalho (employment status), e aprovação
# ao Governo (Trump approval). Apresente o objeto. Dica: consulte o dicionário de
# variáveis para identificar as variáveis corretas.

cces = select(cces, educ, edloan, employ, CC18_308a)
head(cces)



# 2) Use o comando recode() para criar uma nova coluna no objeto anterior chamada
# "trump_approve_disapprove" que recodifica a variável “President Trump's job approval”.
# Um valor igual a "1" deve significar que o respondente ou "strongly" ou "somewhat"
# aprova o Governo, e o valor "0" deve significar que o respondente ou "strongly" ou
# "somewhat" desaprova o Governo Trump. Apresente os resultados do objeto no console.

dados1$trump_approve_disapprove = recode(dados1$CC18_308a, 
                                         "Strongly approve" = 1,
                                         "Somewhat approve" = 1,
                                         "Strongly disapprove" = 0,
                                         "Somewhat disapprove" = 0)


# Use summarise() para criar um sumário dos respondentes que estão empregados em
# tempo integral e são casados. A tabela deve apresentar a média e a mediana da
# importância dada a religião.

dados1 = filter(dados1, employ == "Full time")
dados1 = filter(dados1, marstat == "Married")
tabela = summarise(dados1, media = mean(pew_religimp), mediana = median(pew_religimp))
