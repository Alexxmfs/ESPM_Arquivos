public class App {
    public static void main(String[] args) throws Exception {
       
        AVLTree<Integer> tree = new AVLTree<>();
		tree.inserir(44);
		tree.inserir(62);
		tree.inserir(50);
		tree.inserir(17);
		tree.inserir(32);
		tree.inserir(78);
		tree.inserir(54);
		tree.inserir(48);
		tree.inserir(88);

		tree.remover(32);
		tree.inserir(52);
		tree.remover(62);

		System.out.println(tree.preOrdem());

    }
}
