import java.util.Scanner;

public class Mdc2valores {
    public static void main(String[] args) {
        int m;
        int n;

        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite o valor de m: ");
        m = entrada.nextInt();

        System.out.println("Digite o valor de n: ");
        n = entrada.nextInt();

        int mdc = calcularMDC(m, n);
        System.out.println("MDC de " + m + " e " + n + " é: " + mdc);
    }
    
    public static int calcularMDC(int m, int n) {
        if (n > m) {
            return calcularMDC(n, m);
        } else if (n == 0) {
            return m;
        } else {
            return calcularMDC(n, m % n);
        }
    }
}

// prof sellmini
// public class Mdc2valores {
//     public static void main(String[] args) {
//         int m = 60;
//         int n = 20;
//         System.out.println(mdc(m, n));
//     }

//     private static int mdc(int m, int n) {
//         if(n == 0) return m;
//         if(n > m) return mdc(m, n);
//         return mdc(n, m % n);
//     }
// }