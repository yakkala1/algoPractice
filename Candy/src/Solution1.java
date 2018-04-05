import java.util.Arrays;

public class Solution1 {

    public int candy(int[] ratings) {
    	if(ratings.length == 0)
    		return 0;
    	log("ratings : "+Arrays.toString(ratings));
        int[] temp = computePlusOrMinus(ratings);
    	log("plusOrMinus : "+Arrays.toString(temp));
        temp = computeCummulativeArray(temp);
    	log("cummulative : "+Arrays.toString(temp));
        temp = makeMinimumOne(temp);
    	log("candies : "+Arrays.toString(temp));
        return sum(temp);
    }

	private int[] computePlusOrMinus(int[] ratings) {
		int n = ratings.length;
		int[] ret = new int[n];
		ret[0] = 0;
		for(int i=1; i<n; i++) {
			int cur = ratings[i];
			int prev = ratings[i-1];
			if(cur > prev)
				ret[i] = 1;
			else if(cur < prev)
				ret[i] = -1;
			else
				ret[i] = 0;
		}
		return ret;
	}
	
	private int[] computeCummulativeArray(int[] plusOrMinus) {
		int n = plusOrMinus.length;
		int[] ret = new int[n];
		ret[0] = 0;
		for(int i=1; i<n; i++) {
			int prevScore = ret[i-1];
			switch(plusOrMinus[i]) {
			case 0:
				ret[i] = prevScore;
				break;
			case 1:
				ret[i] = prevScore+1;
				break;
			case -1:
				ret[i] = prevScore-1;
				break;
			default:
				break;
			}
		}
		return ret;
	}

	private int[] makeMinimumOne(int[] arr) {
		int n = arr.length;
		int[] ret = new int[n];
		int toBeAdded = -minimum(arr) + 1;
		for(int i=0; i<n; i++) {
			ret[i] = arr[i] + toBeAdded;
		}
		return ret;
	}

	private int minimum(int[] arr) {
		int min = arr[0];
		for(int i : arr)
			min = Math.min(min, i);
		return min;
	}

	private int sum(int[] arr) {
		int sum = 0;
		for(int i : arr) {
			sum += i;
		}
		return sum;
	}
	
	private void log(Object obj) {
		System.out.println(obj);
	}

}
