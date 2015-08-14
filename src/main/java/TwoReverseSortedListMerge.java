import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;


public class TwoReverseSortedListMerge {
	public void merge(LinkedList<Integer> list, List<Integer> list2) {
		int item1;
		int item2;
		
		
		
		System.out.println(list);
	}
	
	@Test
	public void test() {
		LinkedList<Integer> list1 = new LinkedList<Integer>();
		list1.addAll(Arrays.asList(new Integer[] {7,5,4,3,2}));
		List<Integer> list2 = new ArrayList<Integer>();
		list2.addAll(Arrays.asList(new Integer[] {8,4,1}));
		merge(list1, list2);
	}
}
