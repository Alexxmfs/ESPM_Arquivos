import java.util.Scanner;

public class Fibonnaci {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        int p;

        System.out.println("Qual a posição ");
        p = teclado.nextInt();

        System.out.println(calcular(p));

        teclado.close();
        
    }

    private static int calcular(int p) {
        // caso base
        if(p < 3) return 1;
        return calcular(p - 1) + calcular(p - 2);
    }
}
