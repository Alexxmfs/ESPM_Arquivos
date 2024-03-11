"use strict";
class UsuarioRoute {
    async index(req, res) {
        res.send("Eu sou o index do usuário...");
    }
    async criar(req, res) {
        res.send("Criar usuário...");
    }
    async listar(req, res) {
        res.send("Listar usuários...");
    }
}
module.exports = UsuarioRoute;
//# sourceMappingURL=usuario.js.map