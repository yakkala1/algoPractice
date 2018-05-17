import java.util.Scanner;

public class TestClass {
	private static int MOD = 1000000007;
	static int[] mem = new int[1000001];
	static int[] sumMem = new int[1000001];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		fillMemory();
		fillSumMemory();
		int T = sc.nextInt();
		for(int t=0; t<T; t++) {
			System.out.println( solve(sc.nextInt()) );
		}
	}

    private static int solve(int n) {
    	return sumMem[n];
	}

	private static void fillSumMemory() {
		sumMem[0] = 0;
		int sum = 0;
		for(int i=1; i<sumMem.length; i++) {
			sum = (sum+mem[i])%MOD;
			sumMem[i] = sum;
		}
	}

	private static void fillMemory() {
    	mem[0] = 1;
    	mem[1] = 2;
    	for(int i=2; i<mem.length; i++) {
    		mem[i] = (mem[i-1]+mem[i-2])%MOD;
    	}
	}

}
