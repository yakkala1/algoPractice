class Solution {
	
    public boolean canJump(int[] nums) {
    	if(nums.length == 0)
    		return true;
        int maxReachableIndex = 0;
        int cur = 0;
        while( cur<=maxReachableIndex && cur<nums.length ) {
        	maxReachableIndex = Math.max( maxReachableIndex , cur+nums[cur] );
        	cur++;
        }
        return maxReachableIndex>=nums.length-1;
    }

}
