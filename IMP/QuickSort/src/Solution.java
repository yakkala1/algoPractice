
public class Solution {

	public int[] sort(int[] is) {
		quickSort(is, 0, is.length-1);
		return is;
	}

	private void quickSort(int[] is, int from, int to) {
		if(to<=from)
			return;
		int pivot = partition(is, from, to);
		quickSort(is, from, pivot-1);
		quickSort(is, pivot+1, to);
	}

	private int partition(int[] is, int from, int to) {
		int index = from;
		int pivot = to;
		while(index<pivot) {
			if(is[index]>is[pivot]) {
				swap(is,index,pivot-1);
				swap(is,pivot,pivot-1);
				pivot--;
			} else {
				index++;
			}
		}
		return pivot;
	}

	private void swap(int[] is, int i1, int i2) {
		int temp = is[i1];
		is[i1] = is[i2];
		is[i2] = temp;
	}

}
