import java.util.*;

class Solution {
	
    public void solution(int[] A) {
    	int n = A.length;
    	sort(A,0,n-1);
    }

	private void sort(int[] A, int from, int to) {
		if(from>=to)
			return;
		int p = partition(A, from, to);
		sort(A, from, p-1);
		sort(A, p+1, to);
	}

	private int partition(int[] A, int from, int to) {
		int pivot = to;
		int i = from;
		while( i<pivot ) {
			if(A[i] < A[pivot]) {
				i++;
			} else {
				swap(A,i,pivot-1);
				swap(A,pivot-1,pivot);
				pivot--;
			}
		}
		return pivot;
	}

	private void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

}