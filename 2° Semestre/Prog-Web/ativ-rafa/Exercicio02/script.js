const senha = document.getElementById("senha");
const teclado = document.querySelector(".teclado");
const mensagem = document.querySelector(".mensagem");

teclado.addEventListener("click", (event) => {
  const valor = event.target.value;
  senha.value += valor;
});

const validar = document.getElementById("validar");
validar.addEventListener("click", () => {
  const senhaFornecida = senha.value;
  if (senhaFornecida === "1234") {
    mensagem.textContent = "sucesso!";
  } else {
    mensagem.textContent = "Senha incorreta.";
  }
});
