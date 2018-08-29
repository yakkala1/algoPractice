import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {
	Solution sol = new Solution();

	@Test
	public void test1() {
		test(
				new int[][]{
					{1,2,3},
					{4,5,6},
					{7,8,9}
				},
				new int[][]{
					{7,4,1},
					{8,5,2},
					{9,6,3}
				}
				);
	}

	@Test
	public void test2() {
		test(
				new int[][]{
					{1,2,3},
					{4,5,6},
					{7,8,9}
				},
				new int[][]{
					{7,4,1},
					{8,5,2},
					{9,6,3}
				}
				);
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
	
	public void test(int[][] matrix, int[][] expected) {
		sol.rotate(matrix);
		for(int i=0; i<matrix.length; i++) {
			assertArrayEquals(expected[i], matrix[i]);
		}
	}
	
	public void log(Object obj) {
		System.out.println(obj);
	}

}
