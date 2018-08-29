import java.util.Scanner;

public class TestClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int ret = 0;
		for(int i=0; i<N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			if( solvable(a,b,c) ) {
				ret++;
			}
		}
		System.out.println(ret);
	}

	private static boolean solvable(int a, int b, int c) {
		if( (b*b-4*a*c) >= 0 )
			return true;
		else
			return false;
	}
	
}
