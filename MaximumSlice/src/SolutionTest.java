import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	Solution sol = new Solution();
	
	@Test
	public void test1() {
		test(new int[]{1,23,4} , 0);
	}
		
	@Test
	public void test2() {
		test(new int[]{1,1,4,10} , 4);
	}
		
	@Test
	public void test3() {
		test(new int[]{-1, -45, 0, 12, 1, 3, -2, -12} , 16);
	}
		
	@Test
	public void test4() {
		test(new int[]{3, 2, 6, -1, 4, 5, -1, 2} , 17);
	}
	
	public void test(int[] A, int expected) {
		assertEquals(expected, sol.solution(A));
	}
	
}