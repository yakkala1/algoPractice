import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<List<Integer>> largeGroupPositions(String S) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		int gStart = 0;
		int gSize = 1;
		int N = S.length();
		for( int i=1; i<N; i++ ) {
			if( S.charAt(gStart)==S.charAt(i) ) {
				gSize++;
			} else {
				if(gSize>=3) {
					List<Integer> g = new ArrayList<Integer>();
					g.add(gStart);
					g.add(i-1);
					ret.add(g);
				} else {
				}
				gStart = i;
				gSize = 1;
			}
		}
		if(gSize>=3) {
			List<Integer> g = new ArrayList<Integer>();
			g.add(gStart);
			g.add(N-1);
			ret.add(g);
		}
		return ret;
	}
}
