public class Ex04 {
    public static void main(String[] args) {
        int maiorPalindromo = 0;
        for (int i = 100; i < 1000; i++) {
            for (int j = 100; j < 1000; j++) {
                int produto = i * j;
                String produtoStr = Integer.toString(produto);
                boolean Palindromo = true;
                for (int k = 0; k < produtoStr.length() / 2; k++) {
                    if (produtoStr.charAt(k) != produtoStr.charAt(produtoStr.length() - 1 - k)) {
                        Palindromo = false;
                        break;
                    }
                }
                if (Palindromo && produto > maiorPalindromo) {
                    maiorPalindromo = produto;
                }
            }
        }
        System.out.println("O maior palíndromo obtido é: " + maiorPalindromo);
    }
}