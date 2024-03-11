import java.util.Scanner;

public class Fatorial {
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);

        long n;
        
        System.out.println("Informe um valor inteiro e positivo");
        n = entrada.nextLong();

        System.out.println("fatorial = " + fatorial(n));

    }

    public static long fatorial(long n){
        // caso base
        if(n == 1) return 1;
            return n * fatorial(n - 1);
    }
}
