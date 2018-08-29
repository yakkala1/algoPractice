import static org.junit.Assert.*;

import org.junit.Test;

public class Test1 {

	@Test
	public void test1() {
		test(new char[][]{
		},
				0
				);
	}

	@Test
	public void test2() {
		test(new char[][]{{}},
				0
				);
	}


	@Test
	public void test3() {
		test(new char[][]
				{
			{'1','0','1','0','0'},
			{'1','0','1','1','1'},
			{'1','1','1','1','1'},
			{'1','0','0','1','0'}
				},
				6
				);
	}


	@Test
	public void test4() {
		test(new char[][]
				{
			{1}
				},
				1
				);
	}


	private void test(char[][] is, int i) {
		Solution sol = new Solution();
		assertEquals(i,sol.maximalRectangle(is));
	}

}
