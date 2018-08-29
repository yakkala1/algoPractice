import java.util.*;

class Solution {
	
    public void solution(int[] A) {
    	int n = A.length;
    	heapify(A);
    	for(int i=0; i<n; i++) {
    		int latestIndex = n-1-i;
    		swap(A,0,latestIndex);
    		heapify(A,0,latestIndex-1);
    	}
    }

	private void heapify(int[] A, int i) {
		int maxChildIndex = getMaxChildIndex(A,i);
		if( maxChildIndex!=-1 && A[i]<A[maxChildIndex] ) {
			swap(A, i, maxChildIndex);
			heapify(A, maxChildIndex);
		}
	}

	private int getMaxChildIndex(int i) {
		return 0;
	}

	private void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

}