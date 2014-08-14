package stack;

import java.util.LinkedList;
import java.util.Queue;

/*
 * http://stackoverflow.com/questions/688276/implement-stack-using-two-queues
 */
public class StackUsingTwoQueues<E> {
	Queue<E> queue1 = new LinkedList<>();
	Queue<E> queue2 = new LinkedList<>();
	public void push(E item) {
		if(queue1.isEmpty()) {
			while(!queue2.isEmpty()) {
				queue1.add(queue2.remove());
			}
			queue1.add(item);
		} else {
			while(!queue1.isEmpty()) {
				queue2.add(queue1.remove());
			}
			queue2.add(item);
		}
	}
	
	public E pop() {
		if(queue1.isEmpty()) {
			return queue2.remove();
		} else {
			return queue1.remove();
		}
	}
	
	public boolean isEmpty() {
		return queue1.isEmpty() && queue2.isEmpty();
	}
}
