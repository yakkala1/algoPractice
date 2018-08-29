import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {
	Solution sol = new Solution();

	@Test
	public void test1() {
		test(
				new int[][]{
					new int[]{1, 3,  5,  7},
					new int[]{10, 11, 16, 20},
					new int[]{23, 30, 34, 50}
				},
				3
				);
	}

	@Test
	public void test2() {
	}

	@Test
	public void test3() {
	}

	@Test
	public void test4() {
	}
	
	@Test
	public void test5() {
	}
	
	public void test(int[][] matrix, int target) {
		sol.searchMatrix(matrix, target);
	}
	
	public void log(Object obj) {
		System.out.println(obj);
	}

}
