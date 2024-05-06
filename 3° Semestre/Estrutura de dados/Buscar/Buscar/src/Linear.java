import java.util.Arrays;
import java.util.Random;

public class Linear {
    public static void main(String[] args) throws Exception {
            
        int[] x = new int[10];
        lerDados(x);
        Arrays.sort(x);
        imprimir(x);
        System.out.println();
        System.out.println(buscaBinaria(x, 15));
        System.out.print(buscaBinaria(x, 15));
        System.out.println(Arrays.binarySearch(x, 15));
    }

    private static void lerDados(int[] x) {
        Random rd = new Random();
        for (int index = 0; index < x.length; index++) {
            x[index] = rd.nextInt(10, 30);
        }
    }

    public static void imprimir(int[] x){
        for(int i : x){
            System.out.println(i + " ");
        }
    }

    public static int buscaBinaria(int[] x, int valor){
        int posicao = -1;
        int inicio = 0;
        int fim = x.length - 1;
        while(inicio < fim) {
            int meio = (inicio + fim) / 2;
            if(x[meio] == valor){
                posicao = meio;
                break;
            } 
            if(valor > x[meio]){
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return posicao;
    }
}
