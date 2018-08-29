import java.util.*;

class Solution {
	
    public int solution(int[] A, int[] B) {
    	Set<Integer> set = new HashSet<Integer>();
    	int n = A.length;
    	for(int i=0; i<n; i++) {
    		if(A[i] == B[i])
    			set.add(A[i]);
    	}
    	for(int i=1; i<=n+1; i++) {
    		if( !set.contains(i) ) {
    			return i;
    		}
    	}
    	return -1;
    }
	
}