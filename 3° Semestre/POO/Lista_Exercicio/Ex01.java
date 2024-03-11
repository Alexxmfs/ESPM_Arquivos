public class Ex01 {
    public static void main(String[] args) {
        System.out.println("Exericios Sellmini");
        ex1();       
    }

        public static void ex1(){
            int soma = 0;

            for(int i = 0; i < 1000; i++)
                if(i % 3 == 0 || i % 5 == 0) soma += i;

            System.out.println("Soma: " + soma);
        }
}
