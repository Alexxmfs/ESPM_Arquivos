// Modo Alek
// function converterMinutorEmHora() {
//     let duracaoMinutos = document.getElementById("duracaoMinutos").value;

//     let horas = Math.floor(duracaoMinutos / 60);

//     let minutos = duracaoMinutos % 60;

//     let formatoHora = horas + "h" + minutos;

//     document.getElementById("formatoHoraSaida").innerHTML = "Duração do filme " + formatoHora;

// }



// Modo Sellmini
function converter() {
    let tempoMinuto = document.getElementById("minuto").value;
    let msg = document.getElementById("msg");
    let hora = parseInt(tempoMinuto / 60);
    let minuto = parseInt(tempoMinuto % 60);
    msg.innerHTML = hora + ":" + minuto;
}