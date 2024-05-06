// import java.util.Scanner;

// public class ExpoenteBase {
//     public static void main(String[] args) {

//         Scanner entrada = new Scanner(System.in);

//         System.out.println("Informe a base do numero: ");
//         long base = entrada.nextLong();

//         System.out.println("Informe o expoente do numero: ");
//         long expoente = entrada.nextLong();
        
//         long result = calcularPotencia(base, expoente);

//         System.out.println(base + "elevado a " + expoente + "é igual a " + result);

//     }

//     public static long calcularPotencia(long base, long expoente) {
//         if(expoente == 0) return 1;

//         if(expoente == 1) return base;

//         long resultadoMetade = calcularPotencia(base, expoente / 2);

//         if(expoente % 2 == 0){
//             return resultadoMetade * resultadoMetade;
//         } else {
//             return resultadoMetade * resultadoMetade * base;
//         }
//     }

// }


// Prof
import java.util.Scanner;

public class ExpoenteBase {

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);
        int x, n;

        System.out.println("base --> ");
        x = teclado.nextInt();

        System.out.println("expoente --> ");
        n = teclado.nextInt();

        System.out.println(calcular(x, n));
    }

    private static int calcular(int x, int n) {
        //caso base
        if(n == 0) return 1;
        return x * calcular(x, n - 1);
    }
}