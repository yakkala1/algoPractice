import java.util.Arrays;

public class Solution {
	
    private int[] nums,sums;
    private int[][] mem;
    private int n;

	public boolean PredictTheWinner(int[] nums) {
    	this.nums = nums;
    	this.n = nums.length;
    	this.sums = getSumArrays();
    	log(Arrays.toString(nums));
    	log(Arrays.toString(sums));
    	mem = initializeMem();
    	int p1Score = getScore(0,n-1);
    	int p2Score = getSum(0,n-1) - p1Score;
    	logMem();
    	return (p1Score>=p2Score);
    }

	private void logMem() {
		for(int[] row : mem)
			log( Arrays.toString(row) );
	}

	private void log(String obj) {
		System.out.println(obj);
	}

	private int[][] initializeMem() {
		int[][] ret = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				ret[i][j] = -1;
			}
		}
		return ret;
	}

	private int getScore(int i, int j) {
		if( mem[i][j] == -1 )
			mem[i][j] = calculate(i,j);
		return mem[i][j];
	}

	private int calculate(int i, int j) {
		if(i==j)
			return nums[i];
		else {
			int sum = getSum(i,j);
			return Math.max(
					sum - getScore(i+1,j),
					sum - getScore(i,j-1)
					);
		}
	}

	private int getSum(int i, int j) {
		return sums[j+1]-sums[i];
	}

	private int[] getSumArrays() {
		int[] ret = new int[n+1];
		ret[0] = 0;
		for(int i=1; i<=n; i++) {
			ret[i] = ret[i-1] + nums[i-1];
		}
		return ret;
	}

}
