
public class Solution {
	
	public int[] sort(int[] A) {
		maxHeapify(A);
		int n = A.length;
		for(int end=n-1; end>0; end--) {
			swap(A,0,end);
			shiftDown(A,0,end-1,0);
		}
		return A;
	}

	private void maxHeapify(int[] A) {
		int n = A.length;
		for(int to=0; to<n; to++) {
			shiftUp(A,0,to,to);
		}
	}

	private void shiftDown(int[] A, int from, int to, int index) {
		int childIndex = getMaxParentIndex(A, from, to, index);
		if(childIndex==-1 || A[childIndex]<=A[index]) {
			return;
		} else {
			swap(A, index, childIndex);
			shiftDown(A, from, to, childIndex);
		}
	}

	private int getMaxParentIndex(int[] A, int from, int to, int index) {
		int c1 = 2*index+1;
		int c2 = 2*index+2;
		c1 = (c1<=to) ? c1 : -1;
		c2 = (c2<=to) ? c2 : -1;
		if(c1==-1 && c2==-1)
			return -1;
		else if(c1==-1)
			return c2;
		else if(c2==-1)
			return c1;
		else
			return (A[c1]>A[c2]) ? c1:c2;
	}

	private void shiftUp(int[] A, int from, int to, int index) {
		int parentIndex = getParentIndex(index);
		if(parentIndex!=-1 && A[index]>A[parentIndex]) {
			swap(A, index, parentIndex);
			shiftUp(A, from, to, parentIndex);
		}
	}

	private int getParentIndex(int index) {
		if(index==0)
			return -1;
		else
			return (index-1)/2;
	}

	private void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}
