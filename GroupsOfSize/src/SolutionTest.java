import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {
	Solution sol = new Solution();

	@Test
	public void test1() {
		assertEquals(2,sol.solve(5,2));
	}

	@Test
	public void test2() {
		assertEquals(5,sol.solve(10,3));
	}


}
