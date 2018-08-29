import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
	
    public void nextPermutation(int[] nums) {
        int i = findIncDecPattern(nums);
        if(i==-1) {
        	Arrays.sort(nums);
        	return;
        } else {
        	int newI = findNextGreaterIn( nums, nums[i], i+1, nums.length-1 );
        	List<Integer> remaining = new ArrayList<Integer>();
        	remaining.add( nums[i] );
        	for(int k=i+1; k<nums.length; k++) {
        		if( k!=newI ) {
        			remaining.add(nums[k]);
        		}
        	}
        	Collections.sort( remaining );
        	nums[i] = nums[newI];
        	for(int k=0; k<remaining.size(); k++) {
        		nums[i+1+k] = remaining.get(k);
        	}
        }
    }

	private int findNextGreaterIn(int[] nums, int val, int from, int to) {
		for(int i=to; i>=from; i--) {
			if( nums[i]>val )
				return i;
		}
		throw new RuntimeException();
	}

	private int findIncDecPattern(int[] nums) {
		for(int i=nums.length-2; i>=0; i--) {
			if( nums[i]<nums[i+1] )
				return i;
		}
		return -1;
	}

}
