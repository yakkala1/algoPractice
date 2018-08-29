import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

	Solution sol = new Solution();
	
	@Test
	public void test1() {
		test(new int[]{1,2,4,5,1}, new int[]{1,1,2,4,5});
	}
		
	@Test
	public void test2() {
		test(new int[]{}, new int[]{});
	}
		
	@Test
	public void test3() {
		test(new int[]{2}, new int[]{2});
	}
		
	@Test
	public void test4() {
		test(new int[]{5,4,3,2,1} , new int[]{1,2,3,4,5});
	}

	@Test
	public void test5() {
		test(new int[]{5,4} , new int[]{4,5});
	}

	public void test(int[] A, int[] expected) {
		sol.solution(A);
		Assert.assertArrayEquals(expected, A);
	}
	
}