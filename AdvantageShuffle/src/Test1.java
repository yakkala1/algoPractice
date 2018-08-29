import static org.junit.Assert.*;

import org.junit.Test;

public class Test1 {

	@Test
	public void test1() {
		test(
				new int[]{2,7,11,15},
				new int[]{1,10,4,11},
				new int[]{2,11,7,15}
				);
	}

	@Test
	public void test2() {
		test(
				new int[]{12,24,8,32},
				new int[]{13,25,32,11},
				new int[]{24,32,8,12}
				);
	}

	private void test(int[] A, int[] B, int[] expected) {
		Solution sol = new Solution();
		assertArrayEquals(expected, sol.advantageCount(A, B));
	}

}
