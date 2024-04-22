public class App2 {
    public static void main(String[] args) {
        
        Lista<Aluno> lista = new Lista<>();
        lista.inserirFinal(new Aluno(1, "Kleiton"));
        lista.inserirFinal(new Aluno(2, "Marcinho da Quebrada"));

        System.out.println(lista.listar());

        System.out.println(lista.pesquisar(new Aluno(1)));
        System.out.println(lista.remover(new Aluno(1)));
        System.out.println(lista.listar());


    }
}
