import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws Exception {
        String caminho = "venda.txt";
        BufferedReader br = null;
        FileReader fr = null;

        try {
            fr = new FileReader(caminho);
            br = new BufferedReader(fr);

            String linha;
            System.out.println("Valores de Vendas:");
            while ((linha = br.readLine()) != null) {
                // Converte a linha lida para o tipo double e imprime
                double valorVenda = Double.parseDouble(linha);
                System.out.println(valorVenda);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Erro ao converter valor para double: " + e.getMessage());
        } finally {
            try {
                if(br != null){
                    br.close();
                }
                if(fr != null){
                    fr.close();
                }
            } catch (IOException e) {
                System.err.println("Erro ao fechar o arquivo: " + e.getMessage());
            }
        }
    }
}