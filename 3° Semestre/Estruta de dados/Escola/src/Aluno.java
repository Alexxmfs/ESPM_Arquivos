import java.util.Random;

public class Aluno {
    // atributos ou propriedades ou campos ou variaveis de instância
    int ra;
    String nome;
    double nota1;
    double nota2;

    public Aluno(String nome, int ra, double nota1, double nota2) {
        Random rd = new Random();
        ra = rd.nextInt(1000, 10000);
        this.ra = ra;
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    // método para calcular e retonar a média do aluno
    public double calcularMedia() {
        return (nota1 + nota2) / 2;
    }

    // método para verificar se o aluno está ou não aprovado
    public boolean verificar(){
        return calcularMedia() >= 7 ? true : false; 
    }
}