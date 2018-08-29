class Solution {
	
    public int maxArea(int[] height) {
        int max = 0;
        int n = height.length;
        for(int i=1; i<n; i++) {
        	for(int j=0; j<i; j++) {
        		int leftWallHeight = height[i];
        		int rightWallHeight = height[j];
        		int area = Math.min(leftWallHeight, rightWallHeight)*(i-j);
        		max = Math.max(max,area);
        	}
        }
        return max;
    }

}
