import app = require("teem");

class VendaRoute {
	public async index(req: app.Request, res: app.Response) {
		res.send("Eu sou o index da venda...");
	}

	public async efetivar(req: app.Request, res: app.Response) {
		res.send("Efetivar uma venda... bruno e gay");
	}

	public async listar(req: app.Request, res: app.Response) {
		res.send("Listar vendas...");
	}
}

export = VendaRoute;
