package stack;

import java.util.Stack;

/*
 Write a program that takes from standard input an expression without left parentheses
and prints the equivalent infix expression with the parentheses inserted. For
example, given the input:
1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )
your program should print
( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) )
 */
public class PrintCompleteExpression {
	public static String printCompleteInFix(String input) {
		if(input == null || input.length() ==0) {
			return new String();
		}
		
		Stack<String> op = new Stack<>();
		Stack<String> val = new Stack<>();
		
		for(int i =0 ; i < input.length() ;i++) {
			Character c = input.charAt(i);
			if (c == ' ') {
			} else if (c == '+' || c == '-' || c == '/' || c == '*') {
				op.push(c.toString());
			} else if (c == ')') {
				String val2 = val.pop();
				String val1 = val.pop();
				String newVal = "("+ val1.toString() + op.pop() + val2 + ")";
				val.push(newVal);
			} else {
				val.push(c.toString());
			}
		}
		return val.toString();
	}
	
	public static void main(String [] args) {
		System.out.println(printCompleteInFix("1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )"));
	}
}
