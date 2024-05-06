public class Lista<T> {
    No<T> inicio, fim;
    int tamanho;

    // método para inserir um elemnto no final da lista

    public void inserirFinal(T dado) {
        No<T> aux = new No<T>(dado);
        if (tamanho == 0) {
            inicio = aux;
        } else {
            fim.dir = aux;
            aux.esq = fim;
        }
        fim = aux;
        tamanho++;
    }

    // método para inserir um elemento no início da lista

    public void inserirInicio(T dado) {
        No<T> aux = new No<T>(dado);
        if (tamanho == 0) {
            fim = aux;
        } else {
            aux.dir = inicio;
            inicio.esq = aux;
        }
        inicio = aux;
        tamanho++;
    }

    // método para pesquisar um elemento (deverá ser retonado o endereço do
    // elemento)

    public No<T> pesquisar(T dado) {
        No<T> aux = inicio;
        while (aux != null) {
            if (aux.dado.equals(dado)) {
                return aux;
            }
            aux = aux.dir;
        }
        return aux;
    }

    // método para remover um elemento da lista

    public boolean remover(T dado) {
        No<T> aux = pesquisar(dado);
        boolean status = false;

        if (aux != null) {
            // caso 1 --> lista tem apenas um elemento
            if (tamanho == 1) {
                inicio = null;
                fim = null;
            }
            else if (aux == inicio) { // caso 2 --> remoção no início
                aux.dir.esq = null;
                inicio = aux.dir;
                aux.dir = null;
            } else if (aux == fim) { // caso 3 --> remoção no final da lista
                aux.esq.dir = null;
                fim = aux.esq;
                aux.esq = null;
            } else { // caso 4 --> remoção no meio da lista
                aux.esq.dir = aux.dir;
                aux.dir.esq = aux.esq;
                aux.dir = null;
                aux.esq = null;
            }
            aux = null;
            status = true;
            tamanho--;
        }
        return status;
    }

    //método para percorrer a lista e reortnar os elementos para impressão

    public String listar() {
        No<T> aux = inicio;
        String msg = "";
        while (aux != null) {
            msg += aux.dado + "\n";
            aux = aux.dir;
        }
        return msg;
    }
}
