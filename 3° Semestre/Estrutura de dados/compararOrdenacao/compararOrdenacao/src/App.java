public class App {
    public static void main(String[] args) throws Exception {

        final int N = 1000;
        int[] x = new int[N];
        lerDados(x);

        System.out.println("bolha = " + bolha(x));
        System.out.println("selecao = " + selecao(x));
        System.out.println("insercao = " + insercao(x));

    }

    private static void lerDados(int[] x) {
        for (int i = 0; i < x.length; i++) {
            x[i] = x.length - i;
        }
    }

    private static int bolha(int[] v) {
        int aux;
        int total = 0;
        for (int j = 0; j < v.length; j++) {
            for (int i = 0; i < v.length - 1; i++) {
                if (v[i] > v[i + 1]) {
                    aux = v[i];
                    v[i] = v[i + 1];
                    v[i + 1] = aux;
                    total++;
                }
            }
        }
        return total;
    }

    public static int selecao(int[] x) {
        int menor, aux;
        int total = 0;
        for (int i = 0; i < x.length - 1; i++) {
            menor = i;
            for (int j = i + 1; j < x.length; j++) {
                if (x[j] < x[menor]) {
                    menor = j;
                    total++;
                }
            }
            aux = x[i];
            x[i] = x[menor];
            x[menor] = aux;
        }
        return total;
    }

    private static int insercao(int[] x) {
        int valor, i;
        int total = 0;
        for (int j = 1; j < x.length; j++) {
            valor = x[j];
            for (i = j - 1; i >= 0 && valor < x[i]; i--) {
                x[i + 1] = x[i];
                total++;
            }
            x[i + 1] = valor;
        }
        return total;
    }
}
