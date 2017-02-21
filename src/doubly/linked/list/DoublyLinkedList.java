package doubly.linked.list;

import doubly.linked.list.Node;

public class DoublyLinkedList {

	private Node header; // always referencing the dummy node
	private Node lastNode;
	private int size;

	public DoublyLinkedList() {
		header = new Node(null);
		lastNode = header;
	}

	public void append(Integer data) {
		Node n = new Node(data);
		if (size == 0) {
			header.next = n;
			n.prev = header;
			lastNode = n;
			size++;
		} else {
			lastNode.next = n;
			n.prev = lastNode;
			lastNode = n;
			size++;
		}
	}
	
	public void removeFirst() {
		if (size != 0) {
			header.next = header.next.next;
			header.next.prev = header;
			size--;
		}
	}
	
	public void removeLast() {
		if (size == 1) {
			lastNode = header;
			header.next = null;
			size--;
		} else if (size != 0){
			lastNode = lastNode.prev;
			lastNode.next = null;
			size--;
		}
	}

	public void prepend(Integer data) {
		Node n = new Node(data);
		if (size == 0) {
			header.next = n;
			lastNode = n;
			n.prev = header;
			size++;
		} else {
			n.next = header.next;
			header.next.prev = n;
			n.prev = header;
			header.next = n;
			size++;
		}
	}
	
	public void insertAt(int index, Integer data) {
		if (index <= 0 || index > size + 1) {
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
			first.next.prev = n;
			n.next = first.next;
			first.next = n;
			n.prev = first;
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
			n.next.prev = n;
			size--;
		}
	}
	
	public String printReverse() {
		Node n = lastNode;
		String temp = "";
		int tempSize = size;
		while (tempSize != 0) {
			temp += n.data + " ";
			n = n.prev;
			tempSize--;
		}
		return temp;
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
