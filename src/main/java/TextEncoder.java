import org.junit.Assert;
import org.junit.Test;

public class TextEncoder {
	/**
	 * Encoding "aaabbcccaaaa" to 3a2b3c4a
	 * 
	 * (follow-up: 111aaa -> 313a, this can also be interpreted as 313 'a'. One solution is to add a header information, to specify the length of the original string)
	 */
	String encode(String str) {
		int count = 0;
		char current = str.charAt(0);
		StringBuilder result = new StringBuilder();
		for (char c : str.toCharArray()) {
			if (c == current) {
				count++;
				continue;
			}
			result.append(count);
			result.append(current);
			current = c;
			count = 1;
		}
		result.append(count);
		result.append(current);

		return result.toString();
	}

	@Test
	public void test() {
		Assert.assertEquals("3a2b3c4a", encode("aaabbcccaaaa"));
	}
}
