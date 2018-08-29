import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	Solution sol = new Solution();
	
	@Test
	public void test1() {
		test(new int[]{1,2,4,5,1} , 3);
	}
		
	@Test
	public void test2() {
		test(new int[]{10,2,4,5,-10} , 1);
	}
		
	@Test
	public void test3() {
		test(new int[]{} , 1);
	}
		
	@Test
	public void test4() {
		test(new int[]{-1,-2,-4,-5,-1} , 1);
	}
	
	public void test(int[] A, int expected) {
		assertEquals(expected, sol.solution(A));
	}
	
}