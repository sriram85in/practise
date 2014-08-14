package stack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/*
 * http://stackoverflow.com/questions/13204483/remove-extra-parenthesis
 */
public class RemoveRedundantParanthesis {
	public static String remove(String infix) {
		Map<Character,Integer> precedence = new HashMap<Character,Integer>();
		precedence.put('/', 0);
		precedence.put('*',1);
		precedence.put('+', 2);
		precedence.put('-', 3);
		precedence.put('(', Integer.MAX_VALUE);
		if(infix == null || infix.length()==0) {
			return new String();
		}
		/*
		 * Converted to postfix by removing the paranthesis
		 */
		String postfix = InfixToPostfixWithParenthesis.infixToPostfix(infix);
		Queue<Character> operator = new LinkedList<>();
		/*
		 * add only the operators to the queue
		 */
		for(int i =0 ; i < postfix.length();i++) {
			Character c = postfix.charAt(i);
			if(!Character.isAlphabetic(c)) {
				operator.add(c);
			}
		}
		
		Stack<String> output = new Stack<String>();
		for(int i =0 ; i < postfix.length();i++) {
			Character c = postfix.charAt(i);
			if(Character.isAlphabetic(c)) {
				output.push(c.toString());
			} else {
				Character top = operator.remove();
				if(operator.isEmpty() || precedence.get(top) < precedence.get(operator.peek())) {
					String two = output.pop();
					String one = output.pop();
					String result  = one + top + two;
					output.push(result);
				} else {
					String two = output.pop();
					String one = output.pop();
					String result  = "(" + one + top + two + ")";
					output.push(result);
				}
			}
		}
		
		return output.peek();
	}
	
	public static void main(String [] args) {
		String infix = "((A+B)*C)";
		System.out.println(remove(infix));
		infix = "(A+B)*(A-B)";
		System.out.println(remove(infix));
		infix = "((a+b)/(c+d))";
		System.out.println(remove(infix));
		infix="((a+b))*c";
		System.out.println(remove(infix));
		infix="(a+(((b-c)))*d)";
		System.out.println(remove(infix));
	}
}
 