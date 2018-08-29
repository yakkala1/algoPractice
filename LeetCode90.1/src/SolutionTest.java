import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class SolutionTest {
	Solution sol = new Solution();

	@Test
	public void test1() {
		test("ab","ba",true);
	}

	@Test
	public void test2() {
		test("ab","ab",false);
	}

	@Test
	public void test3() {
		test("aa","aa",true);
	}

	@Test
	public void test4() {
		test("ab","ca",false);
	}
	
	public void test(String A, String B, boolean expected) {
		assertEquals(expected, sol.buddyStrings(A, B));
	}
	
	public void log(Object obj) {
		System.out.println(obj);
	}

}
