import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Test1 {

	@Test
	public void test1() {
		test(
				new int[][]{{1},{2},{3},{}},
				true
				);
	}

	private void test(int[][] is, boolean b) {
		List<List<Integer>> rooms = new ArrayList<List<Integer>>();
		for(int i=0; i<is.length; i++)
			rooms.add( Arrays.asList(is[i]) );
		Solution sol = new Solution();
		assertEquals(b, sol.canVisitAllRooms(rooms));
	}

}
