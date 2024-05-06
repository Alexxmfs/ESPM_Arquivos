public class ContabilidadeAcoes {

    public static void main(String[] args) {
        int[] precoCompra = {20, 24, 36}; 
        int[] quantidadeCompra = {100, 20, 200}; // Quantidade de ações compradas em cada lote
        int precoVenda = 30; // Preço de venda das ações
        int quantidadeVenda = 150; // Quantidade de ações vendidas

        int capitalObtido = calcularCapital(precoCompra, quantidadeCompra, precoVenda, quantidadeVenda);
        System.out.println("O capital obtido é: R$ " + capitalObtido);
    }

    public static int calcularCapital(int[] precoCompra, int[] quantidadeCompra, int precoVenda, int quantidadeVenda) {
        int capitalObtido = 0;
        int acoesRestantes = quantidadeVenda;
        int indexCompra = 0;

        while (acoesRestantes > 0 && indexCompra < precoCompra.length) {
            int quantidadeAtual = quantidadeCompra[indexCompra];
            int precoAtual = precoCompra[indexCompra];

            for (int i = 0; i < quantidadeAtual; i++) {
                if (acoesRestantes == 0) {
                    break;
                }
                int lucroPorAcao = precoVenda - precoAtual;
                capitalObtido += lucroPorAcao;
                acoesRestantes--;
            }
            indexCompra++;
        }
        return capitalObtido;
    }
}