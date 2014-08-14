package stack;

import java.util.HashMap;
import java.util.Stack;

/*
 * Write a filter InfixToPostfix that converts an arithmetic expression from infix
	to postfix.
	http://scriptasylum.com/tutorials/infix_postfix/algorithms/infix-postfix/
	
	= Scan the Infix string from left to right.
	
	= Initialise an empty stack.
	
	= If the scannned character is an operand, add it to the Postfix string. 
	If the scanned character is an operator and 
	if the stack is empty Push the character to stack.
	
	= If the scanned character is an Operand and the stack is not empty, 
	compare the precedence of the character 
	with the element on top of the stack (topStack). 
	If topStack has higher precedence over the scanned character Pop the stack 
	else Push the scanned character to stack. 
	Repeat this step as long as stack is not empty and topStack has precedence
	 over the character.
	
	= Repeat this step till all the characters are scanned.
	(After all characters are scanned, we have to add any character that the stack may have to the Postfix string.) If stack is not empty add topStack to Postfix string and Pop the stack. Repeat this step as long as stack is not empty.
	Return the Postfix string.
	
	a+b*c-d  ===> abc*+d-
 */
public class InfixToPostfix {
	public static String infixToPostfix(String infix) {
		StringBuilder postfix = new StringBuilder();
		if(infix == null || infix.isEmpty()) {
			return postfix.toString();
		}
		HashMap<Character, Integer> precedence = new HashMap<Character, Integer>();
		precedence.put('/', 1);
		precedence.put('*', 2);
		precedence.put('+', 3);
		precedence.put('-', 4);
		
		
		Stack<Character> operator = new Stack<>();
		for(int i = 0 ; i < infix.length();i++) {
			Character c = infix.charAt(i);
			if (Character.isWhitespace(c)) {} 
			else if (Character.isAlphabetic(c) || Character.isDigit(c)) {
				postfix.append(c);
			} else if (c == '+' || c == '-' || c == '*' || c =='/') {
				if(operator.isEmpty()) {
					operator.push(c);
				} else if (precedence.get(c) < precedence.get(operator.peek())) {
					operator.push(c);
				} else {
					while (!operator.isEmpty() && precedence.get(c) > precedence.get(operator.peek())) {
						postfix.append(operator.pop());
					}
					operator.push(c);
				}
			}
				
		}
		while(!operator.isEmpty()) {
			postfix.append(operator.pop());
		}
		
		return postfix.toString();
	}
	
	public static void main(String [] args) {
		System.out.println(infixToPostfix("a+b*c-d"));
	}
}
