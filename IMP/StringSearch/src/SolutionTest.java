import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {
	Solution sol = new Solution();
	@Test
	public void test1() {
		assertArrayEquals(
				new Integer[]{2,4,10},
				sol.search(
						"ey",
						"jkeyeyjhdney"
						)
				);
	}
	@Test
	public void test2() {
		assertArrayEquals(
				new Integer[]{0,1,2,3},
				sol.search(
						"aa",
						"aaaaa"
						)
				);
	}

}
