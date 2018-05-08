
public class Solution {

	public int[] sort(int[] is) {
		int n = is.length;
		for(int i=n-1; i>=0; i--) {
			int maxIndex = maxIndex(is,0,i);
			swap(is, maxIndex, i);
		}
		return is;
	}

	private void swap(int[] is, int i, int j) {
		int temp = is[i];
		is[i] = is[j];
		is[j] = temp;
	}

	private int maxIndex(int[] is, int from, int to) {
		int maxIndex = from;
		for(int i=from; i<=to; i++) {
			if( is[i]>is[maxIndex] ) {
				maxIndex = i;
			}
		}
		return maxIndex;
	}

}
