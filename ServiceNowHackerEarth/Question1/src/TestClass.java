import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class TestClass {
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>( Arrays.asList(
				new Integer[]{0,0,0,10,10,10}
				) );
		System.out.println( Solution.findLeastNumberInRange(2, 3, list) );
	}
	
	
	
    public static void main1(String args[] ) throws Exception {
    	Scanner sc = new Scanner(System.in);
    	int T = sc.nextInt();
    	for(int t=0; t<T; t++) {
    		int N = sc.nextInt();
    		int M = sc.nextInt();
    		int K = sc.nextInt();
    		int[] C = new int[N];
    		for(int i=0; i<N; i++) {
    			C[i] = sc.nextInt();
    		}
    		int[] W = new int[M];
    		for(int i=0; i<M; i++) {
    			W[i] = sc.nextInt();
    		}
    		Solution sol = new Solution(N,M,K,C,W);
    		System.out.println( sol.solve() );
    	}
    }
    
}

class Solution {

	private int N,M,K;
	private int[] C,W;

	public Solution(int N, int M, int K, int[] C, int[] W) {
		this.N = N;
		this.M = M;
		this.K = K;
		this.C = C;
		this.W = W;
		log("N : "+N);
		log("M : "+M);
		log("K : "+K);
		log("C : "+Arrays.toString(C));
		log("W : "+Arrays.toString(W));
	}

	public int solve() {
		Map<Integer,Integer> capacityCounts = createdCountMap();
		List<Integer> capacityKeys = getSortedListOfCapacityKeys(capacityCounts);
		log("counts : " + capacityCounts);
		log("capacityKeys : "+capacityKeys);
		Arrays.sort(W);
		log( "W : "+Arrays.toString(W) );
		int ret = 0;
		for(int i=0; i<M; i++) {
			int w = W[i];
			log("w : "+w);
			int boxCapacityKey = findLeastNumberInRange(w-K,w,capacityKeys);
			log("key : "+boxCapacityKey);
			if(boxCapacityKey != -1) {
				ret++;
				removeKey(capacityKeys,capacityCounts,boxCapacityKey);
			}
		}
		return ret;
	}

	private void removeKey(List<Integer> capacityKeys, Map<Integer, Integer> capacityCounts, int boxCapacityKey) {
		capacityCounts.put( boxCapacityKey , capacityCounts.get(boxCapacityKey)-1 );
		if( capacityCounts.get(boxCapacityKey)==0 ) {
			capacityCounts.remove(boxCapacityKey);
			int index = Collections.binarySearch(capacityKeys, boxCapacityKey);
			capacityKeys.remove(index);
		}
	}

	public static int findLeastNumberInRange
	(int from, int to, List<Integer> capacityKeys) 
	{
		if( capacityKeys.size() == 0 )
			return -1;
		int firstCapacity = capacityKeys.get(0);
		int lastCapacity = capacityKeys.get( capacityKeys.size()-1 );
		if( capacityKeys.get(0)>from && capacityKeys.get(0)>to )
			return -1;
		else if( capacityKeys.get(0)>=from && capacityKeys.get(0)<=to )
			return capacityKeys.get(0);
		else if( lastCapacity>from ) {
			int least = bs(from,capacityKeys);
			if( least<=to )
				return least;
			else 
				return -1;
		} else if( lastCapacity==from )
			return lastCapacity;
		else
			return -1;
	}

	private static int bs(int needle, List<Integer> A) {
		log("needle : "+needle);
		int l = 0;
		int h = A.size()-1;
		while(l<=h) {
			int m = l+(h-l)/2;
//			log("m : "+m);
//			log("val : "+A.get(m));
			if(m==A.size()-1) {
				return A.get(m);
			}
			if( A.get(m)==needle )
				return A.get(m);
			else if( A.get(m+1)==needle )
				return A.get(m+1);
			else if( A.get(m)<needle && A.get(m+1)>needle )
				return A.get(m+1);
			else if(A.get(m)<needle && A.get(m+1)<needle)
				l = m+1;
			else
				h = m-1;
		}
		return -1;
	}

	private List<Integer> getSortedListOfCapacityKeys(Map<Integer, Integer> capacityCounts) {
		List<Integer> ret = new ArrayList<Integer>();
		for(int c : capacityCounts.keySet()) {
			ret.add(c);
		}
		Collections.sort(ret);
		return ret;
	}

	private Map<Integer, Integer> createdCountMap() {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int c:C) {
			if( !map.containsKey(c) )
				map.put(c, 0);
			map.put(c , map.get(c)+1);
		}
		return map;
	}
	
	private static void log(Object obj) {
		System.out.println( obj );
	}
	
}