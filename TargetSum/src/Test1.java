import static org.junit.Assert.*;

import org.junit.Test;

public class Test1 {
	
	@Test
	public void test1() {
		test(new int[]{1,1,1,1,1}, 3, 5);
	}
	
	@Test
	public void test2() {
		test(
				new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				1,
				123
				);
	}

	public void test(int[] nums, int S, int expected) {
		Solution sol = new Solution();
		assertEquals(expected, sol.findTargetSumWays(nums,S));
	}

}
