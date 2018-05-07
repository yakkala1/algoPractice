import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {
	
	Solution sol = new Solution();

	@Test
	public void test() {
		assertEquals(
				324,
				sol.maxProfitAssignment(
						new int[]{68,35,52,47,86},
						new int[]{67,17,1,81,3},
						new int[]{92,10,85,84,82})
				);
	}

}