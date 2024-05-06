public class Aluno extends Object {
    int ra;
    String nome;

    public Aluno(int ra, String nome) {
        this.ra = ra;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "ra: " + ra + " -- nome: " + nome;
    }
}
