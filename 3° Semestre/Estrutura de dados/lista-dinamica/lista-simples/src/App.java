public class App {
    public static void main(String[] args) throws Exception {
        
        Lista lista = new Lista();
        lista.inserirFim(-1);
        lista.inserirFim(-2);
        lista.inserirInicio(10);
        lista.inserirInicio(20);

        System.out.println("tamanho = " + lista.tamanho());
        lista.imprimir();
    }
}
