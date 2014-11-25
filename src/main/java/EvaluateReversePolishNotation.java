import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * 
 * Valid operators are +, -, *, /. Each operand may be an integer or another
 * expression.
 * 
 * Some examples: 
 *   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9 
 *   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * 
 * @See https://oj.leetcode.com/problems/evaluate-reverse-polish-notation/
 */
public class EvaluateReversePolishNotation {
	Set<String> operators = new HashSet<String>(Arrays.asList("+", "-", "*",
			"/"));

	public int evalRPN(String... tokens) {
		Stack<Integer> stack = new Stack<Integer>();
		for (String token : tokens) {
			if (!operators.contains(token)) {
				stack.push(Integer.valueOf(token));
				continue;
			}
			stack.push(eval(stack.pop(), stack.pop(), token));
		}
		return stack.pop();
	}

	private int eval(int item1, int item2, String operator) {
		switch (operator) {
		case "+":
			return item1 + item2;
		case "-":
			return item2 - item1;
		case "*":
			return item1 * item2;
		case "/":
			return item2 / item1;
		default:
			throw new UnsupportedOperationException(String.format(
					"Unsupported operator '%s'", operator));
		}
	}

	@Test
	public void test() {
		Assert.assertEquals(1, evalRPN("4", "3", "-"));
		Assert.assertEquals(9, evalRPN("2", "1", "+", "3", "*"));
		Assert.assertEquals(6, evalRPN("4", "13", "5", "/", "+"));
	}
}
