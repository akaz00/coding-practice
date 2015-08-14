import java.util.Map;
import java.util.TreeMap;

import org.junit.Assert;
import org.junit.Test;

public class FindTheBomb {
	static boolean contains_bomb(int[] arr) {
		if (arr == null) {
			return false;
		}
		if (arr.length < 6) {
			return false;
		}
		int cnt = 1;
		int pairCnt = 1;
		int prev = Integer.MIN_VALUE;
		for (int i : arr) {
			if (prev == i) {
				pairCnt = 2;
				continue;
			} else {
				pairCnt = 1;
			}

			if (prev == i - 1 && pairCnt > 1) {
				cnt++;
				System.out.println(i + " , " + pairCnt +  ", " + cnt);
				if (cnt == 3) {
					return true;
				}
			}

			prev = i;
		}
		System.out.println(cnt);

		return false;

	}

	boolean a(int arr[]) {
		Map<Integer, Integer> map = new TreeMap<>();
		for (int i : arr) {
			map.put(i, map.containsKey(i) ? map.get(i) + 1 : 1);
		}

		int prev = Integer.MIN_VALUE;
		int cnt = 1;
		for (int i : map.keySet()) {
			if (map.get(i) < 2) {
				prev = Integer.MIN_VALUE;
				continue;
			}
			if (prev == i - 1) {
				if (++cnt == 3) {
					return true;
				}
			} else {
				cnt = 1;
			}
			prev = i;
		}
		return false;
	}

	@Test
	public void test() {
		Assert.assertFalse(contains_bomb(new int[] { 1, 2, 3 }));
		Assert.assertTrue(contains_bomb(new int[] { 1, 1, 2, 2, 3, 3 }));
		Assert.assertFalse(contains_bomb(new int[] { 1, 2, 2, 3, 3, 4, 5, 5 }));
		// Assert.assertTrue(contains_bomb(new int[] { 1, 2, 2, 3, 3, 3, 3, 3,
		// 3, 3, 3, 3, 4, 4, 5 }));
		Assert.assertFalse(contains_bomb(null));
	}
}
