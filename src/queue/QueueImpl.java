package queue;

public class QueueImpl implements Queue {

	private int size;
	private int header = -1;
	private int tail = -1;
	private int[] array;

	public QueueImpl() {
		array = new int[10];
	}

	public QueueImpl(int size) {
		array = new int[size];
	}

	public void enqueue(int data) {
		if (isFull()) {
			resize();
		}
		if (isEmpty()) {
			header = 0;
			tail = 0;
			array[0] = data;
			size++;
		} else {
			tail = (tail + 1) % array.length;
			array[tail] = data;
			size++;
		}
	}

	private void resize() {
		int[] temp = new int[array.length * 2];
		for (int i = 0; i < size; i++) {
			temp[i] = array[(header + i) % array.length];
		}
		array = temp;
		header = 0;
		tail = size - 1;
	}

	public Integer dequeue() {
		if (isEmpty()) {
			return null;
		} else if (header == tail) {
			int temp = array[header];
			header = -1;
			tail = -1;
			size = 0;
			return temp;
		} else {
			int temp = array[header];
			header = (header + 1) % array.length;
			size--;
			return temp;
		}
	}

	public boolean isEmpty() {
		return (size == 0) ? true : false;
	}

	public boolean isFull() {
		if (array.length == size) {
			return true;
		}
		return false;
	}

	public int getSize() {
		return size;
	}

	public Integer peek() {
		// TODO Auto-generated method stub
		return null;
	}

}
