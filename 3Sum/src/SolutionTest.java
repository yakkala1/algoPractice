import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {
	Solution sol = new Solution();

	@Test
	public void test1() {
		test( new int[]{-1, 0, 1, 2, -1, -4} );
	}

	@Test
	public void test2() {
	}

	@Test
	public void test3() {
	}

	@Test
	public void test4() {
	}
	
	@Test
	public void test5() {
	}
	
	public void test(int[] arr) {
		System.out.println( sol.threeSum(arr) );
	}
	
	public void log(Object obj) {
		System.out.println(obj);
	}

}
