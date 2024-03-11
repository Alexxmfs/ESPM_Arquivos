public class Vetor {
    public static void main(String[] args) {
        
        int[] lira = new int[10];

        for(int i = 0; i < lira.length; i++){
            lira[i] = (int) (Math.random() * 150);
        }

        for(int i = 0; i < lira.length; i++){
            System.out.println(lira[i]);
        }

    }
}
