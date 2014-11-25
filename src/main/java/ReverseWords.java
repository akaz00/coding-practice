import org.junit.Assert;
import org.junit.Test;

/**
 * Given an input string, reverse the string word by word.
 * 
 * For example, Given s = "the sky is blue", return "blue is sky the".
 * 
 * Clarification:
 *  
 *   - What constitutes a word? 
 *     A sequence of non-space characters constitutes a word.
 *     
 *   - Could the input string contain leading or trailing spaces? 
 *     Yes. However, your reversed string should not contain leading or trailing spaces.
 *     
 *   - How about multiple spaces between two words?
 *     Reduce them to a single space in the reversed string.
 *     
 * @See https://oj.leetcode.com/problems/reverse-words-in-a-string/     
 */
public class ReverseWords {
	public String reverseWords(String s) {
		StringBuilder result = new StringBuilder();
		StringBuilder sb = new StringBuilder();
		for (int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			if (c != ' ') {
				sb.append(c);
			} else if (sb.length() > 0) {
				result.append(sb.reverse().toString());
				result.append(' ');
				sb = new StringBuilder();
			}
		}
		if (sb.length() > 0) {
			result.append(sb.reverse().toString());
		}
		return result.toString().trim();
	}

	@Test
	public void test() {
		Assert.assertEquals("1", reverseWords(" 1"));
		Assert.assertEquals("1", reverseWords("1"));
		Assert.assertEquals("", reverseWords("    "));
		Assert.assertEquals("b a", reverseWords("   a   b "));

		Assert.assertEquals("blue is sky the", reverseWords("the sky is blue"));
	}
}
