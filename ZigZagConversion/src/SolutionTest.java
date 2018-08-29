import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	Solution sol = new Solution();
	
	@Test
	public void test1() {
		test("PAYPALISHIRING",3,"PAHNAPLSIIGYIR");
	}
		
	@Test
	public void test2() {
		test("PAYPALISHIRING",4,"PINALSIGYAHRPI");
	}
		
	@Test
	public void test3() {
		test("PAYPALISHIRING",1,"PAYPALISHIRING");
	}
		
	@Test
	public void test4() {
	}
	
	public void test(String string, int numRows, String expected) {
		assertEquals(expected, sol.convert(string, numRows));
	}
	
}