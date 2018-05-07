import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {
	
	Solution sol = new Solution();

	@Test
	public void test1() {
		assertEquals(
				2, 
				sol.search(
						new int[]{0,1,3,4,5,6,7}, 
						3)
				);
	}

	@Test
	public void test2() {
		assertEquals(
				-1, 
				sol.search(
						new int[]{}, 
						3)
				);
	}

	@Test
	public void test3() {
		assertEquals(
				0, 
				sol.search(
						new int[]{2}, 
						2)
				);
	}

	@Test
	public void test5() {
		assertEquals(
				2, 
				sol.search(
						new int[]{0,1,3,4,5,6,7}, 
						3)
				);
	}

}