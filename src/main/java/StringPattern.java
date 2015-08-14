import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Assert;
import org.junit.Test;

public class StringPattern {
	boolean validate(String pattern, String str) {
		if (str.length() % pattern.length() != 0) {
			return false;
		}
		Map<Character, Integer> chars = new TreeMap<>();
		char last = 0;
		for (char c : pattern.toCharArray()) {
			chars.put(c, chars.containsKey(c) ? chars.get(c) + 1 : 1);
			last = c;
		}
		Map<Character, String> map = new HashMap<>();
		int charsSize = chars.size();
		int idx = 0;
		Iterator<Character> charIterator = chars.keySet().iterator();

		int totalLen = 0;
		for(char c : chars.keySet()) {
			totalLen += charsSize * chars.get(c);
		}
		
		while(charIterator.hasNext()) {
			char c = charIterator.next();
			if(idx >= str.length()) {
				break;
			}
//			for(int j = idx + 1; j < str.length() - --charsSize; j++) {
//				String part = str.substring(idx, j);
//				
//				if(matchOccurrence(part, str, chars.get(c))) {
//					map.put(c, part);
//					System.out.println(c);
//					System.out.println(part);
//					System.out.println(chars.get(c));
//					idx = j;
//					break;
//				}
//			}
		}
		System.out.println(map);
		return true;
	}
	
	
	void getStringMap(Map<Character, String> map, String str, char c, int occurrence, int chars) {
		for(int i = 0; i < str.length() - 1 - chars; i++) {
			String part = str.substring(0, i);
			if(matchOccurrence(part, str, occurrence)) {
				map.put(c, part);
				System.out.println(part);
				System.out.println(occurrence);
			}
		}
	}
	
	boolean matchOccurrence(String needle, String str, int count) {
		int len = str.length();
		int cnt = 0;
		for(int i = 0; i < str.length(); i++) {
			if(cnt > count) {
				return false;
			}
			int idx = str.substring(i, len - 1).indexOf(needle);
			if(idx > -1) {
				cnt++;
				i += idx;
			}
		}
		return cnt == count;
	}

	boolean validate(String pattern, String str, Map<Character, String> map) {
		int idx = 0;
		for (char c : pattern.toCharArray()) {
			String part = map.get(c);
			int len = part.length();
			if (!str.substring(idx, idx + len).equals(part)) {
				return false;
			}
			idx += len;
		}
		return true;
	}

	@Test
	public void test() {
		Assert.assertTrue(validate("abab", "redblackredblack"));
//		Assert.assertTrue(validate("abba", "redblackblackred"));
//		Assert.assertTrue(validate("abbac", "redblackblackredblue"));
//		Assert.assertTrue(validate("cabba", "blueredblackblackred"));

		Map<Character, String> map = new HashMap<>();
		map.put('a', "red");
		map.put('b', "black");
		System.out.println(validate("abab", "redblackredblack", map));
	}
}
