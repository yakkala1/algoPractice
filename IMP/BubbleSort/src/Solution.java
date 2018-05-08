public class Solution {

	public int[] sort(int[] is) {
		int n = is.length;
		while(true) {
			int nSwaps = bubble(is);
			if(nSwaps == 0)
				break;
		}
		return is;
	}

	private int bubble(int[] is) {
		int n = is.length;
		int nSwaps = 0;
		for(int i=0; i<=n-2; i++) {
			if(is[i] > is[i+1]) {
				nSwaps++;
				swap(is, i, i+1);
			}
		}
		return nSwaps;
	}

	private void swap(final int[] is, int i, int j) {
		int temp = is[i];
		is[i] = is[j];
		is[j] = temp;
	}

}