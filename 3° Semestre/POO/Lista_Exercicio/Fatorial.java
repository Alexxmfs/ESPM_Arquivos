public class Fatorial {
    public static void main(String[] args) {
        System.out.println("1. Fatorial de 5: " + fatorial1(5));
        System.out.println("2. Fatorial de 5: " + fatorial2(5));
    }

    private static int fatorial1(int n){
        int f = 1;
            for(int i = 1; i <= n; i++) f *= i;
                return f;
            }

    private static int fatorial2(int n){
        return n == 0 ? 1 : n * fatorial2(n - 1);
    }
}