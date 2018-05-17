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
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for(int t=0; t<T; t++) {
			String a = sc.nextLine();
			System.out.println( solve(a) );
		}
	}

	private static int solve(String a) {
		if(a.length() == 0)
			return 0;
		if(a.length() == 1)
			return 1;
		
		int ret = 0;
		List<Boolean> curPal = new ArrayList<Boolean>();
		curPal.add(true);
		List<Boolean> prevPal = curPal;
		ret += sumsqr(curPal);
		for(int i=1; i<a.length(); i++) {
			curPal = new ArrayList<Boolean>();
			for(int j=0; j<i-1; j++) {
				if( a.charAt(j)==a.charAt(i) && prevPal.get(j+1) ) {
					curPal.add( true );
				} else {
					curPal.add( false );
				}
			}
			if( a.charAt(i)==a.charAt(i-1) )
				curPal.add( true );
			else 
				curPal.add(false);
			curPal.add( true );
			
			ret += sumsqr(curPal);
			prevPal = curPal;
		}
		return ret;
	}

	private static int sumsqr(List<Boolean> curPal) {
		int ret = 0;
		for(int i=0; i<curPal.size(); i++) {
			int length = curPal.size()-i;
			if(curPal.get(i)) {
				int sqr = length*length;
				ret += sqr;
			}
		}
		return ret;
	}

}
