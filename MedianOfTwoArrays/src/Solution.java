import java.util.Arrays;

public class Solution {
	
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	Logger.log( "nums1 : "+Arrays.toString(nums1) );
    	Logger.log( "nums2 : "+Arrays.toString(nums2) );
        int l1 = nums1.length;
        int l2 = nums2.length;
        if(l1==0)
        	return median(nums2);
        if(l2==0)
        	return median(nums1);
        int total = l1+l2;
        if( total%2 == 1 ) {
        	return midthElement(nums1,nums2);
        } else {
        	return ((double)midPlusOneth(nums1,nums2) + (double)midMinusOneth(nums1,nums2)) / 2;
        }
    }

	private double median(int[] arr) {
		int n = arr.length;
		if( n%2 == 1 )
			return arr[n/2];
		else
			return ((double)arr[n/2-1] + (double)arr[n/2])/2;
	}

	private double midthElement(int[] nums1, int[] nums2) {
		Logger.log("midthElement");
		try {
			return midthInFirst(nums1,nums2);
		} catch (NotFoundException e) {
			Logger.log("midth not found in nums1. Checking in nums2");
			try {
				return midthInFirst(nums2,nums1);
			} catch (NotFoundException e1) {
				e1.printStackTrace();
				return -1;
			}
		}
	}

	private int midPlusOneth(int[] nums1, int[] nums2) {
		Logger.log("midPlusOneth");
		try {
			return midPlusOnethInFirst(nums1,nums2);
		} catch (NotFoundException e) {
			Logger.log("not found in nums1. Checking in nums2");
			try {
				return midPlusOnethInFirst(nums2,nums1);
			} catch (NotFoundException e1) {
				e1.printStackTrace();
				return -1;
			}
		}
	}

	private int midMinusOneth(int[] nums1, int[] nums2) {
		Logger.log("midMinusOneth");
		try {
			return midMinusOnethInFirst(nums1,nums2);
		} catch (NotFoundException e) {
			Logger.log("found in nums1. Checking in nums2");
			try {
				return midMinusOnethInFirst(nums2,nums1);
			} catch (NotFoundException e1) {
				e1.printStackTrace();
				return -1;
			}
		}
	}

	private int midthInFirst(int[] nums1, int[] nums2) throws NotFoundException {
		Logger.log("midthInFirst");
		Logger.log("nums1 : "+Arrays.toString(nums1));
		Logger.log("nums2 : "+Arrays.toString(nums2));
		int n1 = nums1.length;
		int n2 = nums2.length;
		int total = n1+n2;
		int half = total/2;
		int low = 0;
		int high = n1-1;
		Logger.log("half : "+half);
		while( low<=high ) {
			Logger.log("low : "+low);
			Logger.log("high : "+high);
			int mid = low+(high-low)/2;
			Logger.log("mid : "+mid);
			int value = nums1[mid];
			Logger.log("value : "+value);
			int nLess1 = findLesser(nums1,value);
			int nHigher1 = findHigher(nums1,value);
			int nLess2 = findLesser(nums2,value);
			int nHigher2 = findHigher(nums2,value);
			int nLess = nLess1+nLess2;
			int nHigher = nHigher1+nHigher2;
			Logger.log("nL1 : "+nLess1);
			Logger.log("nH1 : "+nHigher1);
			Logger.log("nL2 : "+nLess2);
			Logger.log("nH2 : "+nHigher2);
			Logger.log("nL : "+nLess);
			Logger.log("nH : "+nHigher);
			if( nLess<=half && nHigher<=half ) {
				Logger.log("returning "+value);
				return value;
			} else if( nLess>half ) {
				high = mid-1;
			} else { //nHigher>half
				low = mid+1;
			}
		}
		throw new NotFoundException();
	}

	private int midPlusOnethInFirst(int[] nums1, int[] nums2) throws NotFoundException {
		Logger.log("midPlusOnethInFirst");
		Logger.log("nums1 : "+Arrays.toString(nums1));
		Logger.log("nums2 : "+Arrays.toString(nums2));
		int n1 = nums1.length;
		int n2 = nums2.length;
		int total = n1+n2;
		int half = total/2;
		int reqdLesser = half;
		int reqdHigher = half-1;
		int low = 0;
		int high = n1-1;
		Logger.log("half : "+half);
		while( low<=high ) {
			Logger.log("low : "+low);
			Logger.log("high : "+high);
			int mid = low+(high-low)/2;
			Logger.log("mid : "+mid);
			int value = nums1[mid];
			Logger.log("value : "+value);
			int nLess1 = findLesser(nums1,value);
			int nHigher1 = findHigher(nums1,value);
			int nLess2 = findLesser(nums2,value);
			int nHigher2 = findHigher(nums2,value);
			int nLess = nLess1+nLess2;
			int nHigher = nHigher1+nHigher2;
			Logger.log("nL1 : "+nLess1);
			Logger.log("nH1 : "+nHigher1);
			Logger.log("nL2 : "+nLess2);
			Logger.log("nH2 : "+nHigher2);
			Logger.log("nL : "+nLess);
			Logger.log("nH : "+nHigher);
			if( nLess<=reqdLesser && nHigher<=reqdHigher ) {
				Logger.log("returning "+value);
				return value;
			} else if( nLess>reqdLesser ) {
				high = mid-1;
			} else { //nHigher>reqdHigher
				low = mid+1;
			}
		}
		throw new NotFoundException();
	}

	private int midMinusOnethInFirst(int[] nums1, int[] nums2) throws NotFoundException {
		Logger.log("midMinusOnethInFirst");
		Logger.log("nums1 : "+Arrays.toString(nums1));
		Logger.log("nums2 : "+Arrays.toString(nums2));
		int n1 = nums1.length;
		int n2 = nums2.length;
		int total = n1+n2;
		int half = total/2;
		int reqdLesser = half-1;
		int reqdHigher = half;
		int low = 0;
		int high = n1-1;
		while( low<=high ) {
			Logger.log("low : "+low);
			Logger.log("high : "+high);
			int mid = low+(high-low)/2;
			Logger.log("mid : "+mid);
			int value = nums1[mid];
			Logger.log("value : "+value);
			int nLess1 = findLesser(nums1,value);
			int nHigher1 = findHigher(nums1,value);
			int nLess2 = findLesser(nums2,value);
			int nHigher2 = findHigher(nums2,value);
			int nLess = nLess1+nLess2;
			int nHigher = nHigher1+nHigher2;
			Logger.log("nL1 : "+nLess1);
			Logger.log("nH1 : "+nHigher1);
			Logger.log("nL2 : "+nLess2);
			Logger.log("nH2 : "+nHigher2);
			Logger.log("nL : "+nLess);
			Logger.log("nH : "+nHigher);
			if( nLess<=reqdLesser && nHigher<=reqdHigher ) {
				Logger.log("returning "+value);
				return value;
			} else if( nLess>reqdLesser ) {
				high = mid-1;
			} else { //nHigher>reqdHigher
				low = mid+1;
			}
		}
		throw new NotFoundException();
	}

	private int findLesser(int[] arr, int value) {
		Logger.log("\t findLesser");
		Logger.log(Arrays.toString(arr));
		Logger.log("\t value : "+value);
		int n = arr.length;
		Logger.log("\t n : "+n);
		if( value <= arr[0] )
			return 0;
		if( arr[n-1] < value )
			return n;
		int low = 0;
		int high = n-1;
		while(low<=high) {
			Logger.log("\t low : "+low);
			Logger.log("\t high : "+high);
			int mid = low + (high-low)/2;
			Logger.log("\t mid : "+mid);
			int midValue = arr[mid];
			Logger.log("\t midValue : "+midValue);
			if( value <= midValue ) {
				high = mid-1;
				continue;
			} else if( mid+1 >= n ) {
				Logger.log("\t returning n : "+n);
				return n;
			} else if( arr[mid+1] >= value ) {
				Logger.log("\t returning mid+1 : "+(mid+1));
				return mid+1;
			} else {
				low = mid+1;
			}
		}
		return -1;
	}

	private int findHigher(int[] arr, int value) {
		Logger.log("\t findHigher");
		Logger.log(Arrays.toString(arr));
		Logger.log("\t value : "+value);
		int n = arr.length;
		Logger.log("\t n : "+n);
		if( value < arr[0] )
			return n;
		if( arr[n-1] <= value )
			return 0;
		int low = 0;
		int high = n-1;
		while(low<=high) {
			Logger.log("\t low : "+low);
			Logger.log("\t high : "+high);
			int mid = low + (high-low)/2;
			Logger.log("\t mid : "+mid);
			int midValue = arr[mid];
			Logger.log("\t midValue : "+midValue);
			if( value < midValue ) {
				high = mid-1;
				continue;
			} else if( mid+1 >= n ) {
				Logger.log("\t returing 0");
				return 0;
			} else if( arr[mid+1] > value ) {
				int ret = n-1-mid;
				Logger.log("\t returning n-1-mid : "+ret);
				return ret;
			} else {
				low = mid+1;
				continue;
			}
		}
		return -1;
	}

}

class NotFoundException extends Exception {
}

class Logger {
	public static void log(Object obj) {
		System.out.println(obj);
	}
}