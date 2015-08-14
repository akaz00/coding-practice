import org.junit.Test;
/**
 * A company needs to fix a set of customer phone numbers which were incorrectly stored. Phone numbers were mistakenly stored in the following formats:
 * 
 * Prefix (XXX)  Area Code (YYY)  Line Number(ZZZ)
 * 
 *        XXXYYYZZZZ
 *        XXX-YYY-ZZZZ
 *                            
 * The fix intends to normalize the phone numbers as:
 *        YYY-XXX-ZZZZ
 * The set of phone numbers impacted is large, so do your best to minimize additional storage.
 * Implement:
 * 	void Reformat( string[] phoneNumbers );
 */
public class PhoneNumberReformatter {
	void Reformat(String[] phoneNumbers) {
		for (String number : phoneNumbers) {
			String normalized = number.replaceAll("-", "");
			String prefix = normalized.substring(0, 3);
			String areaCode = normalized.substring(3, 6);
			String lineNumber = normalized.substring(6, 10);
			System.out.println(String.format("%s-%s-%s", areaCode, prefix, lineNumber));
		}
	}

	@Test
	public void test() {
		Reformat(new String[] { "XXXYYYZZZZ", "XXX-YYY-ZZZZ" });
	}
}
