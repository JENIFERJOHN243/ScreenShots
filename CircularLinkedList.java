package task;

public class CircularLinkedList<T> {
	class Node{
		T value;
		Node next;
		Node(T value){
			this.value = value;
			next = null;
		}
	}
	Node last;
	CircularLinkedList(){
		last = null;
	}
	
	public void insertAtBegin(T value) {
		Node newNode = new Node(value);
		if(last==null) {
			newNode.next = newNode;
			last = newNode;
		}
		else {
			newNode.next = last.next;
			last.next = newNode;
		}
	}
	
	public void insertAtEnd(T value) {
		Node newNode = new Node(value);
		if(last==null) {
			newNode.next = newNode;
			last = newNode;
		}
		else {
			newNode.next = last.next;
			last.next = newNode;
			last = newNode;
		}
	}
	
	public void deleteAtBegin() {
		if(last==null) System.out.println("List is Empty");
		//T temp = last.next.value;
		if(last.next==last) last=null;
		else {
			last.next = last.next.next;
		}
	}
	
	public void deleteAtEnd() {
		if(last==null) System.out.println("List is Empty");
		if(last.next==last) last=null;
		else {
			Node temp = last.next;
			while(temp.next!=last) {
				temp = temp.next;
			}
			temp.next = last.next;
			last = temp;
		}
	}
	
	public void display() {
		if(last==null) return;
		Node temp = last.next;
		do {
			System.out.print(temp.value+" ");
			temp = temp.next;
		}while(temp!=last.next);
	}
}
