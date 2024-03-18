public class Professor implements Comparable<Professor> {
    // variaveis de instância
    private String nome;
    private int totalDeAulas;
    private double valorDaAula;
    private String titulacao;

    // metodo construtor --> Iniciializar os atributos do objeto construtor
    public Professor(String nome, int totalDeAulas, double valorDaAula, String titulacao) {
        this.nome = nome;
        this.totalDeAulas = totalDeAulas;
        this.valorDaAula = valorDaAula;
        this.titulacao = titulacao;
    }

    // método para calcular e retornar o valor do salario 
    public double calcularSalario() {
        double salarioBase = calcularSalarioBase();
        double horaAtividade = calcularHoraAtividade(salarioBase);
        double descansoSemanal = calcularDescansoSemanal(salarioBase, horaAtividade);
        return (salarioBase + horaAtividade - descansoSemanal);
    }

    private double calcularDescansoSemanal(double salarioBase, double horaAtividade) {
        return (salarioBase + horaAtividade) / 6;
    }

    private double calcularHoraAtividade(double salarioBase) {
        return salarioBase * 0.05;
    }

    private double calcularSalarioBase() {
        double salario = totalDeAulas * valorDaAula * 4.5;
        if(titulacao.equalsIgnoreCase("mestre")){
            salario *= 1.085;
        } 
        else {
            salario *= 1.12;
        }
        return salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTotalDeAulas() {
        return totalDeAulas;
    }

    public void setTotalDeAulas(int totalDeAulas) {
        this.totalDeAulas = totalDeAulas;
    }

    public double getValorDaAula() {
        return valorDaAula;
    }

    public void setValorDaAula(double valorDaAula) {
        this.valorDaAula = valorDaAula;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    @Override
    public int compareTo(Professor p) {
        return (int)(calcularSalario() - p.calcularSalario());
        // if(calcularSalario() == p.calcularSalario()){
        //     return 0;
        // }
        // else if(calcularSalario() > p.calcularSalario()){
        //     return 1;
        // }
        // return -1;
    }
}