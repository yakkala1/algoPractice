import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution {

	public int countRangeSum(int[] nums, int lower, int upper) {
		int n = nums.length;
		log( "nums : "+Arrays.toString(nums) );
		log( "lower :"+lower );
		log( "upper : "+upper );
		TreeSet<SumFromZero> sums = new TreeSet<SumFromZero>(
				new Comparator<SumFromZero>() {
					@Override
					public int compare(SumFromZero o1, SumFromZero o2) {
						if( o1.sum!=o2.sum )
							return Long.compare(o1.sum, o2.sum);
						else
							return Long.compare(o1.to, o2.to);
					}
				}
				);
		sums.add( new SumFromZero(0,0) );
		int sum = 0;
		int count = 0;
		for(int i=0; i<n; i++) {
			log("i : "+i);
			sum += nums[i];
			log("sum : "+sum);
			int lowerLimit = sum-upper;
			log("lower : "+lowerLimit);
			int upperLimit = sum-lower;
			log("upper : "+upperLimit);
			int possibles = sums.subSet(new SumFromZero(0,lowerLimit), new SumFromZero(0,upperLimit+1)).size();
			log("possibles : "+possibles);
			count += possibles;
			sums.add( new SumFromZero(i+1, sum) );
			log("sums : "+sums);
		}
		return (int)count;
	}
	
	public void log(Object obj) {
		//System.out.println(obj);
	}

	class SumFromZero {
		public int to,sum;
		public SumFromZero(int to, int sum) {
			this.sum = sum;
			this.to = to;
		}
		@Override
		public String toString() {
			return String.format("AE(%d,%d)", to, sum);
		}
	}
	
}