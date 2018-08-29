import static org.junit.Assert.*;

import org.junit.Test;

public class Test1 {

	@Test
	public void test1() {
		test( new int[]{1,5,2} , false );
	}
	
	@Test
	public void test2() {
		test( new int[]{1,5,233,7} , true );
	}
	
	public void test(int[] nums, boolean expected) {
		Solution sol = new Solution();
		assertEquals( expected , sol.PredictTheWinner(nums) );
	}

}
