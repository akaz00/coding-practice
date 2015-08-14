import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class Anagram {
	/**
	 * Given a string array, find all anagrams (Easy)
	 * 
	 * @param str
	 * @return
	 */
	List<String> findAll(String[] arr) {
		List<String> result = new ArrayList<String>();
		Map<String, Set<String>> map = new HashMap<String, Set<String>>();
		for(String s : arr) {
			char[] charArr = s.toCharArray();
			Arrays.sort(charArr);
			String k = new String(charArr);
			Set<String> list = map.containsKey(k) ? map.get(k) : new HashSet<String>();
			list.add(s);
			map.put(k, list);
		}
		for(String k : map.keySet()) {
			if(map.get(k).size() > 1) {
				result.addAll(map.get(k));
			}
		}
		return result;
	}

	@Test
	public void test() {
		System.out.println(findAll(new String[] { "bat", "code", "cat", "tab",
				"cab", "crazy", "act" }));
	}
}
