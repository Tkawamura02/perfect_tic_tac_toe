package perfect_tic_tac_toe;

public class ArrayTree<E>{
	private int count = 0; //# array elements
	private int order = 2; //# child nodes
	private int size = 1000; //array size
	private E[] array;
	
	@SuppressWarnings("unchecked")
	public ArrayTree(int order, int capacity) {
		this.order = order;
		size = capacity;
		array = (E[]) new Object[capacity];
	}
	
	public int root() {
		return 0;
	}
	
	public int size() {
		return count;
	}
	
	public boolean isEmpty() {
		return count==0;
	}
	
	public int parent(int p) {
		return ((p-1)/order);
	}
	
	public int child(int p, int c) { 
		int pos = order * p + c + 1;
		if (pos > size || pos < 0) {
			return -1;
		} else 
			return pos;
	}
	
	public int addRoot(E e) {
		array[0] = e;
		count++;
		return 0;
	}
	
	public E get(int pos) {
		return array[pos];
	}
	
	public int addChild(int parent, int child, E e) {
		if (array[parent] != null) {
			child = child(parent,child);
			array[child] = e;
		}
		count++;
		return child;
	}
	
	public E getChild(int parent, int child) {
		if (array[parent] != null) {
			child = child(parent,child);
		}
		return array[child];
	}
	
	public String toString() {
		String beg = "[ArrayTree: order="+order + " count="+count + " size="+size + " array={ " ;
		String end = "";
        for(int i = 0; i < size; i++) {
            if(array[i] != null) {
                end += array[i] + " ";
            } else {
            	end += " - ";
            }
        }
        end = end + "}]";
        return beg+end;
	}
}