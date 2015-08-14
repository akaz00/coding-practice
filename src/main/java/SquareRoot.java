import org.junit.Assert;
import org.junit.Test;

public class SquareRoot {
	public double sqrt(double num, double precision) {
		double t = num / 2;
		while (true) {
			double m = t * t;
			if (m == num) {
				return t;
			}
			if (Math.abs(m - num) < precision) {
				return t;
			}
			if (m > num) {
				t = t / 2;
				continue;
			}
			t = (t * 2) - (t / 2);
		}
	}

	@Test
	public void test() {
		Assert.assertEquals(3, sqrt(9, 0.05), 0.05);
		Assert.assertEquals(1.414, sqrt(2, 0.01), 0.01);
	}
}
