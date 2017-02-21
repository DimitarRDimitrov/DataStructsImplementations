package queue;

import queue.Node;

public class QueueLinkedList implements Queue{

	private Node header; // always referencing the dummy node
	private Node lastNode;
	private int size;

	public QueueLinkedList() {
		header = new Node(null);
		lastNode = header;
	}

	
	public int getSize() {
		return size;
	}

	public String toString() {
		Node n = header.next;
		String temp = "";
		while (n != null) {
			temp = temp + n.data + " ";
			n = n.next;
		}
		return temp;
	}

	@Override
	public void enqueue(int data) {
		Node n = new Node(data);
		if (size == 0) {
			header.next = n;
			lastNode = n;
			size++;
		} else {
			lastNode.next = n; //second to last referencing the last element
			lastNode = n; //making the reference point towards the last element
			size++;
		}
		
	}

	@Override
	public Integer dequeue() {
		Node temp;
		if (size != 0) {
			temp = header.next;
			header.next = header.next.next;
			size--;
			return temp.data;
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}



	@Override
	public Integer peek() {
		if(size != 0){
			return header.next.data;
		}
		return null;
	}

}
