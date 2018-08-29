import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	int[] A;
	int k;
	int x;

	public List<Integer> findClosestElements(int[] A, int k, int x) {
		this.A = A;
		this.k = k;
		this.x = x;
		int n = A.length;
		if(n==0) {
			List<Integer> ret = new ArrayList<Integer>();
			for(int a : A)
				ret.add(a);
			return ret;
		}
		
		int minFrom = 0;
		int maxFrom = calculateFrom(n-1);
		
		int low = minFrom;
		int high = maxFrom;
		int mid = 0;
		log("A : "+Arrays.toString(A));
		while( low<=high ) {
			mid = low+(high-low)/2;
			int from = mid;
			int to = calculateTo(mid);
			int valueOfMid = maxDistance(mid);
			int valueOfMidPlusOne = maxDistance(mid+1);
			int valueOfMidMinusOne = maxDistance(mid-1);
			log("{low mid high} : "+low+","+mid+","+high);
			log("from : "+from+" : "+A[from]);
			log("to : "+to+" : "+A[to]);
			log("valueOfMid : "+valueOfMid);
			log("valueOfMidPlusOne : "+valueOfMidPlusOne);
			log("valueOfMidMinusOne : "+valueOfMidMinusOne);
			
			if( A[to]<x ) {
				low = mid+1;
			} else if( A[from]>x ) {
				high = mid-1;
			} else {
				if( valueOfMidPlusOne<valueOfMid 
						&& valueOfMid<=valueOfMidMinusOne
						){
					low = mid+1;
				} else if( valueOfMid<valueOfMidMinusOne
						&& valueOfMid<=valueOfMidPlusOne
						) {
					break;
				} else {
					high = mid-1;
				}
			}
		}
		List<Integer> ret = new ArrayList<Integer>();
		for(int i=mid; i<mid+k; i++) {
			ret.add( A[i] );
		}
		log( "ret : "+(ret) );
		return ret;
	}

	private int maxDistance(int from) {
		int to = calculateTo(from);
		if( to>=A.length || from<0)
			return Integer.MAX_VALUE;
		int leftMost = Math.abs( A[from]-x );
		int rightMost = Math.abs( A[to]-x );
		return Math.max(leftMost, rightMost);
	}

	private int calculateFrom(int to) {
		return to-k+1;
	}
	
	private int calculateTo(int from) {
		return from+k-1;
	}

	private void log(Object obj) {
		System.out.println(obj);
	}

}
