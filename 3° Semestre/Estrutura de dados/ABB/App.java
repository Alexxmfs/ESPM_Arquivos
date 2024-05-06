public class App {
    public static void main(String[] args) throws Exception {

        Arvore<Integer> arvore = new Arvore<>();
        arvore.inserir(30);
        arvore.inserir(40);
        arvore.inserir(24);
        arvore.inserir(58);

        arvore.emOrdem();

    }
}