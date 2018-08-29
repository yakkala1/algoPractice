import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	Solution sol = new Solution();
	
	@Test
	public void test1() {
		test(
				new int[]{1,2,4,3},
				new int[]{1,3,2,3},
				2
				);
	}
		
	@Test
	public void test2() {
		test(
				new int[]{},
				new int[]{},
				1
				);
	}
		
	@Test
	public void test3() {
	}
		
	@Test
	public void test4() {
	}
	
	public void test(int[] A, int[] B, int expected) {
		int s = sol.solution(A, B);
		assertEquals(expected, s);
	}
	
}