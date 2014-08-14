package stack;

import java.util.Stack;

public class PostfixEvaluation {
	public static int evaluate(String infix) {
		String postfx = InfixToPostfix.infixToPostfix(infix);
		Stack<Integer> operands = new Stack<Integer>();
		int result = 0;
		for(int i =0 ; i < postfx.length() ;i++) {
			Character c = postfx.charAt(i);
			if(Character.isDigit(c)) {
				operands.push(Integer.parseInt(c.toString()));
			} else {
				if (c == '+') {
					result = operands.pop() + operands.pop();
				} else if (c == '-') {
					result = - (operands.pop() - operands.pop());
				} else if (c == '/') {
					int div = operands.pop();
					int num = operands.pop();
					result = num/div;
				} else {
					result = operands.pop() * operands.pop();
				}
				operands.push(result);
			}
		}
		
		return operands.pop();
	}
	
	public static void main(String [] args) {
		System.out.println(evaluate("1+2*3-4"));
	}
}
