import java.util.TreeSet;

import org.junit.Test;

/**
 * You have created a computer simulation of a mobile robot. The robot moves on 
 * an infinite plane, starting from position (0,0). Its movements are described 
 * by command string of your choosing composed of three instructions you have 
 * provided:
 * 
 *     G means go forward one step
 *     L means turn left
 *     R means turn right
 *     
 * The movements described in the input string are repeated for an infinite 
 * time. Your task to find if there exists a circle, whose radius is some 
 * positive real number R, such that the bot never leaves it. If such a circle 
 * exists then return "YES" otherwise "NO" (without quotes).
 * 
 * You have to complete the function string doesCircleExist(string commands) 
 * which reads the input command as argument and returns the output.
 * 
 * Constraints
 *     commands will consists of only 'G', 'L' and 'R'.
 *     1 <= length (commands) <= 2500
 * Sample Input #1
 * commands: "L"
 * Returns: "YES"
 * Explanation: Bot never moves a step in his life. It just rotate by 90 
 * degrees at each turn.
 * 
 * Sample Input #2
 * commands: "GRGL"
 * Returns: "NO"
 * Explanation: Define the original direction of the robot as north. It will 
 * repeatedly follow the steps: Go north one step, turn right, go one step to 
 * east, turn left, one step to north, and so on. It will make an endless 
 * zig-zag path towards north-east.
 *
 */
public class Encircular {
	static enum Dir {
		N, E, W, S;
		Dir turnLeft() {
			switch (this) {
			case E:
				return S;
			case S:
				return W;
			case W:
				return N;
			default:
				return E;
			}
		}

		Dir turnRight() {
			switch (this) {
			case E:
				return N;
			case S:
				return E;
			case W:
				return S;
			default:
				return W;
			}
		}
	}

	static String doesCircleExist(String commands) {
		int x = 0;
		int y = 0;
		Dir d = Dir.N;
		TreeSet<Integer[]> visited = new TreeSet<>();

		for (char c : commands.toCharArray()) {
			switch (c) {
			case 'G':
				switch (d) {
				case E:
					x--;
				case S:
					y--;
				case W:
					x++;
				default:
					y++;
				}
				Integer[] coord = new Integer[] { x, y };
				if (visited.contains(coord) && visited.last() != coord) {
					return "YES";
				}
				visited.add(coord);
				break;
			case 'L':
				d.turnLeft();
				break;
			case 'R':
				d.turnRight();
				break;
			}
		}
		return x == 0 && y == 0 ? "YES" : "NO";
	}

	@Test
	public void test() {
		System.out.println(doesCircleExist("L"));
		System.out.println(doesCircleExist("GRGL"));
		System.out.println(doesCircleExist("GGG"));
	}
}
