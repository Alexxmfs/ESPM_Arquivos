import java.util.Random;

public class Linear {
    public static void main(String[] args) throws Exception {
            
        int[] x = new int[10];
        lerDados(x);

    }

    private static void lerDados(int[] x) {
        Random rd = new Random();
        for (int index = 0; index < x.length; index++) {
            x[index] = rd.nextInt(10, 50);
        }
    }
}
