package triangleDp;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void test1() {
		test(new Integer[][]{}, 0);
	}

	@Test
	public void test2() {
		test(new Integer[][]{{2},{3,4},{6,5,7},{4,1,8,3}}, 11);
	}

	private void test(Integer[][] array, int ans) {
		List<List<Integer>> arr = new ArrayList<List<Integer>>();
		int n = array.length;
		for(Integer[] line : array) {
			arr.add(Arrays.asList(line));
		}
		Solution sol = new Solution();
		assertEquals( ans , sol.minimumTotal(arr) );
	}

}
