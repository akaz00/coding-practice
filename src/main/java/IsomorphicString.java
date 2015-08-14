import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @see https://leetcode.com/problems/isomorphic-strings/
 *
 */
public class IsomorphicString {
	public boolean isIsomorphic(String s, String t) {
		Map<Character, Character> charSet = new HashMap<>();
		char[] sArray = s.toCharArray();
		char[] tArray = t.toCharArray();

		for (int i = 0; i < sArray.length; i++) {
			if (charSet.containsKey(sArray[i])
					&& charSet.get(sArray[i]).charValue() != tArray[i]) {
				return false;
			}
			charSet.put(sArray[i], tArray[i]);
		}

		return true;
	}

	@Test
	public void test() {
		Assert.assertTrue(isIsomorphic("egg", "add"));
	}
}
