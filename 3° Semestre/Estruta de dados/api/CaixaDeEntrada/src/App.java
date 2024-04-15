import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;

public class App {
    public static void main(String[] args) throws Exception {
        Lista<String> lista = new Lista<>();

        String menu = "";
        menu += "1 - Inserir\n2 - Pesquisar\n3 - Listar\n4 - Finalizar";
        int opcao = 0;

        do {
            opcao = parseInt(showInputDialog(menu));
            if(opcao < 1 || opcao > 4) {
                showMessageDialog(null, "Opção inválida");
            }
            else {
                switch(opcao) {
                    case 1:
                        lista.inserirFinal(showInputDialog("Qual seu nome?"));
                        break;
                    case 2:
                        String nome = showInputDialog("Qual nome deseja pesquisar?");
                        No<String> aux = lista.pesquisar(nome);
                        if(aux == null){
                            showMessageDialog(null, nome + " não foi encontrado");
                        }
                        else {
                            showMessageDialog(null, lista.pesquisar(nome + " foi encontrado"));
                        
                        }
                        break;
                    case 3:
                        showMessageDialog(null, lista.listar());
                }
            }
        } while(opcao != 4);
    }
}
