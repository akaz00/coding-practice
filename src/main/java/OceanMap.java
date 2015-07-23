import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Given: An array of strings where "L" indicates land and "W" indicates water,
 * and a coordinate marking a starting point in the middle of the ocean.
 *
 * Challenge: Find and mark the ocean in the map by changing appropriate W's to
 * O's. An ocean coordinate is defined to be the starting point and any
 * coordinate directly adjacent to any other ocean coordinate.
 * 
 * 
 * world_map = [ 
 * "WLLLLLLLLLLLLLLLLLLL", 
 * "LWWLLLLLLLLLLLLLLLLL",
 * "LWWWWWLLLLLLLLLLLLLL", 
 * "LWWWWWLLLLLLLLLLLLLL", 
 * "LLLLLLLLLLLLLLLLWWLL",
 * "LLLLLLLLLLLLLLLLWWLL", ] 1,1
 */

class OceanMap {

	static class Ocean {
		char[][] map;

		Ocean(String[] mapStrings) {
			map = new char[mapStrings.length][mapStrings[0].length()];
			int i = 0;
			for (String str : mapStrings) {
				for (int j = 0; j < str.length(); j++) {
					map[i][j] = str.charAt(j);
				}
				i++;
			}
		}

		// recursive
		void mark(int x, int y) {

			if (map[x][y] != 'W') {
				// Not water
				return;
			}
			map[x][y] = 'O';
			if (x >= 1) {
				mark(x - 1, y);
			}
			if (y >= 1) {
				mark(x, y - 1);
			}
			if (x < map.length - 1) {
				mark(x + 1, y);
			}
			if (y < map[0].length - 1) {
				mark(x, y + 1);
			}
		}

		static class Coord {
			int x;
			int y;

			Coord(int x, int y) {
				this.x = x;
				this.y = y;
			}
		}

		// iterative
		void mark2(int x, int y) {
			Queue<Coord> queue = new LinkedList<>();
			queue.add(new Coord(x, y));
			Set<Coord> visited = new HashSet<>();
			while (queue.peek() != null) {
				Coord coord = queue.poll();
				if (visited.contains(coord)) {
					continue;
				}
				visited.add(coord);
				if (map[coord.x][coord.y] != 'W') {
					continue;
				}
				map[coord.x][coord.y] = 'O';
				if (coord.x >= 1) {
					queue.add(new Coord(coord.x - 1, coord.y));
				}
				if (coord.y >= 1) {
					queue.add(new Coord(coord.x, coord.y - 1));
				}
				if (coord.x < map.length - 1) {
					queue.add(new Coord(coord.x + 1, coord.y));
				}
				if (coord.y < map[0].length - 1) {
					queue.add(new Coord(coord.x, coord.y + 1));
				}
			}
		}

		void print() {
			for (char[] row : map) {
				for (char c : row) {
					System.out.print(c);
				}
				System.out.println();
			}
			System.out.println();

		}
	}

	public static void main(String[] args) {
		String[] mapStrings = new String[] { "WLLLLLLLLLLLLLLLLLLL", "LWWLLLLLLLLLLLLLLLLL", "LWWWWWLLLLLLLLLLLLLL",
				"LWWWWWLLLLLLLLLLLLLL", "WWWLLLLLLLLLLLLLWWLL", "LLWWWWWWWWWWWWWWWWLL" };

		Ocean o = new Ocean(mapStrings);
		o.mark2(1, 1);
		o.print();

		o = new Ocean(mapStrings);
		o.mark(1, 0);
		o.print();

		o = new Ocean(mapStrings);
		o.mark(0, 0);
		o.print();

	}
}
