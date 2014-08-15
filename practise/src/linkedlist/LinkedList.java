package linkedlist;

public class LinkedList<E> {
	
	protected class Node {
		E item;
		Node next;
		Node(E item) {
			this.item = item;
			next = null;
		}
	}
	
	Node head;
	
	public boolean isEmpty() {
		return head ==null;
	}
	
	public void add(E item) {
		Node temp = new Node(item);
		if(head == null) {
			head = temp;
		} else {
			Node n = head;
			while(n.next != null) {
				n = n.next;
			}
			n.next = temp;
		}
	}
	
	public void remove (E item) {
		if(item == null){
			return;
		}
		Node tempHead = head;
		Node prev = head;
		while(tempHead != null && !tempHead.item.equals(item)) {
			prev = tempHead;
			tempHead = tempHead.next;
		}
		
		if(tempHead == null) {
			return;
		} else if (tempHead == head) {
			head = head.next;
		} else {
			prev.next = tempHead.next;
		}
	}
	
	public void print() {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.item + " -->");
			temp = temp.next;
		}
		System.out.print("null");
		System.out.println();
	}
}
