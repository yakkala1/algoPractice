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
	private static int[] mem = new int[1000000 + 1];
	
	public static void main(String[] args) {
		initmem();
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0; t<T; t++) {
			int a = sc.nextInt();
			System.out.println( solve(a) );
		}
	}

	private static void initmem() {
		mem[0] = 1;
		for(int i=1; i<mem.length; i++) {
			long ret = ((long)mem[i-1])*(long)i;
			ret = ret%MOD;
			mem[i] = (int)ret;
		}
	}

	private static int solve(int a) {
		int c = mem[a];
		int ret = ( 2*(c-1) )%MOD;
		ret = (ret+(c-1)) % MOD;
		ret = (ret+6) % MOD;
		return ret;
	}

}
