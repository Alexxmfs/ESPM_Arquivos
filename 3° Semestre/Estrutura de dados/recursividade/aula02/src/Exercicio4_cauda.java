public class Exercicio4_cauda {
    public static void main(String[] args) {
        long a = 100;
        long b = 30;

        long resultado = multiplicar(a, b, 0);
        System.out.println(resultado);
    }

    public static long multiplicar(long a, long b, long parcial) {
        if(a == 0 || b == 0) return parcial;
        return multiplicar(a, b - 1, parcial + a);
    }
}
