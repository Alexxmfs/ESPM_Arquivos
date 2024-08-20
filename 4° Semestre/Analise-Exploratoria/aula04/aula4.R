#Aula 4 - Mais sobre Data  Wrangling

library(tidyverse)

cces = read_csv("C:/Users/thiago.alonso/OneDrive - ESPM/Matérias/4º Semestre/Analise Exploratoria/Excel e CSV/cces_sample.csv")

tudo_de_uma_vez = cces %>% 
  drop_na() %>%
  filter(region == 3) %>% 
  select(region, gender, educ, edloan)

# a) Limpar os missings values
# b) Ordenar a base utilizando a variável region.
# c) Renomear a variável faminc_new e chamá-la renda.
# d) Recodificar a a variável region pelos nomes das regiôes
# e) Calcular a renda média por região.

# a)
dados1 = drop_na(cces)
dados2 = arrange(dados1, region) # serve para ordenar.

# b)
#Para ordenar do maior para o menor, utiliza-se o argumento desc()
#If you write in English... 

dados2 = arrange(dados1, desc(region))

# c)
dados1 = rename(dados1, renda = faminc_new)

# d)
# 1 = Northwest
# 2 = Midwest
# 3 = South
# 4 = West

dados1$region = recode(dados1$region,
                       1 = "Northwest",
                       2 = "Midwest",
                       3 = "South",
                       4 = "West"
)

#e) Primeiro gerar grupos na base
dados1 = group_by(dados1, region)
#Depois calcular a média de renda por grupo
tabela = summarise(dados1, media = mean(renda))

library(knitr)
options(digits = 3)
kable(tabela)

# Use o comando select() para criar um subconjunto dos dados que inclua somente as
# colunas: escolaridade (educational level), se o respondente tem algum financiamento
# educacional (educational loan), situação de trabalho (employment status), e aprovação
# ao Governo (Trump approval). Apresente o objeto. Dica: consulte o dicionário de
# variáveis para identificar as variáveis corretas.

select(dados2, educ, edloan, employ, CC18_308a)

# Use o comando recode() para criar uma nova coluna no objeto anterior chamada
# "trump_approve_disapprove" que recodifica a variável “President Trump's job approval”.
# Um valor igual a "1" deve significar que o respondente ou "strongly" ou "somewhat"
# aprova o Governo, e o valor "0" deve significar que o respondente ou "strongly" ou
# "somewhat" desaprova o Governo Trump. Apresente os resultados do objeto no console

dados2$trump_approve_disapprove = recode(dados2$CC18_308a,
                                         "Strongly approve" = 1,
                                         "Somewhat approve" = 1,
                                         "Somewhat disapprove" = 0,
                                         "Strongly disapprove" = 0)

# Use summarise() para criar um sumário dos respondentes que estão empregados em
# tempo integral e são casados. A tabela deve apresentar a média e a mediana da
# importância dada a religião.

tabela2 = filter(dados2, employ == "1" & marstat == "1") 

tabela2 = summarise(dados2, media = mean(pew_religimp), mediana = median(pew_religimp))