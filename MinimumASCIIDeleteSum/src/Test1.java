import static org.junit.Assert.*;

import org.junit.Test;

public class Test1 {

	@Test
	public void test1() {
		test("sea","eat",231);
	}
	
	@Test
	public void test2() {
		test("delete", "leet", 403);
	}
	
	public void test(String s1 , String s2, int expected) {
		Solution sol = new Solution();
		assertEquals(expected , sol.minimumDeleteSum(s1,s2));
	}

}
