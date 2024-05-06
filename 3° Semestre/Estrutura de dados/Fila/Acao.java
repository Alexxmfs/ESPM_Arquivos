public class Acao {
    private int qtd;
    private double valor;
    
    public Acao(int qtd, double valor) {
        this.qtd = qtd;
        this.valor = valor;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }    
}
