public class Exercicio4 {
    public static void main(String[] args) {
        long a = 100;
        long b = 10;

        long resultado = multiplicar(a, b);
        System.out.println(resultado);
    }

    public static long multiplicar(long a, long b) {
        if(a == 0 || b == 0) return 0;
        return a + multiplicar(a, b -1);
    }
}
