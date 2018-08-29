import java.util.ArrayList;
import java.util.Collection;
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
		sc.nextLine();
		for(int t=0; t<T; t++) {
			String aliceS = sc.nextLine();
			String bobS = sc.nextLine();
			switch( solve(aliceS,bobS) ) {
			case "alice":
				System.out.println("You win some.");
				break;
			case "bob":
				System.out.println("You lose some.");
				break;
			default:
				System.out.println("You draw some.");
				break;
			}
		}
	}

	private static String solve(String aliceS, String bobS) {
		Map<Character,Integer> aliceMap = map(aliceS);
		Map<Character,Integer> bobMap = map(bobS);
		cancel(aliceMap, bobMap);
		Collection<Integer> aliceV = aliceMap.values();
		Collection<Integer> bobV = bobMap.values();
		int aliceN = 0;
		int bobN = 0;
		for(int i: aliceV) {
			if(i!=0)
				aliceN++;
		}
		for(int i: bobV) {
			if(i!=0)
				bobN++;
		}
		if( aliceN!=0 && bobN!=0 )
			return "draw";
		else if( bobN==0 )
			return "alice";
		else
			return "bob";
	}

	private static void cancel(Map<Character, Integer> aliceMap, Map<Character, Integer> bobMap) {
		Set<Character> keySet = aliceMap.keySet();
		for( Character c : keySet ) {
			if( bobMap.containsKey(c) ) {
				int nc = Math.min( aliceMap.get(c) , bobMap.get(c) );
				aliceMap.put( c , aliceMap.get(c)-nc );
				bobMap.put( c , bobMap.get(c)-nc );
			}
		}
	}

	private static Map<Character, Integer> map(String aliceS) {
		Map<Character,Integer> ret = new HashMap<Character,Integer>();
		for(char c : aliceS.toCharArray()) {
			if( !ret.containsKey(c) ) {
				ret.put(c, 0);
			}
			ret.put( c,ret.get(c)+1 );
		}
		return ret;
	}

	private static void log(Object string) {
		System.out.println(string);
	}
	
}
