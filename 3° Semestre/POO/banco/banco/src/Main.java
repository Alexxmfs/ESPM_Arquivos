import java.util.Date;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Bank banco = new Bank("ESPM Bank");
        Conta c1 = new Conta();
        Cliente cliente = new Cliente("123456789", "Alex");
        cliente.setBirthdate(new Date());

        System.out.println(c1 + "  " + cliente);

        System.out.println(banco.getContas());
        System.out.println(banco.getName());

        System.out.println("Nome: " + cliente.getName());
        System.out.println("Data Nascimento: " + cliente.birthdate());

        System.out.println("c1: "+ c1.getId() + " -> " + c1.getSaldo());
        c1.depositar(100);
        System.out.println("c1: "+ c1.getId() + " -> " + c1.getSaldo());

        c1.sacar(120);
        System.out.println("c1: "+ c1.getId() + " -> " + c1.getSaldo());

        c1.sacar(30);
        System.out.println("c1: "+ c1.getId() + " -> " + c1.getSaldo());
        
        c1.sacar(40);
        System.out.println("c1: "+ c1.getId() + " -> " + c1.getSaldo());

    }
}
