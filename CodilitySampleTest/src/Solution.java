import java.util.*;


class Solution {
	
    public int solution(int[] A) {
    	Arrays.sort(A);
    	int ret = 1;
    	for(int i=0; i<A.length; i++) {
    		if(A[i] > ret)
    			return ret;
    		else if(A[i] == ret)
    			ret++;
    	}
    	return ret;
    }
    
}