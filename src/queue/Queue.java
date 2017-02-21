package queue;

public interface Queue {
	public void enqueue(int data);
	public Integer dequeue();
	public boolean isEmpty();
//	public boolean isFull();
	public int getSize();
	public Integer peek();

}
