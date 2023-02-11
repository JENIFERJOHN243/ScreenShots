package task;

public class CircularSinglyLinkedList {

	public static void main(String[] args) {
		CircularLinkedList<Integer> list = new CircularLinkedList<>();
		list.insertAtBegin(3);
    	list.insertAtBegin(2);
		list.insertAtEnd(1);
		list.display();
		list.deleteAtBegin();
		System.out.println("After remove");
		list.display();
	}
}
