import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {
	Solution sol = new Solution();

	@Test
	public void test1() {
		test("pwwkew",3);
	}

	@Test
	public void test2() {
		test("abcabcbb",3);
	}

	@Test
	public void test3() {
		test("",0);
	}

	@Test
	public void test4() {
		test("bbbb",1);
	}
	
	@Test
	public void test5() {
		test("b",1);
	}
	
	public void test(String str, int expected) {
		int ret = sol.lengthOfLongestSubstring(str);
		assertEquals(expected, ret);
	}
	
	public void log(Object obj) {
		System.out.println(obj);
	}

}
