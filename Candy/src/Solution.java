import java.util.Arrays;

public class Solution {
	enum Type {
		LOCAL_MIN,
		PEAK,
		POSITIVE_SLOPE,
		NEGATIVE_SLOPE
	}

	private int[] ratings;
	private Type[] typeArray;
	private int[] candy;
	private int n;
	
    public int candy(int[] ratings) {
    	this.ratings = ratings;
    	logRatings();
    	this.n = ratings.length;
    	if(n==0)
    		return 0;
    	if(n==1)
    		return 1;
    	
    	computeTypeArray(ratings);
    	logTypeArray();
    	candy = new int[ratings.length];
    	logCandy();
    	markMins();
    	logCandy();
    	markFs();
    	logCandy();
    	markBs();
    	logCandy();
    	markPeaks();
    	logCandy();
    	return sum();
    }

	private void logRatings() {
		System.out.println("ratings : "+Arrays.toString(ratings));
	}

	private void logCandy() {
		System.out.println("candy : "+Arrays.toString(candy));
	}

	private void logTypeArray() {
		System.out.println("typeArr : "+Arrays.toString(typeArray));
	}

	private void computeTypeArray(int[] ratings) {
		typeArray = new Type[ratings.length];
		markFirstElement();
		markLastElement();
		for(int i=1; i<=n-2; i++) {
			int left = ratings[i-1];
			int right = ratings[i+1];
			int cur = ratings[i];
			
			if(left<cur && cur<=right)
				typeArray[i] = Type.POSITIVE_SLOPE;
			if(left>=cur && cur>right)
				typeArray[i] = Type.NEGATIVE_SLOPE;
			if(left>=cur && cur<=right)
				typeArray[i] = Type.LOCAL_MIN;
			if(left<cur && cur>right)
				typeArray[i] = Type.PEAK;
		}
	}

	private void markFirstElement() {
		int first = ratings[0];
		int second = ratings[1];
		if(first>second)
			typeArray[0] = Type.NEGATIVE_SLOPE;
		else
			typeArray[0] = Type.LOCAL_MIN;
	}

	private void markLastElement() {
		int last = ratings[n-1];
		int lastButOne = ratings[n-2];
		if(last>lastButOne)
			typeArray[n-1] = Type.POSITIVE_SLOPE;
		else
			typeArray[n-1] = Type.LOCAL_MIN;
	}

	private void markMins() {
		for(int i=0; i<n; i++) {
			if(typeArray[i] == Type.LOCAL_MIN) {
				candy[i] = 1;
			}
		}
	}

	private void markFs() {
		for(int i=0; i<n; i++) {
			if(typeArray[i] == Type.POSITIVE_SLOPE) {
				int left = candy[i-1];
				candy[i] = left+1;
			}
		}
	}

	private void markBs() {
		for(int i=n-1; i>=0; i--) {
			if(typeArray[i] == Type.NEGATIVE_SLOPE) {
				int right = candy[i+1];
				candy[i] = right+1;
			}
		}
	}

	private void markPeaks() {
		for(int i=0; i<n; i++) {
			if(typeArray[i] == Type.PEAK) {
				int left = candy[i-1];
				int right = candy[i+1];
				candy[i] = Math.max(left+1, right+1);
			}
		}
	}

	private int sum() {
		int sum = 0;
		for(int num : candy)
			sum += num;
		return sum;
	}

}
