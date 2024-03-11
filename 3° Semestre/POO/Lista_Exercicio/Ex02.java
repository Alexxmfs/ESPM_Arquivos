public class Ex02 {
    public static void main(String[] args) {
        int sum = 0;
        int a = 1;
        int b = 2;
        int c = 0;
        while(b < 4000000) {
            if(b % 2 == 0) {
                sum = sum + b;
            }
            c = a + b;
            a = b;
            b = c;
        }
        System.out.println("Fibonacci é: " + sum);
    }
}
