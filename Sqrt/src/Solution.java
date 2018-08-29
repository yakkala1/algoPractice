
public class Solution {

	public int sqrt(int n) {
		return (int)sqrt((long)n);
	}

	private long sqrt(long n) {
		long low = 0;
		long high = Integer.MAX_VALUE;
		while( low<=high ) {
			long mid = low + (high-low)/2;
			long midSqr = sqr(mid);
			long midPlusOneSqr = sqr(mid+1);
			if( n>=midPlusOneSqr ) {
				low = mid+1;
			} else if( n>=midSqr ) {
				return mid;
			} else {
				high = mid-1;
			}
		}
		return -1;
	}

	private long sqr(long a) {
		return a*a;
	}

}