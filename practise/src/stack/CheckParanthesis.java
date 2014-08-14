package stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author Sriram
 * Write a stack client Parentheses that reads in a text stream from standard input
   and uses a stack to determine whether its parentheses are properly balanced. 
   For example,your program should print true for [()]{}{[()()]()} and false for [(]).
 */

public class CheckParanthesis {
	public static boolean check(String input) {
		if(input == null || input.length() ==0) {
			return false;
		}
		HashMap<Character, Character> map = new HashMap<>();
		map.put('(', ')');
		map.put('{', '}');
		map.put('[', ']');
		Stack<Character> operatorStack = new Stack<Character>();
		for(int i =0 ; i < input.length();i++) {
			Character c = input.charAt(i);
			if(c == '{' || c == '(' || c== '[') {
				operatorStack.push(c);
			} else if (c == '}' || c == ')' || c == ']') {
				if (operatorStack.isEmpty()) return false;
				char out = operatorStack.pop();
				if (map.get(out) != c) {
					return false;
				}
			} else {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String [] args) {
		System.out.println(check("[()]{}{[()()]()}"));
		System.out.println(check("[(])"));
	}
}
