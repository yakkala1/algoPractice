import static org.junit.Assert.*;

public class Test {
	Solution sol = new Solution();

	@org.junit.Test
	public void test1() {
		test("","",true);
	}
	
	@org.junit.Test
	public void test2() {
		test("abc","aabbbccd",true);
	}

	@org.junit.Test
	public void test3() {
		test("abc","ahbgdc",true);
	}

	@org.junit.Test
	public void test4() {
		test("axc","ahbgdc",false);
	}

	private void test(String sequence, String string, boolean expected) {
		assertEquals(expected, sol.isSubsequence(sequence,string));
	}

}
