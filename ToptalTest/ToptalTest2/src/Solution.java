import java.util.*;

import org.junit.rules.ExpectedException;

class Solution {
	
    public int solution(int[] A, int[] B, int[] C) {
    	try {
    		Arrays.sort(A);
    		Arrays.sort(B);
    		Arrays.sort(C);
    		log("A : "+Arrays.toString(A));
    		int n = A.length;
    		log("n : "+n);
    		int[] nC = new int[n];
    		int[] nBC = new int[n];

    		int i=0,j=0;
    		for(i=0; i<n; i++) {
    			while( j<n && C[j]<=B[i] )
    				j++;
    			nC[i] = j<n ? n-j : 0;
    		}
    		
    		int[] cumNC = calculateCum(nC);
    		
    		i=0;
    		j=0;
    		for(i=0; i<n; i++) {
    			while( j<n && B[j]<=A[i] )
    				j++;
    			nBC[i] = j<n ? cumNC[j] : 0;
    			if( nBC[i] == Integer.MAX_VALUE )
    				return -1;
    		}
    		
    		int ret = 0;
    		for(i=0; i<n; i++) {
    			ret = add(ret,nBC[i]);
    		}
    		
    		return ret;
    	} catch(ExceededException e) {
    		return -1;
    	}
    }
    
    private int add(int i, int j) throws ExceededException {
    	long li = i;
    	long lj = j;
    	if(li+lj > 1000000000l)
    		throw new ExceededException();
    	else 
    		return i+j;
	}

	private int[] calculateCum(int[] nC) {
		int n = nC.length;
		int[] ret = new int[n];
		int cur = 0;
		for(int i=n-1; i>=0; i--) {
			try {
				if( cur==Integer.MAX_VALUE )
					throw new ExceededException();
				cur = add(cur,nC[i]);
			} catch(ExceededException e) {
				cur = Integer.MAX_VALUE;
			}
			ret[i] = cur;
		}
		return ret;
	}
	
	private void log(Object obj) {
		System.out.println(obj);
	}

	class ExceededException extends Exception {
    }
    
}