package doubly.linked.list;

public class Main {

	public static void main(String[] args) {

		DoublyLinkedList dl = new DoublyLinkedList();
		dl.prepend(1);
		dl.prepend(2);
		dl.prepend(3);
		System.out.println(dl);
		dl.append(4);
		dl.append(5);
		System.out.println(dl);
		dl.removeFirst();
		System.out.println(dl);
		dl.removeLast();
		System.out.println(dl);
		dl.insertAt(4, 550);
		System.out.println(dl);
		dl.removeAt(4);
		System.out.println(dl);
		System.out.println(dl.printReverse());
	}

}
