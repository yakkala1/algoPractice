import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
	
	Solution sol = new Solution();
	
	@Test
	public void test1() {
		test(
				new int[]{1,2,3,4,5},
				4, 3,
				new int[]{1,2,3,4}
				);
	}

	@Test
	public void test2() {
		test(
				new int[]{},
				0, 3,
				new int[]{}
				);
	}


	@Test
	public void test3() {
		test(
				new int[]{1,2,3,4,5},
				1, 3,
				new int[]{3}
				);
	}


	@Test
	public void test4() {
		test(
				new int[]{1,2,2,2,2,2,2,3,3,3,3,3,3,3,4,4,4,4,4,5,5,5,5},
				3, 3,
				new int[]{3,3,3}
				);
	}


	@Test
	public void test5() {
		test(
				new int[]{1,1,1,2,2},
				2, 1,
				new int[]{1,1}
				);
	}


	@Test
	public void test6() {
		test(
				new int[]{1,1,1,1,2,2},
				2, 2,
				new int[]{2,2}
				);
	}


	@Test
	public void test7() {
		test(
				new int[]{
						0,1,2,3,4,4,4,5,5,5,6,7,9,9,10,10,11,11,12,13,14,14,
						15,17,19,19,22,24,24,25,25,27,27,29,30,32,32,33,33,35,
						36,38,39,41,42,43,44,44,46,47,48,49,52,53,53,54,54,57,
						57,58,59,59,59,60,60,60,61,61,62,64,66,68,68,70,72,72,
						74,74,74,75,76,76,77,77,80,80,82,83,85,86,87,87,92,93,
						94,96,96,97,98,99
				},
				25,
				90,
				new int[]{72,74,74,74,75,76,76,77,77,80,80,82,83,85,86,87,87,
						92,93,94,96,96,97,98,99}
				);
	}



	private void test(int[] A, int k, int x, int[] expected) {
		List<Integer> expectedList = new ArrayList<Integer>();
		for(int i:expected) {
			expectedList.add(i);
		}
		Assert.assertEquals( expectedList , sol.findClosestElements(A,k,x) );
	}

}
