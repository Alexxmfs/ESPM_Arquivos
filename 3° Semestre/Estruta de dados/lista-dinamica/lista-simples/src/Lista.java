public class Lista {
    No inicio, fim;

    // método para inserir um elemento no final da lista 
    public void inserirFim(int valor){
        No aux = new No();
        aux.dado = valor;
        
        if(inicio == null){
            inicio = aux;
            fim = aux;
        }
        else {
            fim.prox = aux;
            fim = aux;
        }
        fim = aux;
    }
    // método par inserir um elemento no inicio da lista
    public void inserirInicio(int valor){
        No aux = new No();
        aux.dado = valor;

        if(inicio == null){
            inicio = aux;
            fim = aux;
        }
        else {
            aux.prox = inicio;
        }
        inicio = aux;
    }

    // método para retornar o tamanho da lista (quantidade de nós)
    public int tamanho(){
        int total = 0;
        No aux = inicio;
        while(aux != null){
            total++;
            aux = aux.prox;
        }
        return total;
    }
    
    // método para pesquisar um elemento na lista
    public boolean pesquisar(int valor){
        No aux = inicio;
        for(int i = 1; i  <= tamanho(); i++){
            if(aux.dado == valor){
                return true;
            }
            aux = aux.prox;
        }
        return false;
    }
    

    // método para imprimir os elemnentos da lista
    public void imprimir(){
        No aux = inicio;
        for(int i = 1; i <= tamanho(); i++){
            System.out.println(aux.dado);
            aux = aux.prox;
        }
    }
}