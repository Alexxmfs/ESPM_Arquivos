// Modo Alek
// function temperatura() {
//     let f;
//     let c = document.getElementById("c").value;

//     f = c * (9/5);

//     f = f - 32;

//     msg.innerHTML = "A temperatura é " + f;

// }


function converter() {
  let entrada = document.getElementById("entrada").value;
  let saida = document.getElementById("saida");

  let aux = (entrada - 32) * 5 / 9;

  saida.innerHTML = aux;
}
