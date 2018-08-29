import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {
	Solution sol = new Solution();

	@Test
	public void test1() {
		test(
				5,3,
				new int[]{2,2},
				new int[]{2,3},
				2
				);
	}

	@Test
	public void test2() {
		test(
				10,5,
				new int[]{2,3,5},
				new int[]{6,7,8},
				7
				);
	}

	@Test
	public void test3() {
	}

	@Test
	public void test4() {
	}
	
	public void test(int G, int P, int[] groups, int[] profits, int expected) {
		Solution sol = new Solution();
		assertEquals( expected , sol.profitableSchemes(G, P, groups, profits) );
	}
	
	public void log(Object obj) {
		System.out.println(obj);
	}

}
