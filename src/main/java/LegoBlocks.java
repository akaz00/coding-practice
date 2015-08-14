import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LegoBlocks {
	public static void main(String args[]) throws Exception {
		List<Integer> blocks = new ArrayList<>();
		blocks.add(4);
		blocks.add(3);
		blocks.add(2);
		blocks.add(1);
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
		}
		System.out.println(findWay(blocks, 2, 2));
//		System.out.println(findWay(blocks, 3, 2));
//		System.out.println(findWay(blocks, 2, 3));
	}

	static int findWay(final List<Integer> blocks, final int x, final int y) {
		int len = blocks.size();
		int idx = blocks.indexOf(y);
		if (idx > -1) {
			return 1 + findWay(blocks.subList(idx + 1, blocks.size()), x, y);
		}
		int result = 0;
		for (int i = 0; i < len; i++) {
			int block = blocks.get(i);
			int n = y / block;
			if (n >= 1) {
				result += (x * n)
						+ findWay(blocks.subList(i + 1, blocks.size()), x, y);
			}
		}
		return result;
	}
}
