
public class AVLTree<T extends Comparable<T>> {
	private No<T> raiz;

	public void inserir(T dado) {
		this.raiz = inserir(this.raiz, dado);
	}

	private No<T> inserir(No<T> no, T dado) {
		if (no == null) {
			return new No<T>(dado);
		}

		if (dado.compareTo(no.getDado()) < 0) {
			no.setEsq(inserir(no.getEsq(), dado));
		} else if (dado.compareTo(no.getDado()) > 0) {
			no.setDir(inserir(no.getDir(), dado));
		} else {
			// nó já existe na árvore AVL
			return no;
		}

		// atualiza a altura do nó correnete
		no.setAltura(1 + Math.max(getAltura(no.getEsq()), getAltura(no.getDir())));

		// verifica se a árvore está desbalanceada para realizar as rotações
		int fatorBalanceamento = getFatorBalanceamento(no);

		if (fatorBalanceamento > 1 && dado.compareTo(no.getEsq().getDado()) < 0) {
			return rotacaoDireita(no);
		}

		if (fatorBalanceamento < -1 && dado.compareTo(no.getDir().getDado()) > 0) {
			return rotacaoEsquerda(no);
		}

		if (fatorBalanceamento > 1 && dado.compareTo(no.getEsq().getDado()) > 0) {
			no.setEsq(rotacaoEsquerda(no.getEsq()));
			return rotacaoDireita(no);
		}

		if (fatorBalanceamento < -1 && dado.compareTo(no.getDir().getDado()) < 0) {
			no.setDir(rotacaoDireita(no.getDir()));
			return rotacaoEsquerda(no);
		}

		return no;
	}

	// método para realizar a rotação a direita
	private No<T> rotacaoDireita(No<T> no) {
		No<T> novaRaiz = no.getEsq();
		No<T> subtreeDireita = novaRaiz.getDir();

		novaRaiz.setDir(no);
		no.setEsq(subtreeDireita);

		no.setAltura(1 + Math.max(getAltura(no.getEsq()), getAltura(no.getDir())));
		novaRaiz.setAltura(1 + Math.max(getAltura(novaRaiz.getEsq()), getAltura(novaRaiz.getDir())));

		return novaRaiz;
	}

	// método para realizar a rotação a esquerda
	private No<T> rotacaoEsquerda(No<T> no) {
		No<T> novaRaiz = no.getDir();
		No<T> subtreeEsquerda = novaRaiz.getEsq();

		novaRaiz.setEsq(no);
		no.setDir(subtreeEsquerda);

		no.setAltura(1 + Math.max(getAltura(no.getEsq()), getAltura(no.getDir())));
		novaRaiz.setAltura(1 + Math.max(getAltura(novaRaiz.getEsq()), getAltura(novaRaiz.getDir())));

		return novaRaiz;
	}

	// método para retornar a altura de um nó
	private int getAltura(No<T> no) {
		if (no == null) {
			return 0;
		}
		return no.getAltura();
	}

	// método para calcular o fator de balanceamento de um nó
	private int getFatorBalanceamento(No<T> no) {
		if (no == null) {
			return 0;
		}
		return getAltura(no.getEsq()) - getAltura(no.getDir());
	}

	// método para fazer o percurso pré-ordem
	public String preOrdem() {
		return preOrdem(raiz);
	}	
	
	private String preOrdem(No<T> raiz) {
		String aux = "";
		if (raiz == null) {
			return "";
		}

		aux += raiz.getDado() + "\n";
		aux += preOrdem(raiz.getEsq());
		aux += preOrdem(raiz.getDir());
		return aux;
	}
	
	// método para realizar a remoção de um nó em uma árvore AVL
	public void remover(T dado) {
	    raiz = remover(raiz, dado);
	}

	// método para pesquisar um elemento em uma árvore AVL
	public No<T> pesquisar(T dado) {
		return pesquisar(raiz, dado);
	}
	
	private No<T> pesquisar(No<T> raiz, T dado) {
		if(raiz == null || raiz.getDado().equals(dado)) return raiz;
		
		if(dado.compareTo(raiz.getDado()) > 0) return pesquisar(raiz.getDir(), dado);
		
		return pesquisar(raiz.getEsq(), dado);
		
	}
	
	private No<T> remover(No<T> no, T dado) {
	    if (no == null) {
	        return no;
	    }

	    if (dado.compareTo(no.getDado()) < 0) {
	        no.setEsq(remover(no.getEsq(), dado));
	    } else if (dado.compareTo(no.getDado()) > 0) {
	        no.setDir(remover(no.getDir(), dado));
	    } else {
	        // nó encontrado para remoção
	        // caso 1: o nó não tem filhos ou tem apenas um
	        if (no.getEsq() == null || no.getDir() == null) {
	            No<T> noFilho = (no.getEsq() == null) ? no.getDir() : no.getEsq();

	            // nó não tem filhos
	            if (noFilho == null) {
	                no = null;
	            } else {
	                no = noFilho;
	            }

	        // caso 2: o nó tem dois filhos
	        } else {
	            // busca pelo sucessor (menor valor na subarvore direita)
	            No<T> successor = no.getDir();
	            while (successor.getEsq() != null) {
	                successor = successor.getEsq();
	            }
	            
	            // copia o valor do sucessor para o nó corrente
	            no.setDado(successor.getDado());

	            // remove o sucessor da subarvore direita
	            no.setDir(remover(no.getDir(), successor.getDado()));
	        }
	    }

	    // retorna null se o nó não foi encontrado
	    if (no == null) {
	        return null;
	    }

	    // atualiza a altura do nó corrente
	    no.setAltura(1 + Math.max(getAltura(no.getEsq()), getAltura(no.getDir())));

	    // a árvore está desbalanceada? Se estiver, aplica as rotações
	    int fatorBalanceamento = getFatorBalanceamento(no);

	    if (fatorBalanceamento > 1 && getFatorBalanceamento(no.getEsq()) >= 0) {
	        return rotacaoDireita(no);
	    }

	    if (fatorBalanceamento > 1 && getFatorBalanceamento(no.getEsq()) < 0) {
	        no.setEsq(rotacaoEsquerda(no.getEsq()));
	        return rotacaoDireita(no);
	    }

	    if (fatorBalanceamento < -1 && getFatorBalanceamento(no.getDir()) <= 0) {
	        return rotacaoEsquerda(no);
	    }

	    if (fatorBalanceamento < -1 && getFatorBalanceamento(no.getDir()) > 0) {
	        no.setDir(rotacaoDireita(no.getDir()));
	        return rotacaoEsquerda(no);
	    }

	    return no;
	}


}
