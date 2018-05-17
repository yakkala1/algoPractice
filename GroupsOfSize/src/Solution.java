import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	int min;
	int[][] mem;
	
	public int solve(int N, int K) {
		this.min = K;
		mem = new int[N+1][N+1];
		for(int i=0; i<=N; i++) {
			for(int j=0; j<=N; j++) {
				mem[i][j] = -1;
			}
		}
		List<Integer> soln = new ArrayList<Integer>(){};
		int ret = dp(N,N,soln);
		printMem();
		return ret;
	}

	private void printMem() {
		for(int i=0; i<mem.length; i++) {
			for(int j=0; j<mem[0].length; j++) {
				String str = String.format("%4d;", mem[i][j]);
				System.out.print(str);
			}
			System.out.println();
		}
	}

	private int dp(int N, int limit, List<Integer> soln) {
		if(mem[N][limit] != -1) {
			log("rem : "+N);
			log("soln : "+soln);
			log("limit : "+limit);
			log("mem : "+mem[N][limit]);
			log("");
			return mem[N][limit];
		} else {
			int ans = calculate(N,limit,soln);
			mem[N][limit] = ans;
			log("soln : "+soln);
			log("rem : "+N);
			log("limit : "+limit);
			log("ans : "+ans);
//			printMem();
			log("");
			return ans;
		}
	}

	private void log(Object obj) {
		System.out.println(obj);
	}

	private int calculate(int N, int limit, List<Integer> soln) {
		if( N<min )
			return 0;
		else {
			int ret = 0;
			if(N<=limit)
				ret += 1;
			for(int i=min; i<=limit && i<N; i++) {
				int first = i;
				int remaining = N-i;
				List<Integer> newSoln = new ArrayList<Integer>();
				newSoln.addAll( soln );
				newSoln.add( i );
				ret += dp(remaining,first,newSoln);
			}
//			for(int i=N-1; i>=min; i--) {
//				if(i>limit)
//					continue;
//				int rem = N-i;
//				int newLimit = Math.min(i, limit);
//				List<Integer> newSoln = new ArrayList<Integer>();
//				newSoln.addAll( soln );
//				newSoln.add( i );
//				ret += dp(rem,newLimit,newSoln);
//			}
			return ret;
		}
	}
	
}
