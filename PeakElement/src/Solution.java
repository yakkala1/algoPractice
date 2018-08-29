import java.util.Arrays;

public class Solution {
	
    private int[] nums;

	public int findPeakElement(int[] nums) {
		log("nums : "+Arrays.toString(nums));
    	this.nums = nums;
    	int low = 0;
    	int n = nums.length;
		int high = n-1;
		while(low<=high) {
			int mid = low+(high-low)/2;
			log("{"+low+","+high+"}");
			log("mid : "+mid);
			if( isPeak(mid) )
				return mid;
			else if( mid+1<n && nums[mid+1]>nums[mid] )
				low = mid+1;
			else if( mid-1>=0 && nums[mid-1]>nums[mid] )
				high = mid-1;
			else
				throw new RuntimeException();
		}
		throw new RuntimeException();
    }

	private boolean isPeak(int i) {
		int n = nums.length;
		if( n==1 )
			return true;
		else if( i==0 && nums[0]>nums[1] )
			return true;
		else if( i==0 )
			return false;
		else if( i==n-1 && nums[n-1]>nums[n-2] )
			return true;
		else if( i==n-1 )
			return false;
		else {
			if( nums[i]>nums[i-1] && nums[i]>nums[i+1] )
				return true;
			else 
				return false;
		}
	}

	private void log(Object obj) {
		System.out.println(obj);
	}
    
}
