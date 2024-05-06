public class App2 {
    public static void main(String[] args) {
        Lista<Aluno> lista = new Lista<>();
        lista.inserirFinal(new Aluno(1, "Kleiton"));
        lista.inserirFinal(new Aluno(2, "Marchinho da Quebrada"));

        System.out.println(lista.listar());
        
    }
}
