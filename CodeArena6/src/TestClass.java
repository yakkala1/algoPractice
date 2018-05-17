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
		int n = sc.nextInt();
		List<Integer> A = new ArrayList<Integer>();
		for(int i=0; i<n; i++) {
			A.add( sc.nextInt() );
		}
		int ret = Solution.solve(A);
		if(ret > 0) 
			System.out.println(ret);
		else
			System.out.println(":(");
	}

    static class Solution {
    	
		public static int solve(List<Integer> a) {
			int sum = 0;
			int leastOdd = Integer.MAX_VALUE;
			for( int i:a ) {
				sum += i;
				if( i%2 == 1 ) {
					leastOdd = Math.min(leastOdd, i);
				}
			}
			if(sum%2 == 1)
				return sum;
			else if(leastOdd != Integer.MAX_VALUE)
				return sum-leastOdd;
			else 
				return 0;
		}

    }

}
