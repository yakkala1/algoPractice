import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {
	Solution sol = new Solution();
	@Test
	public void test1() {
		assertEquals(2,sol.consecutiveNumbersSum(5));
	}

	@Test
	public void test2() {
		assertEquals(3,sol.consecutiveNumbersSum(9));
	}

	@Test
	public void test3() {
		assertEquals(4,sol.consecutiveNumbersSum(15));
	}

	@Test
	public void test4() {
	}

}
