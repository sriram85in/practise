package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class InfixToPostfixWithParenthesis {
	public static String infixToPostfix(String infix) {
		StringBuilder postfix = new StringBuilder();
		if(infix == null || infix.length() ==0) {
			return new String();
		}
		Stack<Character> operator = new Stack<Character>();
		Map<Character,Integer> precedence = new HashMap<Character,Integer>();
		precedence.put('/', 0);
		precedence.put('*',1);
		precedence.put('+', 2);
		precedence.put('-', 3);
		precedence.put('(', Integer.MAX_VALUE);
		for(int i =0 ; i < infix.length();i++) {
			Character c = infix.charAt(i);
			if(Character.isWhitespace(c)) {}
			else if(Character.isAlphabetic(c)||Character.isDigit(c)) {
				postfix.append(c);
			} else {
				if(c == '(') {
					operator.push(c);
				} else  {
					if (operator.isEmpty()) {
						operator.push(c);
					} else if(c==')') {
						while(operator.peek() != '(') {
							postfix.append(operator.pop());
						}
						operator.pop();
					} else {
						if (precedence.get(c) < precedence.get(operator.peek())) {
							operator.push(c);
						} else {
							while(precedence.get(c) > precedence.get(operator.peek())) {
								postfix.append(operator.pop());
							} 
							operator.push(c);
						}
					}
				}
			}
		}
		while(!operator.isEmpty()) {
			postfix.append(operator.pop());
		}
		
		return postfix.toString();
	}
	
	public static void main(String [] args) {
		String infix = "a+b";
		System.out.println(infixToPostfix(infix));
		infix = "a+b*c";
		System.out.println(infixToPostfix(infix));
		infix = "(a+b)*c";
		System.out.println(infixToPostfix(infix));
	}
}
