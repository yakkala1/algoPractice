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
		int N = sc.nextInt();
		List<Integer> A = new ArrayList<Integer>();
		for(int i=0; i<N; i++) {
			A.add( sc.nextInt() );
		}
		solve(A);
		for(int i=0; i<A.size(); i++) {
			System.out.print( A.get(i)+" " );
		}
		System.out.println();
	}

	private static List<Integer> solve(List<Integer> A) {
		List<NAndIndex> list = new ArrayList<NAndIndex>();
		List<Integer> ans = new ArrayList<Integer>();
		for(int i=0; i<A.size(); i++) {
			list.add( new NAndIndex(A.get(i),i) );
			ans.add(0);
		}
		Collections.sort(list);
		NAndIndex prevSame = list.get( list.size()-1 );
		int prevSameIndex = list.size()-1;
		for(int i=list.size()-1; i>=0; i--) {
			if( list.get(i).a != prevSame.a ) {
				prevSame = list.get(i);
				prevSameIndex = i;
			}
			int diff = (prevSameIndex-list.get(i).index);
			int newValue = list.get(i).a+diff;
			ans.set(list.get(i).index, newValue);
		}
		return ans;
	}
	
	static class NAndIndex implements Comparable<NAndIndex> {
		public int a,index,ans;
		public NAndIndex(int a, int index) {
			this.a = a;
			this.index = index;
		}
		@Override
		public int compareTo(NAndIndex o) {
			return Integer.compare(this.a, o.a);
		}
	}

}
