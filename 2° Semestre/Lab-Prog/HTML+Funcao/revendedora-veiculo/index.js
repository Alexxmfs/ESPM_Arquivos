function calcularPagamento(modelo, preco){
    modelo = document.getElementById("modeloVeiculo").value;
    
    preco = parseFloat(document.getElementById("precoVeiculo").value);
    
    let entrada = preco * 0.5;
    let saldoParcelado = (preco - entrada) / 12;

    document.getElementById("modeloSaida").innerHTML = "Modelo: " + modelo;
    document.getElementById("precoSaida").innerHTML = "Preço: R$ " + preco.toFixed(2);
    document.getElementById("entradaSaida").innerHTML = "Entrada R$ " + entrada.toFixed(2);
    document.getElementById("saldoParceladoSaida").innerHTML = "Saldo em 12x: R$ " + saldoParcelado.toFixed(2) + " por mês";

}