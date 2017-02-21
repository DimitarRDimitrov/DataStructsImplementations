package array.stack;

public class ArrayStackImpl implements ArrayStack {

	private int[] array;
	private int top = -1; // index of the element at the top
	private int size;
	
	public ArrayStackImpl() {
		array = new int[10];
	}
	
	public void ArrayStackIm(int size) {
		array = new int[size];
	}
	
	public void resize() {
		int[] newArray = new int[array.length * 2];
		for (int i = 0; i < array.length; i++) {
			newArray[i] = array[i];
		}
		array = newArray;
	}
	
			
	public Integer peek() {
		if (isEmpty()) {
			return null;
		}
		return array[top];
	}

	public Integer pop() {
		if (isEmpty()) {
			return null;
		}
		int temp = array[top];
		top--;
		size--;
		return temp;
	}


	public boolean isEmpty() {
		return (top == -1) ? true : false;
	}

	public void push(Integer i) {
		if (top == array.length) {
			resize();
		}
		top += 1;
		array[top] = i;
		size++;
	}

	public int getSize() {
		return size;
	}

}
