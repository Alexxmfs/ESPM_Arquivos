public class Arvore<T  extends Comparable<T>> {

    No<T> raiz;

    public void inserir(T dado) {
        No<T> aux = new No<>(dado);
        if(raiz == null){
            raiz = aux;
        }
        else {
            inserirRecursivo(raiz, dado);
        }
    }

    // método recursivo auxiliar para inserção na árvore
    private void inserirRecursivo(No<T> ref, T dado){
        if(ref == null){
            ref = new No<>(dado);
        }
        
        if(dado.compareTo(ref.dado) > 0){
            inserirRecursivo(ref.dir, dado);
        }

        if(dado.compareTo(ref.dado) < 0){
            inserirRecursivo(ref.esq, dado);
        }
    }

    // método para imprimir os valores usando o percurso em-ordem
    public void emOrdem(){
            emOrdem(raiz);
        }

        // método recursivo interno para executar o percurso em-ordem
        private void emOrdem(No<T> ref){
            if(ref != null){
                emOrdem(ref.esq);
                System.out.println(ref.dado);
                emOrdem(ref.dir);
            }
        }
    }
