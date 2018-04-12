import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void test1() {
		Solution sol = new Solution();
		assertEquals(0, sol.minDistance("abd", "abd"));
	}

	@Test
	public void test2() {
		Solution sol = new Solution();
		assertEquals(1, sol.minDistance("abd", "abc"));
	}

	@Test
	public void test3() {
		Solution sol = new Solution();
		assertEquals(3, sol.minDistance("", "abc"));
	}

	@Test
	public void test4() {
		Solution sol = new Solution();
		assertEquals(4, sol.minDistance("abcd", "xyz"));
	}

	@Test
	public void test5() {
		Solution sol = new Solution();
		assertEquals(1, sol.minDistance("a", "ab"));
	}
	
	@Test
	public void test6() {
		Solution sol = new Solution();
		sol.minDistance(
				"abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdef",
				"bcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefg"
				);
	}

}
