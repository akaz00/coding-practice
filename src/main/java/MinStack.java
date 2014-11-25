import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * 
 *  push(x) -- Push element x onto stack.
 *  pop() -- Removes the element on top of the stack.
 *  top() -- Get the top element.
 *  getMin() -- Retrieve the minimum element in the stack.
 *  
 * @See https://oj.leetcode.com/problems/min-stack/
 *
 */
public class MinStack {
	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> minStack = new Stack<Integer>();

	public void push(int x) {
		if (minStack.empty() || minStack.peek() >= x) {
			minStack.push(x);
		}
		stack.push(x);		
	}

	public void pop() {
		if(stack.peek().equals(minStack.peek())) {
			minStack.pop();
		}
		stack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}

	@Test
	public void test1() {
		MinStack a = new MinStack();
		a.push(2);
		a.push(0);
		a.push(3);
		a.push(0);
		
		Assert.assertEquals(0, a.getMin());
		a.pop();
		Assert.assertEquals(0, a.getMin());
		a.pop();
		Assert.assertEquals(0, a.getMin());
		a.pop();
		Assert.assertEquals(2, a.getMin());
	}
	
	@Test
	public void test2() {
		MinStack a = new MinStack();
		a.push(512);
		a.push(-1024);
		a.push(-1024);
		a.push(512);
		a.pop();
		Assert.assertEquals(-1024, a.getMin());
		a.pop();
		Assert.assertEquals(-1024, a.getMin());
		a.pop();
		Assert.assertEquals(512, a.getMin());
	}
}
