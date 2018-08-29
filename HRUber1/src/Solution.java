import java.io.IOException;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int[] A = new int[n];
    	for(int i=0; i<n; i++) {
    		A[i] = sc.nextInt();
    	}
    	System.out.println( solve(A) );
    	sc.close();
    }

	private static int solve(int[] A) {
		int ret = 0;
		for( int length=1; length<A.length; length++ ) {
			ret += find(A,length);
		}
	}
    
}