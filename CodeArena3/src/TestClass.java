import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Collections;

public class TestClass {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0; t<T; t++) {
			int N = sc.nextInt();
			List<Integer> A = new ArrayList<Integer>();
			for(int i=0; i<N; i++) {
				A.add( sc.nextInt() );
			}
			Solution sol = new Solution();
			List<Integer> ret = sol.solve(A);
			print(ret);
		    System.out.println();
		}
	}

	private static void print(List<Integer> ret) {
		for(int i:ret) {
			System.out.print(i+" ");
		}
	}
	
	
    static class Solution {
    	public List<Integer> solve(List<Integer> A) {
    		List<Integer> ret = new ArrayList<Integer>();
    		List<Integer> iterator = new LinkedList<Integer>();
    		Set<Integer> added = new HashSet<Integer>();
    		Map<Integer,Integer> counts = new HashMap<Integer,Integer>();
    		for(int i:A) {
    			if( !counts.containsKey(i) ) {
    				counts.put(i,0);
    			}
    			int prevCount = counts.get(i);
    			counts.put(i, prevCount+1);
    		}
    		int maxCount = 0;
    		Set<Integer> keySet = counts.keySet();
			for(int key:keySet) {
    			maxCount = Math.max(maxCount, counts.get(key));
    		}
    		for(int key:keySet) {
    			if( counts.get(key) == maxCount ) {
    				ret.add(key);
    			}
    		}
    		Collections.sort(ret);  
    		Collections.reverse(ret);
	    	return ret;
    	}
    }

}
