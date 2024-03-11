import requests
from constantantes import URL

response = requests.get(URL)
html = response.text
seed = 'c-main-headline__title">'
start = html.find('c-main-headline__title')
start = html.find(seed) + len(seed)
html = html[start:]
end = html.find('</h2>')
html = html[end:]
print(html)

