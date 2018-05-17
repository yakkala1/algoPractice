import java.util.HashMap;
import java.util.Map;

class Solution {
	String S;
	int N;
	int[] mem;
    private static int MOD = 1000000007;
    public int uniqueLetterString(String S) {
    	this.S = S;
        N = S.length();
        if(N==0)
            return 0;
        mem = new int[N];
        for(int i=0; i<N; i++) {
        	solve(i);
        }
        return mem[N-1];
    }
	private void solve(int to) {
		int ans = calculate(to);
		mem[to] = ans;
	}
	private int calculate(int to) {
		if(to == 0)
			return 1;
		long ret = mem[to-1];
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		int uniqueCs = 0;
		for(int i=to; i>=0; i--) {
			char c = S.charAt(i);
			if(map.containsKey(c)) {
				int nCs = map.get(c);
				if(nCs == 1) {
					map.put(c, -1);
					uniqueCs--;
				} else {
					
				}
			} else {
				map.put(c, 1);
				uniqueCs++;
			}
			ret += uniqueCs;
            ret %= MOD;
		}
		return (int)ret;
	}
}
