package linkedlist;

public class LinkedListClient {
	public static void main(String [] args) {
		LinkedList<Integer> list = new LinkedList<>();
		// adding 2 , 3 , 4 
		list.add(2);
		list.add(3);
		list.add(4);
		//checking whether list is empty
		System.out.println(list.isEmpty());
		
		//printing
		list.print();
		
		//removing 3
		list.remove(3);
		list.print();
		
		//again removing 3 .. so desired change
		list.remove(3);
		list.print();
		
		list.remove(2);
		list.remove(4);
		System.out.println(list.isEmpty());
		list.print();
	}
}
