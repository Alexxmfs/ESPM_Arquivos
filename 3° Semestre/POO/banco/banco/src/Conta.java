import java.util.UUID;

public class Conta {

    private static final double INITIAL_VALUE = 0;

    private String id = UUID.randomUUID().toString();
    private double limite = 50;
    private double saldo = INITIAL_VALUE;

    public String getId(){
        return id;
    }

    public double getSaldo(){
        return saldo;
    }

    public void depositar(double valor){
        if(valor > 0) saldo += valor;
    }

    public void sacar(double valor){
        if(valor < 0)
         throw new RuntimeException("Saque negativo não permitido");
        if(valor > saldo + limite)
            throw new RuntimeException("Saldo insuficiente");
        saldo -= valor;
    }
}
