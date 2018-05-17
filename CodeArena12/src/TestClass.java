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
	static int[] mem = new int[10000+1];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		initialize();
		print(mem);
		for(int t=0; t<T; t++) {
			int N = sc.nextInt();
			System.out.println( mem[N] );
		}
	}

	private static void print(int[] mem2) {
		for(int i=0; i<mem2.length; i++) {
			log(i+" : "+mem2[i]);
		}
	}

	private static void log(Object obj) {
		System.out.println(obj);
	}

	private static void initialize() {
		markPrimes();
		for(int i=2; i<mem.length; i++) {
			if( i<=5 && mem[i]==1 ) {
				int pow = power(i,i);
				mem[pow] = 1;
			}
		}
		
		for(int i=2; i<mem.length; i++) {
			for(int j=2; i+j<mem.length; j++) {
				int sum = i+j;
				log("");
				log("i : "+i);
				log("j : "+j);
				log("sum : "+sum);
				log("memsum : "+mem[sum]);
				log("memi : "+mem[i]);
				log("memj : "+mem[j]);
				if( mem[sum]==0 ) {
					mem[sum] = mem[i]+mem[j];
				} else {
					mem[sum] = Math.min(mem[i]+mem[j], mem[sum]);
				}
				log("memsum : "+mem[sum]);
			}
		}
	}

	private static int power(int i, int j) {
		if(j==1)
			return i;
		else if(j==0)
			return 1;
		else if(j==2)
			return i*i;
		else {
			if(j%2 == 1) {
				int tmp = power(i, j-1);
				return tmp*i;
			} else {
				int tmp = power(i, j/2);
				return power(tmp, 2);
			}
		}
	}

	private static void markPrimes() {
		for(int i=0; i<mem.length; i++) {
			mem[i] = 1;
		}
		
		for(int i=2; i<mem.length; i++) {
			if(mem[i]==1)
				markMultiples(i);
		}
	}

	private static void markMultiples(int i) {
		for(int j=2; j*i<mem.length; j++) {
			mem[i*j] = 0;
		}
	}

}
