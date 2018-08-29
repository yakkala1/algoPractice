import static org.junit.Assert.*;

import org.junit.Test;

public class Test1 {
	
	@Test
	public void test1() {
		int[][] grid = new int[][]{{4,3,8,4},
		                           {9,5,1,9},
		                           {2,7,6,2}};
		                           test(grid,1);
	}
	
	@Test
	public void test2() {
		int[][] grid = new int[][]{{10,3,5},
            {1,6,11},
            {7,9,2}};
            test(grid,0);
	}

	public void test(int[][] grid, int expected) {
		Solution sol = new Solution();
		int answer = sol.numMagicSquaresInside(grid);
		assertEquals(expected,answer);
	}

}
