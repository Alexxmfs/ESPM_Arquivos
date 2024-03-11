class Reserva {
    constructor(nome, telefone, formaPagamento) {
        this.nome = nome;
        this.telefone = telefone;
        this.formaPagamento = formaPagamento;
    }
}

let valorMesa = 5400.0;
let reservas = [];
let listaEspera = [];

function reservarMesa() {
    if (reservas.length < 2) {
        let nome = prompt("Digite o nome do cliente");
        let telefone = prompt("Digite o número de telefone do cliente");
        let formaPagamento = prompt("Digite a forma de pagamento (à vista ou parcelado)");

        let novaReserva = new Reserva(nome, telefone, formaPagamento);
        reservas.push(novaReserva);

        let valorTotal = reservas.length * valorMesa;
        alert("Reserva realizada com sucesso!\nTotal a pagar para esta reserva: R$ " + valorMesa.toFixed(2)+ "\nTotal de mesas reservadas: " + reservas.length);
        
        if (reservas.length == 2) {
            alert("Última vaga reservada! Não há mais disponibilidade para reservas.");
        } else {
            let vagasDisponiveis = 2 - reservas.length;
            alert("Ainda restam " + vagasDisponiveis + " vagas disponíveis.");
        }
    } else {
        let nomeEspera = prompt("Desculpe, não há mais vagas. Insira seu nome para entrar na lista de espera:");
        let telefoneEspera = prompt("Agora, digite o número de telefone para contato:");

        let clienteEspera = { nome: nomeEspera, telefone: telefoneEspera };
        listaEspera.push(clienteEspera);

        alert("Você está na lista de espera. Entraremos em contato se houver uma vaga disponível.");
    }
}

function exibirReservas() {
    if (reservas.length == 0) {
        alert("Não há reservas no momento.");
    } else {
        let listaReservas = "Lista de Reservas:\n";
        for (let i = 0; i < reservas.length; i++) {
            listaReservas += "Nome: " + reservas[i].nome + ", Telefone: " + reservas[i].telefone + ", Forma de Pagamento: " + reservas[i].formaPagamento + "\n";
        }
        alert(listaReservas);
    }
}

function pesquisarReserva() {
    let telefonePesquisa = prompt("Digite seu número de telefone para pesquisar a reserva:");
    let encontrouReserva = false;

    for (let i = 0; i < reservas.length; i++) {
        if (reservas[i].telefone == telefonePesquisa) {
            encontrouReserva = true;
            alert("Você tem uma reserva! Nome: " + reservas[i].nome + ", Forma de Pagamento: " + reservas[i].formaPagamento);
            break;
        }
    }

    if (!encontrouReserva) {
        for (let i = 0; i < listaEspera.length; i++) {
            if (listaEspera[i].telefone == telefonePesquisa) {
                alert("Você está na lista de espera na posição " + (i + 1) + ". Entraremos em contato se houver uma vaga disponível.");
                return;
            }
        }
        alert("Você não tem reserva e não está na lista de espera.");
    }
}

function exibirListaEspera() {
    if (listaEspera.length == 0) {
        alert("Não há clientes na lista de espera.");
    } else {
        let listaEsperaText = "Lista de Espera:\n";
        for (let i = 0; i < listaEspera.length; i++) {
            listaEsperaText += "Nome: " + listaEspera[i].nome + ", Telefone: " + listaEspera[i].telefone + "\n";
        }
        alert(listaEsperaText);
    }
}


function cancelarReserva() {
    let telefoneCancelamento = prompt("Digite seu número de telefone para cancelar a reserva:");
    let indexReservaCancelada = -1;

    for (let i = 0; i < reservas.length; i++) {
        if (reservas[i].telefone == telefoneCancelamento) {
            indexReservaCancelada = i;
            break;
        }
    }

    if (indexReservaCancelada != -1) {
        let reservaCancelada = reservas.splice(indexReservaCancelada, 1)[0];

        let valorTotal = reservas.length * valorMesa;
        alert("Reserva de " + reservaCancelada.nome + " cancelada com sucesso.\nValor pago para esta reserva: R$" + valorMesa.toFixed(2) + "\nTotal a pagar para as demais reservas: R$" + valorTotal.toFixed(2));

        if (listaEspera.length > 0) {
            let clienteEspera = listaEspera.shift();
            reservas.push(new Reserva(clienteEspera.nome, clienteEspera.telefone, "à vista"));
            alert("Cliente "+ clienteEspera.nome + " da lista de espera adicionado à reserva.");
        }
    } else {
        alert("Você não tem uma reserva para cancelar ou não foi encontrado na lista de reservas.");
    }
}

function menu() {
    let opcao = prompt("Escolha uma opção:\n1. Reservar Mesa\n2. Exibir Reservas\n3. Pesquisar Reserva\n4. Imprimir Lista de Espera\n5. Cancelar Reserva\n6. Sair");

    switch (opcao) {
        case "1":
            reservarMesa();
            break;
        case "2":
            exibirReservas();
            break;
        case "3":
            pesquisarReserva();
            break;
        case "4":
            exibirListaEspera();
            break;
        case "5":
            cancelarReserva();
            break;
        case "6":
            alert("Aplicativo encerrado.");
            break;
        default:
            alert("Opção inválida. Tente novamente.");
            menu();
    }
}

menu();
