package priority.queue;

public class PriorityQueueArray implements MinPriorityQueue {

	private int size;
	private int header = -1; //index of the minimal element
	private int tail = -1;
	private int[] array;
	
	public PriorityQueueArray() {
		array = new int[10];
	}

	public void resize() {
		int[] temp = new int[array.length * 2];
		for (int i = 0; i < size; i++) {
			temp[i] = array[(header + i) % array.length];
		}
		array = temp;
		header = 0;
		tail = size - 1;
	}
	
	public String toString() {
		String temp = "";
		for (int i = 0; i < size; i++) {
			temp = temp + array[(header+1) % array.length] + " ";
		}
		return temp;
	}
	
	public Integer peek() {
		if(isEmpty()){
			return null;
		}
		return array[header];
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
	
	public void insert(int key) {
		if(isFull())
			resize();
		if(isEmpty()){
			header = 0;
			tail = 0;
			size++;
			array[0] = key;
		} else {
			tail = (tail+1) % array.length;
			array[tail] = key;
			if (key < array[header]) {
				int temp = array[header];
				array[header] = key;
				array[tail] = temp;
			}
			size++;
		}
	}

	public Integer deleteMinKey() {
		if(isEmpty())
			return null;
		else if (header == tail) {
			int temp = array[header];
			header = -1;
			tail = -1;
			size = 0;
			return temp;
		} else {
			int temp = array[header];
			header = (header + 1) % array.length;
			size--;
			
			int min = findMinKeyIndex();
			if (array[min] < array[header]) {
				int tempVal = array[header];
				array[header] = array[min];
				array[min] = tempVal;
			}
			return temp;
		}
	}

	public int findMinKeyIndex() {
		int min = header;
		for(int i = 1; i < size; i++) {
			int currentIndex = (header + i) % array.length;
			if(array[currentIndex] < array[min])
				min = currentIndex;
		}
		return min;
	}

	
	
}
