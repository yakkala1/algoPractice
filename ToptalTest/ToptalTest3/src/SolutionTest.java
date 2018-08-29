import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	Solution sol = new Solution();
	
	@Test
	public void test1() {
		test( 
				new int[]{9, 1, 4, 9, 0, 4, 8, 9, 0, 1},
				new int[]{}
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
	
	public void test(int[] A, int[] expected) {
		assertArrayEquals(expected, sol.solution(A));
	}
	
}