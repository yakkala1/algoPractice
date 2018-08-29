import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {
	Solution sol = new Solution();

	@Test
	public void test1() {
		test(5,3);
	}

	@Test
	public void test2() {
		test(-2147483648,-1);
	}

	@Test
	public void test3() {
		test(0,1);
	}

	@Test
	public void test4() {
	}
	
	@Test
	public void test5() {
	}
	
	public void test(int i, int j) {
		sol.divide(i, j);
	}
	
	public void log(Object obj) {
		System.out.println(obj);
	}

}
