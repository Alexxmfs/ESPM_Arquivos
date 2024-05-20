public class Arvore<T  extends Comparable<T>> {

    No<T> raiz;

    public void inserir(T dado) {
        raiz = inserir(raiz, dado);
    }

    // método recursivo auxiliar para inserção na árvore
    private No<T> inserir(No<T> ref, T dado){
        if(ref == null){
            return new No<>(dado);
        }
        
        if(dado.compareTo(ref.dado) > 0){
            ref.dir = inserir(ref.dir, dado);
        }

        if(dado.compareTo(ref.dado) < 0){
            ref.esq = inserir(ref.esq, dado);
        }

        return ref;
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
