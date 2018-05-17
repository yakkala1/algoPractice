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
		for(int i=0; i<T; i++) {
			int h = sc.nextInt();
			int w = sc.nextInt();
			System.out.println( solve(h,w) );
		}
	}

	private static long solve(long h, long w) {
		long nOdd = w/2;
		long nEven = (w-1)/2;
		long rowsOdd = h/4;
		long rowsEven = (h-2)/4;
		long nDiamonds = nOdd*rowsOdd + nEven*rowsEven;
		log("nOdd : "+nOdd);
		log("nEven : "+nEven);
		log("rowsOdd : "+rowsOdd);
		log("rowsEven : "+rowsEven);
		log("nD : "+nDiamonds);
		long ret = (long)h*(long)w - 4l*nDiamonds;
		return ret;
	}

	private static void log(Object string) {
		System.out.println(string);
	}

}

