import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Test1 {
	
	@Test
	public void test1() {
		test("123456579", 
				Arrays.asList( new Integer[]{123,456,579} )
				);
	}
	
	@Test
	public void test2() {
		test("11235813", 
				Arrays.asList( new Integer[]{1,1,2,3,5,8,13} )
				);
	}
	
	@Test
	public void test3() {
		test("112358130", 
				Arrays.asList( new Integer[]{} )
				);
	}
	
	@Test
	public void test4() {
		test("1101111", 
				Arrays.asList( new Integer[]{110, 1, 111} )
				);
	}

	
	@Test
	public void test5() {
		test("0123", 
				Arrays.asList( new Integer[]{} )
				);
	}

	@Test
	public void test6() {
		test("214748364721474836422147483641", 
				Arrays.asList( new Integer[]{} )
				);
	}


	public void test(String S, List<Integer> expected) {
		Solution sol = new Solution();
		assertEquals(expected, sol.splitIntoFibonacci(S));
	}

}
