import java.util.Scanner;

public class Mdc {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        int valor;

        System.out.println("Informe um valor inteiro: ");
        valor = teclado.nextInt();

        System.out.println(calcular(valor));
    }

    public static int calcular(int valor) {
        // caso base
        if(valor == 0) return 0;
        return (valor % 10) + calcular(valor / 10);
    }
}
