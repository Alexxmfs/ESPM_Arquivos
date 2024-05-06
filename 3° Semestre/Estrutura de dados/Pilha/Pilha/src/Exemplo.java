import java.util.Stack;

public class Exemplo {
    public static void main(String[] args) {
        
        int valor = 15;
        Stack<Integer> pilha = new Stack<>();

        while (valor > 0) {
            pilha.push(valor % 2);
            valor = valor / 2;
        }

        while(!pilha.isEmpty()){
            System.out.print(pilha.peek());
            pilha.pop();
        }

    } 
}
