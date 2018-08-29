import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class SolutionTest {
	Solution sol = new Solution();

	@Test
	public void test1() {
		test(new int[]{1,2,3});
	}

	@Test
	public void test2() {
		test(new int[]{1,3,2});
	}

	@Test
	public void test3() {
		test(new int[]{1,1,2});
	}

	@Test
	public void test4() {
		test(new int[]{2,1,2,2,2,2,2,1});
	}
	
	@Test
	public void test5() {
	}
	
	public void test(int[] nums) {
		sol.nextPermutation(nums);
		System.out.println( Arrays.toString(nums) );
	}
	
	public void log(Object obj) {
		System.out.println(obj);
	}

}
