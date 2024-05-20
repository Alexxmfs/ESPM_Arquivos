public class No<T extends Comparable<T>> {
    private T dado;
    private int altura;
    private No<T> esq;
    private No<T> dir;
    
	public No(T dado) {
		this.dado = dado;
		this.altura = 1;
		this.esq = null;
		this.dir = null;
	}

	public T getDado() {
		return dado;
	}

	public void setDado(T dado) {
		this.dado = dado;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public No<T> getEsq() {
		return esq;
	}

	public void setEsq(No<T> esq) {
		this.esq = esq;
	}

	public No<T> getDir() {
		return dir;
	}

	public void setDir(No<T> dir) {
		this.dir = dir;
	}    
}
