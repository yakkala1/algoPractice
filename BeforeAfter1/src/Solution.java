import java.util.*;


class Solution {
	
    public int solution(int[] A, int a) {
    	log("A : "+Arrays.toString(A));
    	int n = A.length;
    	int totalA = getTotalA(A,a);
    	log("totalA : "+totalA);
    	int beforeA = 0;
    	int remA = totalA;
    	for(int i=0; i<n; i++) {
    		log("");
    		log("i : "+i);
    		int cur = A[i];
    		int beforeANext;
    		if(cur == a) {
    			beforeANext = beforeA+1;
    			remA--;
    		} else {
    			beforeANext = beforeA;
    		}
    		log("beforeA : "+beforeA);
    		log("remA : "+remA);
    		if( checkCondition(n,i,beforeA,remA) )
    			return i;
    		beforeA = beforeANext;
    	}
    	return -1;
    }

	private int getTotalA(int[] A, int a) {
		int ret = 0;
		for(int i:A) {
			if(i==a)
				ret++;
		}
		return ret;
	}

	private boolean checkCondition(int n, int i, int beforeA, int remA) {
		int remElements = n-1-i;
		int remNonA = remElements-remA;
		return (beforeA==remNonA);
	}
	
	private void log(Object obj) {
		System.out.println(obj);
	}
    
}