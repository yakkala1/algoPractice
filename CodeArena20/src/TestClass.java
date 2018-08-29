import java.util.Arrays;
import java.util.Scanner;

public class TestClass {
	private static final long MOD = 10000007l;
	static long[][] mem;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int R = sc.nextInt();
		System.out.println( solve(N-R,R) );
	}

	private static long solve(int a, int b) {
		mem = new long[a+1][b+1];
		for(int i=0; i<=a; i++) {
			for(int j=0; j<=b; j++) {
				mem[i][j] = -1;
			}
		}
		long ans = dp(a,b);
		printMem();
		return ans;
	}

	private static void printMem() {
		log("mem : ");
		for(int i=0; i<mem.length; i++) {
			log( Arrays.toString(mem[i]) );
		}
	}

	private static void log(Object obj) {
		System.out.println(obj);
	}

	private static long dp(int balls, int places) {
		if(mem[balls][places] == -1)
			mem[balls][places] = calculate(balls,places);
		return mem[balls][places];
	}

	private static long calculate(int balls, int places) {
		if(balls==0)
			return 1;
		else if(balls==1)
			return places;
		else if(places==1)
			return 1;
		else {
			long ret = 0;
			for(int ballsPut=0; ballsPut<=balls; ballsPut++) {
				int ballsRemaining = balls-ballsPut;
				ret += dp(ballsRemaining,places-1);
				ret = ret%MOD;
			}
			return ret;
		}
	}

}
