import static org.junit.Assert.*;

public class Test {
	Solution sol = new Solution();

	@org.junit.Test
	public void test1() {
		test(new int[]{1,2,3,1}, 3, 0,true);
	}

	@org.junit.Test
	public void test2() {
		test(new int[]{1,0,1,1}, 1, 2,true);
	}

	@org.junit.Test
	public void test3() {
		test(new int[]{1,5,9,1,5,9}, 2, 3,false);
	}

	@org.junit.Test
	public void test4() {
		test(new int[]{1,2147483647}, 1, 2147483647,true);
	}
	
	@org.junit.Test
	public void test5() {
		test(new int[]{0}, 0, 0, false);
	}

	private void test(int[] is, int i, int j, boolean expected) {
		assertEquals(expected, sol.containsNearbyAlmostDuplicate(is,i,j));
	}

}
