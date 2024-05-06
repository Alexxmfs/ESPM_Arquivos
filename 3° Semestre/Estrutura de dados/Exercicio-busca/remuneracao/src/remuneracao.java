import java.util.Scanner;
// Alek Codigin
public class remuneracao {
        public static void main(String[] args) {
        String tituloNenhum = "Nenhum aumento";
        String tituloMestre = "Mestre";
        String tituloDoutor = "Doutor";
        
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Insira o número de aulas semanais: ");
        int aulasSemanais = entrada.nextInt();
        entrada.nextLine();
        
        System.out.print("Insira o valor da hora-aula: ");
        double valorHoraAula = entrada.nextDouble();
        entrada.nextLine();
        
        System.out.print("Insira o título do professor (Nenhum aumento, Mestre, ou Doutor): ");
        String titulo = entrada.nextLine();
        
        int indiceTitulo = -1;
        if (titulo.equals(tituloNenhum)) {
            indiceTitulo = 0;
        } else if (titulo.equals(tituloMestre)) {
            indiceTitulo = 1;
        } else if (titulo.equals(tituloDoutor)) {
            indiceTitulo = 2;
        }
        
        double aumentoNenhum = 0.0;
        double aumentoMestre = 0.085;
        double aumentoDoutor = 0.12;
        
        double salarioBase = calcularSalarioBase(aulasSemanais, valorHoraAula, indiceTitulo, aumentoNenhum, aumentoMestre, aumentoDoutor);
        
        System.out.println("Salário Base: R$" + salarioBase);
        
        entrada.close();
    }

    public static double calcularSalarioBase(int aulasSemanais, double valorHoraAula, int indiceTitulo, double aumentoNenhum, double aumentoMestre, double aumentoDoutor) {
        double salarioBase = aulasSemanais * 4.5 * valorHoraAula;
        double aumento = 0.0;
        if (indiceTitulo >= 0 && indiceTitulo < 3) {
            if (indiceTitulo == 1) {
                aumento = aumentoMestre;
            } else if (indiceTitulo == 2) {
                aumento = aumentoDoutor;
            } else {
                aumento = aumentoNenhum;
            }
            salarioBase = salarioBase * (1 + aumento);
        }
        return salarioBase;
    }
}
