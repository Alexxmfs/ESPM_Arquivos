import java.util.Date;
import java.util.UUID;

public class Cliente {
    
    private String id = UUID.randomUUID().toString();
    private String cpf;
    private String name;
    private Date birthdate;

    
    public Cliente(String cpf){
        this.id = UUID.randomUUID().toString();
        this.cpf = cpf;
    }

    public Cliente(String cpf, String name){
        this(cpf);
        this.name = name;
    }
    
    public Date birthdate(){
        return birthdate;
    }

    public void setBirthdate(Date birthdate){
        this.birthdate = birthdate;
    }

    public String getName(){
        return name;
    }

    public String getId(){
        return id;
    }

    public String getCpf(){
        return cpf;
    }

    @Override
    public String toString(){
        return "Cliente [id =" + id
        + ", cpf =" + cpf
        + ", name =" + name
        + ", birthdate =" + birthdate
        + "]";
    }
}


