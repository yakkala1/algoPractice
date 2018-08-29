import java.util.HashMap;

public class Solution {

	private int[] nums;
	HashMap<Params,Integer> mem;

	public int findTargetSumWays(int[] nums, int S) {
		this.nums = nums;
		mem = new HashMap<Params,Integer>();
		return get(new Params(nums.length,S));
	}
	
	private int get(Params params) {
		if( !mem.containsKey(params) )
			mem.put(params , calculate(params));
		return mem.get(params);
	}

	private int calculate(Params params) {
		if( params.to==0 ) {
			if( params.S==0 )
				return 1;
			else
				return 0;
		} else {
			int to = params.to;
			int S = params.S;
			int num = nums[to-1];
			Params case1 = new Params(to-1,S+num);
			Params case2 = new Params(to-1,S-num);
			return get(case1) + get(case2);
		}
	}

	class Params {
		public int to,S;
		public Params(int to, int S) {
			this.to = to;
			this.S = S;
		}
		@Override
		public boolean equals(Object obj) {
			Params other = (Params)obj;
			return this.to==other.to && this.S==other.S;
		}
		@Override
		public int hashCode() {
			return Integer.hashCode(to)+Integer.hashCode(S);
		}
	}

}
