import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {
	Solution sol = new Solution();
	
	@Test
	public void test1() {
		assertArrayEquals(
				new int[]{2,5},
				sol.kthSmallestPrimeFraction(new int[]{1,2,3,5}, 3)
				);
	}

}
