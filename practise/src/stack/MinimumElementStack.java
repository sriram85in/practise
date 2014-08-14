package stack;

import java.util.Stack;

public class MinimumElementStack {
	Stack<Integer> minStack = new Stack<Integer>();
	Stack<Integer> originalStack = new Stack<Integer>();
	
	public void push(Integer item) {
		originalStack.push(item);
		if(minStack.isEmpty()) {
			minStack.push(item);
		} else {
			minStack.push(Math.min(item, minStack.peek()));
		}
	}
	
	public int pop() {
		minStack.pop();
		return originalStack.pop();
	}
	
	public int minElement() {
		return minStack.peek();
	}
}
