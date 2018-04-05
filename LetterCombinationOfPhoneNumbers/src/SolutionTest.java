import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SolutionTest {
	
	@Test
	public void test1() {
		String digits = "23";
		String[] answersArray = new String[]{"ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"};
		List<String> expected = new ArrayList<String>(Arrays.asList(answersArray));
		Solution sol = new Solution();
		assertEquals(expected, sol.letterCombinations(digits));
	}
	
	@Test
	public void test2() {
		String digits = "";
		String[] answersArray = new String[]{};
		List<String> expected = new ArrayList<String>(Arrays.asList(answersArray));
		Solution sol = new Solution();
		assertEquals(expected, sol.letterCombinations(digits));
	}

}
