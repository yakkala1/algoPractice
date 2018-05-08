import java.util.*;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=1; i<=T; i++) {
			solve(sc.nextInt());
			System.out.println();
		}
	}

	private static void solve(int n) {
		boolean[] isPrime = new boolean[n+1];
		for(int i=0; i<isPrime.length; i++) {
			isPrime[i] = true;
		}
		isPrime[0] = false;
		isPrime[1] = false;
		isPrime[2] = true;
		for(int i=2; i*i<n; i++) {
			if(isPrime[i])
				markMultiples(isPrime,i);
		}
		for(int i=0; i<isPrime.length; i++) {
			if(isPrime[i])
				System.out.print(i+" ");
		}
	}

	private static void markMultiples(boolean[] isPrime, int factor) {
		for(int i=2; i*factor<=isPrime.length-1; i++) {
			isPrime[i*factor] = false;
		}
	}

}
