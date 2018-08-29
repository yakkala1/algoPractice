import java.util.*;

class Solution {
	
	public int solution(int[] A) {
		log("A : "+Arrays.toString(A));
		if(A.length == 3)
			return 0;
		else if(A.length == 4)
			return Math.max( 0 , Math.max(A[1],A[2]) );
		ArrayList<Integer> normalized = normalize(A);
		log("normalized : "+normalized);
		if( nPositives(normalized) == 1 ) {
			return Math.max( specialCase(A) , 0 );
		} else {
			return Math.max( 0 , normalCase(normalized) );
		}
	}
	
	private int nPositives(ArrayList<Integer> A) {
		int ret = 0;
		for(int i:A) {
			if(i>=0)
				ret++;
		}
		log("nPositives : "+ret);
		return ret;
	}

	private int specialCase(int[] A) {
		log("specialCase");
		int i = 0;
		while( A[i]<0 ) {
			i++;
		}
		log("positives starting from : "+i);
		int sum = 0;
		int min = A[i];
		while(A[i]>=0) {
			sum += A[i];
			min = Math.min(min, A[i]);
			i++;
		}
		log("sum : "+sum);
		log("min : "+min);
		return sum-min;
	}

	private int normalCase(ArrayList<Integer> normalized) {
		log("normalCase");
		ArrayList<Integer> N2 = N2(normalized);
		return solFromN2(N2);
	}

	private ArrayList<Integer> N2(ArrayList<Integer> A) {
		log("computing N2 for : "+A);
		ArrayList<Integer> N2 = new ArrayList<Integer>();
		int firstPositive = getFirstPositive(A);
		log("firstP : "+firstPositive);
		int lastPositive = getLastPositive(A);
		log("lastP : "+lastPositive);
		for(int i=firstPositive; i<=lastPositive;) {
			int cur = A.get(i);
			log("cur : "+cur);
			if( cur>0 ) {
				N2.add( cur );
				i++;
			} else {
				int sum = 0;
				int min = 0;
				while( A.get(i)<0 ) {
					sum += A.get(i);
					min = Math.min( min , A.get(i) );
					i++;
				}
				N2.add( sum-min );
			}
			log("N2 : "+N2);
		}
		return N2;
	}

	private int getLastPositive(ArrayList<Integer> A) {
		int i = A.size()-1;
		while( A.get(i)<0 ) {
			i--;
		}
		return i;
	}

	private int getFirstPositive(ArrayList<Integer> A) {
		int i = 0;
		while( A.get(i)<0 ) {
			i++;
		}
		return i;
	}

	private int solFromN2(ArrayList<Integer> N2) {
		log("solFromN2 : "+N2);
		int max = 0;
		for(int i=0; i<=N2.size()-3; i+=2) {
			int cur = N2.get(i)+N2.get(i+1)+N2.get(i+2);
			log("i : "+i);
			log("cur : "+cur);
			max = Math.max( cur , max );
		}
		return max;
	}

	private ArrayList<Integer> normalize(int[] A) {
		log("normalizing");
		ArrayList<Integer> normalized = new ArrayList<Integer>();
		int sum = -1;
		for(int i=1; i<=A.length-2; i++) {
			int cur = A[i];
			if( cur<0 ) {
				if(sum != -1)
					normalized.add(sum);
				normalized.add( cur );
				sum = -1;
			} else {
				if(sum == -1)
					sum = 0;
				sum += cur;
			}
		}
		if( sum != -1 )
			normalized.add(sum);
		return normalized;
	}
	
	private void log(Object obj) {
		System.out.println(obj);
	}
	
}