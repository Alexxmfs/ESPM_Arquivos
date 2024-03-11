import app = require("teem");

class UsuarioRoute {
	public async index(req: app.Request, res: app.Response) {
		res.send("Eu sou o index do usuário...");
	}

	public async criar(req: app.Request, res: app.Response) {
		res.send("Criar usuário...");
	}

	public async listar(req: app.Request, res: app.Response) {
		res.send("Listar usuários...");
	}
}

export = UsuarioRoute;
