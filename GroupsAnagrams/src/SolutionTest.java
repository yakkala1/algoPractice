import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class SolutionTest {
	Solution sol = new Solution();

	@Test
	public void test1() {
		test(new String[]{
				"eat", "tea", "tan", "ate", "nat", "bat"
		});
	}


	@Test
	public void test2() {
	}

	@Test
	public void test3() {
	}

	@Test
	public void test4() {
	}
	
	@Test
	public void test5() {
	}
	
	private void test(String[] strings) {
		List<List<String>> ret = sol.groupAnagrams(strings);
		System.out.println(ret);
	}
	
	public void log(Object obj) {
		System.out.println(obj);
	}

}
