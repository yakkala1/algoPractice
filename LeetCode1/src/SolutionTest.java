import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SolutionTest {
	Solution sol = new Solution();

	@Test
	public void test() {
		List<Integer> prices = Arrays.asList(new Integer[]{2,3,4});
		List<List<Integer>> special = new ArrayList<List<Integer>>();
		special.add( Arrays.asList(new Integer[]{1,1,0,4}) );
		special.add( Arrays.asList(new Integer[]{2,2,1,9}) );
		List<Integer> needs = Arrays.asList(new Integer[]{1,2,1});
		int ret = sol.shoppingOffers(prices, special, needs);
		System.out.println(ret);
	}

}
