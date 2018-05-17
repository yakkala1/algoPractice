import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {
	Solution sol = new Solution();

	@Test
	public void test1() {
		log( sol.largeGroupPositions("abbxxxxzzy") );
	}

	@Test
	public void test2() {
		log( sol.largeGroupPositions("abc") );
	}

	@Test
	public void test3() {
		log( sol.largeGroupPositions("abcdddeeeeaabbbcd") );
	}

	@Test
	public void test4() {
	}
	
	public void log(Object obj) {
		System.out.println(obj);
	}

}
