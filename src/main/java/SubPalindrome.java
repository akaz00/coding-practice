import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class SubPalindrome {
	static int palindrome(String str) {
		final Set<String> result = new HashSet<>();
		for (int i = 0; i < str.length(); i++) {
			// even palindrome:
			palindrome(result, str, i, i + 1);
			// odd palindrome:
			palindrome(result, str, i, i);
		}
		return result.size();
	}

	static void palindrome(final Set<String> result, final String str,
			int i, int j) {
		while (i >= 0 && j < str.length() && str.charAt(i) == str.charAt(j)) {
			result.add(str.substring(i, j + 1));
			i--;
			j++;
		}
	}

	@Test
	public void test() {
		Assert.assertEquals(5, palindrome("aabaa"));
	}
}
