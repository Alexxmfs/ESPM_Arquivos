import requests

URL = "https://br.financas.yahoo.com/quote/%5EBVSP/history"
response = requests.get(URL)
# pega o conteudo da pagina
# cria uma variavel para achar o inicio do desejado
seed = 'c-main-headline__title"'
# procuro o inicio do desejado no conteudo da pagina
html = response.text
start = html.find(seed) + len(seed)
html = html[start:]
end = html.find('</h2>')
html = html[end:]
print(html)

print(response.text)