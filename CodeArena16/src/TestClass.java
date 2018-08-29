import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class TestClass {
	static int[] mem = new int[10000+1];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0; t<T; t++) {
			int N = sc.nextInt();
			List<Integer> A = new ArrayList<Integer>();
			List<Integer> B = new ArrayList<Integer>();
			for(int i=0; i<N; i++) {
				A.add( sc.nextInt() );
			}
			for(int i=0; i<N; i++) {
				B.add( sc.nextInt() );
			}
			System.out.println( solve(A,B,N) );
		}
	}

	private static int solve(List<Integer> A, List<Integer> B, int N) {
		Collections.sort(A);
		Collections.sort(B);
		Collections.reverse(A);
		int ret = 0;
		for(int i=0; i<N; i++) {
			int a = A.get(i);
			int b = B.get(i);
			if(a%b==0 || b%a==0) {
				ret++;
			}
		}
		return ret;
	}

	private static void log(Object string) {
		System.out.println(string);
	}

}

