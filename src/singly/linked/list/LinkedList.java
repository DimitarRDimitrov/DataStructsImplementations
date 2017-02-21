package singly.linked.list;

public class LinkedList {

	private Node header; // always referencing the dummy node
	private Node lastNode;
	private int size;

	public LinkedList() {
		header = new Node(null);
		lastNode = header;
	}

	public void append(Integer data) {
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
	
	public void removeFirst() {
		if (size != 0) {
			header.next = header.next.next;
			size--;
		}
	}
	
	public void removeLast() {
		if (size == 1) {
			lastNode = header;
			header.next = null;
			size--;
		} else if (size != 0){
			Node temp = header.next;
			int counter = 1;
			while (counter < size-1) {
				temp = temp.next;
				counter++;
			}
			temp.next = null;
			lastNode = temp;
			size--;
		}
	}

	public void prepend(Integer data) {
		Node n = new Node(data);
		if (size == 0) {
			header.next = n;
			lastNode = n;
			size++;
		} else {
			Node temp = header.next;
			header.next = n;
			n.next = temp;
			size++;
		}
	}
	
	public void insertAt(int index, Integer data) {
		if (index <= 0 || index > size) {
			return;
		} else if (index == 1)
			prepend(data);
		else if (index == size + 1)
			append(data);
		else {
			Node n = new Node(data);
			Node first = header.next;
			int count = 1;
			while (count != index - 1) {
				first = first.next;
				count++;
			}
			n.next = first.next;
			first.next = n;
			size++;
		}
	}
	
	public void removeAt(int index) {
		if (index <= 0 || index > size) {
			return;
		} else if (index == 1) 
			removeFirst();
		else if (index == size) 
			removeLast();
		else {
			int counter = 1;
			Node n = header.next;
			while (counter < index - 1) {
				n = n.next;
				counter++;
			}
			n.next = n.next.next;
			size--;
		}
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

}
