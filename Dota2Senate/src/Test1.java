import static org.junit.Assert.*;

import org.junit.Test;

public class Test1 {

	@Test
	public void test1() {
		test("RD","Radiant");
	}

	@Test
	public void test2() {
		test("RDD","Dire");
	}

	private void test(String string, String expected) {
		Solution sol = new Solution();
		assertEquals(expected, sol.predictPartyVictory(string));
	}

}
