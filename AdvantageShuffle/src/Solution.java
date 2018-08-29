import java.util.Arrays;
import java.util.Collections;

public class Solution {
	
    public int[] advantageCount(int[] A, int[] B) {
    	log("A : "+Arrays.toString(A));
    	log("B : "+Arrays.toString(B));
    	Arrays.sort(A);
    	int n = B.length;
		Pair[] sortedB = new Pair[n];
    	for(int i=0; i<n; i++) {
    		Pair p = new Pair(i,B[i]);
    		sortedB[i] = p;
    	}
    	Arrays.sort( sortedB );
    	int i=0, j=0, indexFromEnd=n-1;
    	while(i<n) {
    		while( i<n && A[i]<=sortedB[j].value ) {
    			sortedB[indexFromEnd--].indexA = i++;
    		}
    		if(i<n)
    			sortedB[j++].indexA = i++;
    	}
    	log( Arrays.toString( sortedB ) );
    	
    	int[] ret = new int[n];
    	for(Pair p : sortedB)
    		ret[p.index] = A[p.indexA];
    	
    	return ret;
    }
    
    private void log(Object obj) {
		System.out.println(obj);
	}

	class Pair implements Comparable<Pair> {
    	public int index,value,indexA;
    	public Pair(int index, int value) {
    		this.index = index;
    		this.value = value;
    	}
		@Override
		public int compareTo(Pair o) {
			return Integer.compare(value, o.value);
		}
		@Override
		public String toString() {
			return String.format("{%d:%d:%d}", index, value, indexA);
		}
	}
    
}
