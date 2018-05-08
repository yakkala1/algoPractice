import static org.junit.Assert.*;
import org.junit.*;

public class SolutionTest {
	Solution sol = new Solution();

	@Test
	public void test1() {
		assertEquals(
				"11000000101110",
				sol.solve(12334));
	}

	@Test
	public void test2() {
		assertEquals(
				"11000010001111",
				sol.solve(12431));
	}


	@Test
	public void test3() {
		assertEquals(
				"0",
				sol.solve(0));
	}


	@Test
	public void test4() {
		assertEquals(
				"1",
				sol.solve(1));
	}


}
