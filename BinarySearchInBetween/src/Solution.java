public class Solution {

	public int solve(int[] arr, int find) {
		int n = arr.length;
		int firstElement = arr[0];
		int lastElement = arr[ n-1 ];
		if( find < firstElement )
			return -1;
		if( find >= lastElement )
			return n-1;
		int low = 0;
		int high = n-1;
		while( true ) {
			int mid = low + (high-low)/2;
			if( mid+1>=n ) {
				return n-1;
			} else if( find>=arr[mid+1] ) {
				low = mid+1;
			} else if( find>=arr[mid] && find<arr[mid+1] ) {
				return mid;
			} else {
				high = mid-1;
			}
		}
	}

}