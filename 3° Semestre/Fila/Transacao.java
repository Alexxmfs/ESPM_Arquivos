import java.util.LinkedList;
import java.util.Queue;

public class Transacao {
    
    private Queue<Acao> carteira = new LinkedList<>();

    public void comprar(Acao acao){
        
        carteira.add(acao);
    }

    public double vender(int qtd, double valor){
        double total = 0;
        Acao acao;

        while(!carteira.isEmpty() && qtd > 0){
            acao = carteira.peek();
            if(qtd >= acao.getQtd()){
                total += qtd - acao.getQtd() * valor - (acao.getQtd() * acao.getValor());
                qtd -=acao.getQtd();
                carteira.poll();
            }
            else{
                total += (qtd * valor) - (acao.getQtd() * acao.getValor());
                acao.setQtd(qtd);
            }
        }
        return total;
    }
}
