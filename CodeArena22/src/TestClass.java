import java.util.Scanner;

public class TestClass {
	
	private static final long MOD = 1000000007l;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0; i<T; i++) {
			System.out.println( solve(sc.nextInt(),sc.nextInt()) );
		}
	}

	private static int solve(int N, int P) {
		int ret = power(2,N-1);
		if(N-1-P == 0) {
			return ret-1;
		} else if(N-1-P < 0) {
			return ret;
		} else {
			int t1 = power(2,N-1-P);
			int t2 = power(2,N-P-2);
			t2 = multiply(t2,N-1-P);
			return ret-t1-t2;
		}
	}

	private static int power(int b, int p) {
		if(p==0)
			return 1;
		if(p==1)
			return b;
		else if(p%2==1) {
			int temp = power(b,p-1);
			temp = multiply(temp,b);
			return temp;
		} else {
			int temp = power(b,p/2);
			return multiply(temp,temp);
		}
	}

	private static int multiply(int a, int b) {
		long ret = (long)a*(long)b;
		ret = ret%MOD;
		return (int)ret;
	}
	
}
