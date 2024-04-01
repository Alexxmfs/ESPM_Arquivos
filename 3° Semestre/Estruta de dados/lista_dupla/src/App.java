public class App {
    public static void main(String[] args) throws Exception {
        
        Lista lista = new Lista();

        lista.inserirFinal("Selmini", 1);
        lista.inserirFinal("Sandra", 2);
        lista.inserirInicio("Surian", 3);
        lista.inserirInicio("Flávio", 4);

        // System.out.println(lista.pesquisar(3));
        System.out.println(lista.remover(1));
        System.out.println(lista.remover(3));
        System.out.println(lista.remover(2));
        System.out.println(lista.remover(20));
    }
}
