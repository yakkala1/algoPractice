class Solution {
	
    public int divide(int dividend, int divisor) {
    	return (int)divide((long)dividend,(long)divisor);
    }
	
    public long divide(long dividend, long divisor) {
    	log(dividend+","+divisor);
    	log(-dividend);
        if(dividend<0 && divisor<0) {
        	return divide(-1*dividend,-1*divisor);
        } else if(dividend<0) {
        	return -divide(-1*dividend,divisor);
        } else if(divisor<0) {
        	return -divide(dividend,-1*divisor);
        }
        int sum = 0;
        int answer = 0;
        while(sum<=dividend) {
        	answer++;
        	sum += divisor;
        	log("sum : "+sum);
        }
        log("answer : "+answer);
        return answer-1;
    }

	private void log(Object obj) {
		System.out.println(obj);
	}

}