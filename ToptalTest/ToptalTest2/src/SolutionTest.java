import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	Solution sol = new Solution();
	
	@Test
	public void test1() {
		test(
				new int[]{29,50},
				new int[]{61,37},
				new int[]{37,70},
				3
				);
	}
		
	@Test
	public void test2() {
		test(
				new int[]{29,29},
				new int[]{61,61},
				new int[]{70,70},
				8
				);
	}
		
	@Test
	public void test3() {
		test(
				new int[]{5},
				new int[]{5},
				new int[]{5},
				0
				);
	}
		

	@Test
	public void test4() {
		test(
				new int[]{},
				new int[]{5},
				new int[]{5},
				0
				);
	}

	@Test
	public void test5() {
	}
	
	public void test(int[] A, int[] B, int[] C, int expected) {
		assertEquals( expected,sol.solution(A, B, C) );
	}
	
}