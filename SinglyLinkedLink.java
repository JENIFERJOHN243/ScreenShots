package task;


public class SinglyLinkedLink {

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.insertFirst(3);
		list.insertFirst(2);
		list.insertFirst(1);
		list.display();
		System.out.println("\ninsert at 0-----");
		list.insertAtPosition(0, 9);
		list.display();
		System.out.println("\ninsert at 1-----");
		list.insertAtPosition(1, 24);
		list.display();
		System.out.println("\ninsert at 5-----");
		list.insertAtPosition(5, 98);
		list.display();
	}

}
