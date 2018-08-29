class Solution {
	long A,B,lcm,N;
	
    public int nthMagicalNumber(int N, int A, int B) {
    	this.A = A;
    	this.B = B;
    	this.N = N;
    	this.lcm = lcm();
    	
    	long low = 1;
    	long high = Math.max(this.A, this.B) * N;
    	while( low<=high ) {
    		long mid = low + (high-low)/2;
    		long total = getTotal(mid);
    		log("mid : "+mid);
    		log("total : "+total);
    		if(total==N)
    			return answer(mid);
    		else if(total>N)
    			high = mid-1;
    		else
    			low = mid+1;
    	}
    	return -1;
    }

	private void log(Object obj) {
		System.out.println(obj);
	}

	private int answer(long mid) {
		log("answer");
		log("mid : "+mid);
		log("A : "+A);
		long max = Math.max( (mid/A)*A , (mid/B)*B );
		log("max : "+max);
		return (int)( max%(1_000_000_007) );
	}

	private long getTotal(long P) {
		return P/A + P/B - P/lcm;
	}

	private long lcm() {
		return (A*B)/gcd(A,B);
	}

	private long gcd(long A, long B) {
		if( A<B )
			return gcd(B,A);
		else {
			if( A%B == 0 )
				return B;
			else
				return gcd(B,A%B);
		}
	}
    
}
