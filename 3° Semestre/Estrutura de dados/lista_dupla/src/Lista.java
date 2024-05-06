public class Lista {
    No inicio, fim;
    int tamanho;

    // método para inserir um elemento no final da lista
    public void inserirFinal(String nome, int ra){
        No aux = new No(nome, ra);

        if(tamanho == 0){
            inicio = aux;
            fim = aux;
        } else {
            fim.dir = aux;
            aux.esq = fim;
        }
        fim = aux;
        tamanho++;
    }


    // método para inserir um elemento no inicio da lista
    public void inserirInicio(String nome, int ra){
        No aux = new No(nome, ra);
        
        if(tamanho == 0){
            inicio = aux;
            fim = aux;
        } else {
            aux.dir = inicio;
            inicio.esq = aux;
            inicio = aux;
        }
        tamanho++;
    }

    // método para pesquisar um elemento (deverá ser retornado o endereço do elemento)
    public No pesquisar(int ra){
        No aux = inicio;
        while(aux != null){
            if(aux.ra == ra){
                return aux;
            }
            aux = aux.dir;
        }
        return null;         
    } 

    // método para remover um elemento da lista
    public boolean remover(int ra){
        No aux = pesquisar(ra);
        boolean status = false;

        if(aux != null){
            // caso 1 --> lista tem apenas um elemento
            if(tamanho == 1){
                inicio = null;
                fim = null;
            } 
            else if(aux == inicio){ // caso 2 --> remoção no inicio
                aux.dir = null;
                aux.dir.esq = null;
                inicio = aux.dir;
            }
            else if(aux == fim){ // caso 3 --> remoção  no final da lista
                aux.esq.dir = null;
                fim = aux.esq;
                aux.esq = null;
            } 
            else { // caso 4 --> remoção de um elemento no meio da lista
                aux.esq.dir = aux.dir;
                aux.dir.esq = aux.esq;
                aux.esq = null;
                aux.dir = null;
            }
            aux = null;
            status = true;
            tamanho--;
        }
        return status;
    }
}