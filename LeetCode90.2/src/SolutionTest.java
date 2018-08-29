import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {
	Solution sol = new Solution();

	@Test
	public void test1() {
		test("()",1);
	}

	@Test
	public void test2() {
		test("(())",2);
	}

	@Test
	public void test3() {
		test("()()",2);
	}

	@Test
	public void test4() {
		test("(()(()))",6);
	}
	
	public void test(String str, int expected) {
		assertEquals(expected, sol.scoreOfParentheses(str));
	}
	
	public void log(Object obj) {
		System.out.println(obj);
	}

}
