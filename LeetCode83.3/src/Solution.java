class Solution {
    public int consecutiveNumbersSum(int N) {
    	int ret = 0;
        for(int k=1; k<N; k++) {
        	log("k : "+k);
        	if(!startingCondition(N,k))
        		break;
        	if( possible(N,k) )
        		ret++;
        	log("ret : "+ret);
        }
        return ret;
    }

	private boolean startingCondition(int n, int k) {
		long sum = k*(k+1)/2;
		log("sum : "+sum);
		long rem = (long)n - sum;
		log("rem : "+rem);
		if(rem >= 0)
			return true;
		else
			return false;
	}

	private boolean possible(int n, int k) {
		long sum = k*(k+1)/2;
		long rem = (long)n - sum;
		return rem%k==0;
	}
	
	public void log(Object obj) {
		System.out.println(obj);
	}
	
}
