import static org.junit.Assert.*;

public class Test {
	
	Solution sol = new Solution();

	@org.junit.Test
	public void test1() {
		test(new int[]{1,2,3,1},2);
	}

	@org.junit.Test
	public void test2() {
		test(new int[]{1,2,3,4},3);
	}


	@org.junit.Test
	public void test3() {
		test(new int[]{5,3,2},0);
	}


	@org.junit.Test
	public void test4() {
		test(new int[]{1,2,3,1,-3,-5,-2,},2);
	}


	private void test(int[] A, int expected) {
		assertEquals(expected, sol.findPeakElement(A));
	}

}
