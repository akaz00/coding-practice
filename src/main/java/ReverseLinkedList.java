import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Test;

/**
 * O(n) time O(1) space to print link list reversely.
 *
 */
public class ReverseLinkedList {
	void printReverse(LinkedList<Integer> list) {
		if(list.isEmpty()) {
			return;
		}
		int i = list.poll();
		printReverse(list);
		System.out.println(i);
	}

	@Test
	public void test() {
		LinkedList<Integer> list = new LinkedList<Integer>(
				Arrays.asList(new Integer[] { 1, 2, 3, 4 }));
		printReverse(list);
	}
}
