import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner in = new Scanner(System.in);
        String nome;
        double nota1, nota2;

        System.out.println("Nome: ");
        nome = in.nextLine();

        System.out.println("Nota 1: ");
        nota1 = in.nextDouble();

        System.out.println("Nota 2: ");
        nota2 = in.nextDouble();

        Aluno aluno = new Aluno(nome, 0, nota1, nota2);

        System.out.println(aluno.calcularMedia());
        if(aluno.verificar()){
            System.out.println("Aprovado");
        } else {
            System.err.println("Reprovado");
        }
    }
}
