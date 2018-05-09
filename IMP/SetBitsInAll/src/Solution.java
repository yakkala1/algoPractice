import java.util.Scanner;

public class Solution {
	private static final long POWERS[]
			= new long[]{
					1,
					2,
					4,
					8,
					16,
					32,
					64,
					128,
					256,
					512,
					1024,
					2048,
					4096,
					8192,
					16384,
					32768,
					65536,
					131072,
					262144
			};
	
	private static long twoPower(int n) {
		if(n<=18)
			return POWERS[n];
		else if(n%2 == 0)
			return POWERS[n%2] * POWERS[n%2];
		else
			return twoPower(n-1) * 2;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0; i<T; i++) {
			System.out.println( solve( sc.nextInt() ) );
		}
	}
	
	private static long solve(long n) {
		n++;
		int base = 0;
		long ret = 0;
		while(true) {
			long pow = twoPower(base);
			if(pow > (long)n)
				break;
			ret += n/(2*pow) * pow;
			long rem = (n%(2*pow)) - pow;
			rem = (rem>0) ? rem:0;
			ret += rem;
			base++;
		}
		return ret;
	}
}
