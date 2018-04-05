import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void test() {
		int[] arr = new int[]{50,52,51,52,50};
		Solution sol = new Solution();
		assertEquals(7, sol.candy(arr));
	}

	@Test
	public void test1() {
		int[] arr = new int[]{50,52,51,52,50,51};
		Solution sol = new Solution();
		sol.candy(arr);
	}

	@Test
	public void test2() {
		int[] arr = new int[]{1,2,2};
		Solution sol = new Solution();
		sol.candy(arr);
	}

	@Test
	public void test3() {
		int[] arr = new int[]{50,52,51,51,51,52,50,51};
		Solution sol = new Solution();
		sol.candy(arr);
	}

	@Test
	public void test4() {
		int[] arr = new int[]{50,52,53,54,52,50,51};
		Solution sol = new Solution();
		sol.candy(arr);
	}
	@Test
	public void test5() {
		int[] arr = new int[]{50,52,54,53,52,50,51};
		Solution sol = new Solution();
		sol.candy(arr);
	}
	@Test
	public void test6() {
		int[] arr = new int[]{50,52,51,51,52,50,51};
		Solution sol = new Solution();
		sol.candy(arr);
	}
	
	@Test
	public void test7() {
		int[] arr = new int[]{};
		Solution sol = new Solution();
		assertEquals(0, sol.candy(arr));
	}
	
	@Test
	public void test8() {
		int[] arr = new int[]{50};
		Solution sol = new Solution();
		assertEquals(1, sol.candy(arr));
	}
	
	@Test
	public void test9() {
		int[] arr = new int[]{50,52};
		Solution sol = new Solution();
		assertEquals(3, sol.candy(arr));
	}
	
	@Test
	public void test10() {
		int[] arr = new int[]{50,50};
		Solution sol = new Solution();
		assertEquals(2, sol.candy(arr));
	}
	
}
