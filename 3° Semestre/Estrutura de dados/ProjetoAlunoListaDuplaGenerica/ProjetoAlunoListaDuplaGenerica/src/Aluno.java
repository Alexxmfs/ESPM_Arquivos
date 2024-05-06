public class Aluno {
    int ra;
    String nome;

    public Aluno(int ra, String nome) {
        this.ra = ra;
        this.nome = nome;
    }

    public Aluno(int ra) {
        this.ra = ra;
    }

    @Override
    public String toString() {
        return "ra: " + ra + " -- nome: " + nome;
    }

    @Override
    public boolean equals(Object obj){
        Aluno aluno = (Aluno) obj; // downcast
        return this.ra == aluno.ra;
    }

}
