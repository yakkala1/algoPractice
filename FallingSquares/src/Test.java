import java.util.List;

import org.junit.Assert;

public class Test {

	@org.junit.Test
	public void test1() {
		test(
				new int[][]{{1, 2}, {2, 3}, {6, 1}},
				new int[]{2,5,5}
				);
	}

	@org.junit.Test
	public void test2() {
		test(
				new int[][]{{100, 100}, {200, 100}},
				new int[]{100,100}
				);
	}

	private void test(int[][] array, int[] expected) {
		Solution sol = new Solution();
		List<Integer> actual = sol.fallingSquares(array);
		Assert.assertEquals(expected.length , actual.size());
		for(int i=0; i<actual.size(); i++) {
			Assert.assertEquals((int)expected[i], (int)actual.get(i));
		}
	}

}
