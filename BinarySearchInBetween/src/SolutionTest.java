import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {
	Solution sol = new Solution();

	@Test
	public void test1() {
		test(new int[]{1,3,4,6,9,10,12}, 8, 3);
	}
	
	@Test
	public void test2() {
		test(new int[]{1,3,4,6,9,10,12}, 0, -1);
	}
	
	@Test
	public void test3() {
		test(new int[]{1,3,4,6,9,10,12}, 14, 6);
	}
	
	@Test
	public void test4() {
		test(new int[]{1}, 1, 0);
	}
	
	@Test
	public void test5() {
		test(new int[]{2,2}, 2, 1);
	}
	
	@Test
	public void test6() {
		test(new int[]{0,2,2,5}, 1, 0);
	}
	
	@Test
	public void test7() {
		test(new int[]{0,2,2,5}, 2, 2);
	}
	
	@Test
	public void test8() {
		test(new int[]{0,2,2,5}, 4, 2);
	}
	
	@Test
	public void test9() {
		test(new int[]{0,2,2,2}, 4, 3);
	}
	
	@Test
	public void test10() {
		test(new int[]{0,2,2,2}, 2, 3);
	}

	private void test(int[] arr, int find, int expected) {
		int answer = sol.solve(arr, find);
		assertEquals(expected, answer);
	}

}
