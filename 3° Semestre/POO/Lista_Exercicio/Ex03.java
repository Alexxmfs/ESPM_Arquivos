public class Ex03 {
    public static void main(String[] args) {

        long num = 600851475143L;
        long divisor = 0;
        long maiorDivisor = 0;
        for(long i = 2; i <= num; i++) {
            if(num % i == 0) {
                for(long j = 2; j < i; j++) {
                    if(i % j == 0) {
                        divisor = j;
                        break;
                    }
                }
                if(divisor == 0) {
                    maiorDivisor = i;
                    num = num / i;
                }
            }
        }
        System.out.println(maiorDivisor);
    }
}
