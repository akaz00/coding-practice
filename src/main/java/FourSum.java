import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class FourSum {
	public static class Pair {
		int a;
		int b;
		int aIndex;
		int bIndex;

		public Pair(int aInput, int aIndexInput, int bInput, int bIndexInput) {
			a = aInput;
			aIndex = aIndexInput;
			b = bInput;
			bIndex = bIndexInput;
		}

		public boolean same(Pair p) {
			return p != null && p.a == a && p.b == b;
		}
	}

	public List<List<Integer>> fourSum(int[] num, int target) {
		List<List<Integer>> result = new ArrayList<>();
		if (num == null || num.length < 4) {
			return result;
		}
		int[] array = new int[num.length];
		System.arraycopy(num, 0, array, 0, num.length);
		Arrays.sort(array);
		TreeMap<Integer, List<Pair>> map = new TreeMap<>();
		for (int i = 0; i < num.length - 1; i++) {
			for (int j = i + 1; j < num.length;) {
				int sum = array[i] + array[j];
				List<Pair> list;
				if (map.containsKey(sum)) {
					list = map.get(sum);
				} else {
					list = new ArrayList<>();
					map.put(sum, list);
				}
				list.add(new Pair(array[i], i, array[j], j));
				do {
					j++;
				} while (j < num.length && array[j] == array[j - 1]);
			}
		}

		Integer low = map.firstKey();
		Integer high = map.lastKey();
		while (low != null && high != null && low <= high) {
			if (low + high < target) {
				low = map.higherKey(low);
			} else if (low + high > target) {
				high = map.lowerKey(high);
			} else {
				Pair lastA = null;
				for (Pair a : map.get(low)) {
					if (a.same(lastA)) {
						continue;
					}
					lastA = a;

					Pair lastB = null;
					for (Pair b : map.get(high)) {
						if (a.bIndex < b.aIndex) {
							if (b.same(lastB)) {
								continue;
							}
							lastB = b;
							result.add(Arrays.asList(a.a, a.b, b.a, b.b));
						}
					}
				}

				low = map.higherKey(low);
				high = map.lowerKey(high);
			}
		}

		return result;
	}
}
