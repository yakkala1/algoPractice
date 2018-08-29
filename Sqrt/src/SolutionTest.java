import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {
	Solution sol = new Solution();

	@Test
	public void test1() {
		test(5,2);
	}
	
	@Test
	public void test2() {
		test(4,2);
	}
	
	@Test
	public void test3() {
		test(0,0);
	}
	
	@Test
	public void test4() {
		test(1073741824,32768);
	}
	
	@Test
	public void test5() {
		test(2147483647,46340);
	}
	
	private void test(int n, int expected) {
		assertEquals(expected, sol.sqrt(n));
	}

}
