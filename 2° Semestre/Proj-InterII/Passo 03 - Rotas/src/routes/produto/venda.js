"use strict";
class VendaRoute {
    async index(req, res) {
        res.send("Eu sou o index da venda...");
    }
    async efetivar(req, res) {
        res.send("Efetivar uma venda... bruno e gay");
    }
    async listar(req, res) {
        res.send("Listar vendas...");
    }
}
module.exports = VendaRoute;
//# sourceMappingURL=venda.js.map