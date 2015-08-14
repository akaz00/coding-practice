import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author tkang.1
 *
 */
public class HexBitImageRenderer {
	static String[] converter(String input) {
		List<String> result = new ArrayList<String>();
		for (String s : input.split(" ")) {
			result.add(String.format("%8s", new BigInteger(s, 16).toString(2)
					.replaceAll("1", "x").replaceAll("0", " ")));
		}
		return result.toArray(new String[0]);
	}

	public static void main(String args[]) throws Exception {
		for (String s : converter("00 42 00 81 42 3C 18 00")) {
			System.out.println(s);
		}
	}
}
