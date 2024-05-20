package br.espm.venda;

import br.espm.cargo.Cargo;
import br.espm.funcionario.Funcionario;

public class Venda {
    private Funcionario funcionario;
    private double valor;

    public Venda(Funcionario funcionario, double valor){
        this.funcionario = funcionario;
        this.valor = valor;
    }

    // método para calcular e retornar a comissão do funcionário
    public double calcularComissao(){
        Cargo cargo = funcionario.getCargo();
        double comissao = cargo.cal;

        return comissao;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}


