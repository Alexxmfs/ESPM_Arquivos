function verificarFaltante() {
    document.getElementById('output').innerHTML = '';

    const valueA = parseInt(document.getElementById('valueA').value);
    const valueB = parseInt(document.getElementById('valueB').value);
    const valueC = parseInt(document.getElementById('valueC').value);
    const valueD = parseInt(document.getElementById('valueD').value);
    const valueE = parseInt(document.getElementById('valueE').value);

    if (valueA < 1 || valueA > 6 || valueB < 1 || valueB > 6 || valueC < 1 || valueC > 6 ||
        valueD < 1 || valueD > 6 || valueE < 1 || valueE > 6) {
      saidaErro('Todos os valores devem estar entre 1 e 6.');
      return;
    }

    const cards = [valueA, valueB, valueC, valueD, valueE];

    for (let i = 1; i <= 6; i++) {
      if (!cards.includes(i)) {
        saida(i);
        return;
      }
    }
  }

  function saida(cardFaltando) {
    document.getElementById('output').innerHTML = "<p>O card faltante é: " + cardFaltando + "</p>";
  }

  function saidaErro(msgErro) {
    document.getElementById('output').innerHTML = `<p style="color: red;">Erro: ${msgErro}</p>`;
  }