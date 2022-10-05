public class ArrayTree<E>{
	public ArrayTree(int order, int capacity) {
		//input is (2,25) and (5,55)
		int count = capacity-4;
		E array[];
		//rank(root) = 0
		//for parent at p child(p,c) = n*p+c+1
		//where 0<=c<n;
		root();
		for (int i = 0; i<capacity-4; i++) {
			array[i] = i++;
		}
	}
	public ArrayTree() {

	}
	public int root() {
		return 0;
	}
	public int size() {
		return 0;
	}
	public boolean isEmpty() {
		return true;
	}
	public int parent(int p) {
		return 0;
	}
	public int child(int p, int c) { //not sure why I am getting error
		return 0;
	}
	public int addRoot(E e) {
		return 0;
	}
//	public E get(int pos) {
//		return null;
//	}
	public int addChild(int parent, int child, E e) {
		return 0;
	}
//	public E getChild(int parent, int child) {
//		return null;
//	}
	public String toString() {
		return null;
	}
}
