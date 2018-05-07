import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {
	
	Solution sol = new Solution();

	@Test
	public void test1() {
		assertEquals(2,sol.numFriendRequests(new int[]{16,16}));
	}

	@Test
	public void test2() {
		assertEquals(2,sol.numFriendRequests(new int[]{16,17,18}));
	}

	@Test
	public void test3() {
		assertEquals(3,sol.numFriendRequests(new int[]{20,30,100,100,110,120}));
	}



}
