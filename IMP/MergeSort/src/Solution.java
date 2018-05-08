public class Solution {

	public int[] sort(int[] is) {
		int n = is.length;
		sort(is,0,n-1);
		return is;
	}

	private void sort(int[] is, int i, int j) {
		if(is.length == 0)
			return;
		log(i+","+j);
		if(i==j)
			return;
		int mid = i+(j-i)/2;
		sort(is,i,mid);
		sort(is,mid+1,j);
		SubArray sub1 = new SubArray(is, i, mid-i+1);
		SubArray sub2 = new SubArray(is, mid+1, j-mid);
		int[] temp = new int[j-i+1];
		int tempIndex = 0;
		int index1 = 0;
		int index2 = 0;
		while(true) {
			if(sub1.isOutBound(index1) && sub2.isOutBound(index2)) {
				break;
			} else if( sub2.isOutBound(index2) ) {
				temp[tempIndex++] = sub1.get(index1++);
			} else if( sub1.isOutBound(index1) ) {
				temp[tempIndex++] = sub2.get(index2++);
			} else if( sub1.get(index1) <= sub2.get(index2) ) {
				temp[tempIndex++] = sub1.get(index1++);
			} else {
				temp[tempIndex++] = sub2.get(index2++);
			}
		}
		for(int a=0; a<temp.length; a++) {
			is[i+a] = temp[a];
		}
	}

	private void log(Object string) {
		System.out.println(string);
	}

}

class SubArray {
	int[] array;
	int offset;
	int length;
	public SubArray(int[] array, int offset, int length) {
		this.array = array;
		this.offset = offset;
		this.length = length;
	}
	public boolean isOutBound(int i) {
		return !isInBound(i);
	}
	public int get(int i) {
		if(i<length) {
			return array[offset+i];
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}
	public boolean isInBound(int i) {
		return (i<length);
	}
	public String toString() {
		String ret = "";
		for(int i=0; i<length; i++) {
			ret += array[offset+i]+",";
		}
		return ret;
	}
}
