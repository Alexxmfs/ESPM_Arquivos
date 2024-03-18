import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Professor[] professor = new Professor[3];
        professor[0] = new Professor("Alek", 20, 210, "doutor");
        professor[1] = new Professor("Rafa", 40, 150, "mestre");
        professor[2] = new Professor("Ana", 25, 210, "doutor");

        for(Professor p : professor) {
            System.out.println(p.getNome());
            System.out.println(p.calcularSalario());
            System.out.println();
        }

        Arrays.sort(professor);
    }
}
