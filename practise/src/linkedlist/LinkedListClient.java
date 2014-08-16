package linkedlist;

public class LinkedListClient {
	public static void main(String [] args) {
		LinkedList<Integer> list = new LinkedList<>();
		// adding 2 , 3 , 4 
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		//checking whether list is empty
		System.out.println(list.isEmpty());
		
		//printing
		list.print();
		
		list.reverse();
		list.print();
	}
}
