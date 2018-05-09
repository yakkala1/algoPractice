import static org.junit.Assert.*;

import org.junit.Test;

public class SortTest {
	Solution sol = new Solution();

	@Test
	public void test1() {
		assertArrayEquals(
				new int[]{},
				sol.sort(
				new int[]{}
				)
				);
	}

	@Test
	public void test2() {
		assertArrayEquals(
				new int[]{1,2,3,4,6,8,9},
				sol.sort(
				new int[]{8,4,1,9,2,6,3}
				)
				);
	}

	@Test
	public void test3() {
		assertArrayEquals(
				new int[]{121,1221,12313121},
				sol.sort(
				new int[]{1221,12313121,121}
				)
				);
	}

	@Test
	public void test4() {
		assertArrayEquals(
				new int[]{1,2,3,4,4,4,6,8,9},
				sol.sort(
				new int[]{8,4,1,9,2,6,3,4,4}
				)
				);
	}

}
