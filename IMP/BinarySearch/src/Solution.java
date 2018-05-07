
public class Solution {
	
	public int search(int[] A, int a) {
		int low = 0;
		int high = A.length-1;
		while(low<=high) {
			int mid = low + (high-low)/2;
			int value = A[mid];
			if(value>a) {
				high = mid-1;
			} else if(value<a) {
				low = mid+1;
			} else {
				return mid;
			}
		}
		return -1;
	}

}
