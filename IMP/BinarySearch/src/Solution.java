
public class Solution {

	public int search1(int[] A, int a) {
        int low = 0;
        int high = A.length-1;
        while(low>=high) {
            int mid = low+(high-low)/2;
            if( A[mid]==a ) 
                return mid;
            else if( A[mid]>a ) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }

































	
	public int search1(int[] A, int a) {
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
