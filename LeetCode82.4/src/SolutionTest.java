import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {
	
	Solution sol = new Solution();

	@Test
	public void test1() {
		assertEquals(
				3, 
				sol.largestIsland( new int[][]{{1,0},{0,1}} )
		);
	}

}
