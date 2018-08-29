import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {
	Solution sol = new Solution();

	@Test
	public void test1() {
		test(1,2,3,2);
	}

	@Test
	public void test2() {
		test(4,2,3,6);
	}

	@Test
	public void test3() {
		test(5,2,4,10);
	}

	@Test
	public void test4() {
		test(10,6,3,30);
	}
	
	public void test(int N, int A, int B, int expected) {
		Solution sol = new Solution();
		assertEquals(expected , sol.nthMagicalNumber(N, A, B));
	}
	
	public void log(Object obj) {
		System.out.println(obj);
	}

}
