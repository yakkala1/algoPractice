import static org.junit.Assert.*;

import org.junit.Test;

public class GCDTest {
	Solution sol = new Solution();

	@Test
	public void test1() {
		assertEquals(
				sol.solve(1,1),
				1
				);
	}

	@Test
	public void test2() {
		assertEquals(
				sol.solve(1,50),
				1
				);
	}


	@Test
	public void test3() {
		assertEquals(
				sol.solve(50,50),
				50
				);
	}


	@Test
	public void test4() {
		assertEquals(
				sol.solve(294,96),
				6
				);
	}


	@Test
	public void test5() {
		assertEquals(
				sol.solve(123,234),
				3
				);
	}

	@Test
	public void test6() {
		assertEquals(
				sol.solve(141894,4221),
				9
				);
	}


}
