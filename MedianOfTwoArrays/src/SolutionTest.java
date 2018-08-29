import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {
	
	Solution sol = new Solution();

	@Test
	public void test1() {
		test(
				new int[]{1,3},
				new int[]{2},
				2.0
				);
	}

	@Test
	public void test2() {
		test(
				new int[]{1,3},
				new int[]{2,4},
				2.5
				);
	}

	@Test
	public void test27() {
		test(
				new int[]{1,2},
				new int[]{3,4},
				2.5
				);
	}

	@Test
	public void test28() {
		test(
				new int[]{},
				new int[]{1},
				1
				);
	}

	@Test
	public void test3() {
		test(
				new int[]{1,3,10},
				new int[]{2,4,5,6,7,8},
				5.0
				);
	}

	@Test
	public void test4() {
		test(
				new int[]{1,2,2,2},
				new int[]{2,5},
				2.0
				);
	}
	
	@Test
	public void test5() {
		test(
				new int[]{1,3,10,12},
				new int[]{2,4,5,6,7,8},
				5.5
				);
	}

	private void test(int[] is, int[] is2, double d) {
		double answer = sol.findMedianSortedArrays(is, is2);
		assertEquals(d, answer, 0.01);
	}

}
