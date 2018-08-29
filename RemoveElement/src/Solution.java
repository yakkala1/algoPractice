import java.util.ArrayList;
import java.util.List;

class Solution {
	
    public int removeElement(int[] nums, int val) {
    	int n = nums.length;
        int readingPointer = 0;
        int writingPointer = 0;
        for(readingPointer=0; readingPointer<n; readingPointer++) {
        	if( nums[readingPointer]!=val ) {
        		nums[writingPointer++] = nums[readingPointer];
        	}
        }
        return writingPointer;
    }
    
}