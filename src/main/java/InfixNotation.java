import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class InfixNotation {

	private static final Map<String, Integer> OPERATOR = new HashMap<String, Integer>();

	static {
		OPERATOR.put("+", 0);
		OPERATOR.put("-", 0);
		OPERATOR.put("*", 10);
		OPERATOR.put("/", 10);
	}

	private static boolean isOperator(String token) {
		return OPERATOR.containsKey(token);
	}

	static String[] toRPN(String infixNotation) {
		String[] tokens = infixNotation.split(" ");
		String[] result = new String[tokens.length];
		Stack<String> stack = new Stack<String>();
		int i = 0;
		for (String token : tokens) {
			if (isOperator(token)) {
				while (!stack.empty() && isOperator(stack.peek())) {
					if (!isHighPriorityOperator(token)) {
						result[i++] = stack.pop();
						continue;
					}
					break;
				}
				stack.push(token);
				continue;
			}
			result[i++] = token;
		}
		while (!stack.empty()) {
			result[i++] = stack.pop();
		}
		return result;
	}

	static boolean isHighPriorityOperator(String token) {
		return OPERATOR.get(token) == 10;
	}

	static public int evalRPN(String... tokens) {
		Stack<Integer> stack = new Stack<Integer>();
		for (String token : tokens) {
			if (!isOperator(token)) {
				stack.push(Integer.valueOf(token));
				continue;
			}
			stack.push(eval(stack.pop(), stack.pop(), token));
		}
		return stack.pop();
	}

	static private int eval(String infixNotation) {
		return evalRPN(toRPN(infixNotation));
	}

	static private int eval(int item1, int item2, String operator) {
		switch (operator) {
		case "+":
			return item1 + item2;
		case "-":
			return item1 - item2;
		case "*":
			return item1 * item2;
		case "/":
			return item1 / item2;
		default:
			throw new UnsupportedOperationException(String.format(
					"Unsupported operator '%s'", operator));
		}
	}

	public static void main(String[] args) {
		System.out.println(eval("15 + 2 - 3"));
		System.out.println(eval("145"));
		System.out.println(eval("1 + 233 / 233"));
		// System.out.println(eval("15 * 2 + 3"));
		// System.out.println(eval("15 + 2 - 3"));
		// System.out.println(eval("145"));
	}

	/*
	 * Your previous Plain Text content is preserved below:
	 * 
	 * 
	 * Write a function/method that takes a mathematical expression represented
	 * as a string and returns the value of the expression.
	 * 
	 * The expression is written in infix notation (number operator number) with
	 * a single space between operators and operands.
	 * 
	 * You only need to support four operations: addition, subtraction, division
	 * and multiplication (+ - * /)
	 * 
	 * No parenthesis.
	 * 
	 * Valid input: "15 + 2 - 3" -> 14 , 15 2 + "145" -> 145 "1 + 233 / 233" ->
	 * 2 , 233 233 / 1 +
	 * 
	 * 
	 * 
	 * 
	 * 
	 * Invalid input: "1 1" "+ 1" "1 + 2 +" "+ 1 1" "1+2"
	 */
}
