import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class TestClass {
	private static int MOD = 1000000007;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0; t<T; t++) {
			long A = sc.nextLong();
			long B = sc.nextLong();
			Solution sol = new Solution();
			long ans = sol.solve(A,B);
			System.out.println(ans);
		}
	}

	static class Solution {

		public long solve(long A, long B) {
			boolean[] bitsA = bits(A);
			boolean[] bitsB = bits(B);
			int diffMin = diffMin(bitsA,bitsB);
			boolean[] ans = new boolean[18];
			for(int i=17; i>diffMin; i--) {
				ans[i] = bitsB[i];
			}
			bitsB[diffMin] = false;
			for(int i=diffMin-1; i>0; i--) {
				ans[i] = true;
			}
			ans[0] = false;
			return toNum(ans);
		}

		private long toNum(boolean[] ans) {
			long ret = 0;
			for(int i=0; i<ans.length; i++) {
				if(ans[i]) {
					ret += 1l>>i;
				}
			}
			return ret;
		}

		private int diffMin(boolean[] bitsA, boolean[] bitsB) {
			for(int i=bitsA.length-1; i>=0; i--) {
				
			}
		}

		private boolean[] bits(long a) {
			boolean[] ret = new boolean[18];
			for(int i=0; i<18; i++) {
				long mask = 1l<<i;
				long bit = a & mask;
				ret[i] = bit>0 ? true:false;
			}
			return ret;
		}
	
	}

}
