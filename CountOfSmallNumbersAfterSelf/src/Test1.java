import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.Assert;

public class Test1 {
	Solution sol = new Solution();
	
	@Test
	public void test1() {
		test(new int[]{5,2,6,1}, 
				new int[]{2,1,1,0});
	}
	
	@Test
	public void test2() {
		test(
				new int[]{1,2,3,4,5},
				new int[]{0,0,0,0,0}
				);
	}
	
	@Test
	public void test3() {
		test(
				new int[]{5,4,3,2,1},
				new int[]{4,3,2,1,0}
				);
	}

	@Test
	public void test4() {
		test(
				new int[]{5,4,3,2,1,2,3,4,5},
				new int[]{7,5,3,1,0,0,0,0,0}
				);
	}
	
	@Test
	public void test5() {
		test(
				new int[]{},
				new int[]{}
				);
	}

	@Test
	public void test6() {
		test(
				new int[]{1},
				new int[]{0}
				);
	}

	private void test(int[] array, int[] expected) {
		List<Integer> answer = sol.countSmaller(array);
		Assert.assertEquals(expected.length , answer.size());
		for(int i=0; i<expected.length; i++)
			Assert.assertEquals(expected[i] , (int)answer.get(i));
	}

}
