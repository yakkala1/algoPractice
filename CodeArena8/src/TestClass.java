import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class TestClass {
	private static int MOD = 1000000007;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<Integer> A = new ArrayList<Integer>();
		for(int i=0; i<N; i++) {
			A.add( sc.nextInt() );
		}
		Collections.sort(A);
		solve(A);
	}

	private static void solve(List<Integer> A) {
		Set<Integer> set = new HashSet<Integer>();
		for(int i:A) {
			set.add(i);
		}
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int a:A) {
			map.put(a, 1);
		}
		for(int a:A) {
			log("a : "+a);
			int nas = 1;
			for(int i:A) {
				log("i : "+i);
				if((long)i*(long)i > (long)a)
					break;
				if(a%i==0 && set.contains(a/i)) {
					int j = a/i;
					Integer vi = map.get(i);
					Integer vj = map.get(j);
					log("vi : "+vi);
					log("vj : "+vj);
					long nps = ((long)(vi%MOD)) * ((long)(vj%MOD));
					nps = nps%MOD;
					if(i!=j)
						nps = (nps+nps)%MOD;
					nas = (nas+(int)nps)%MOD;
				}
			}
			map.put(a, nas);
		}
		int ret = 0;
		for(int i:map.values()) {
			ret = (ret+i)%MOD;
		}
		System.out.println(ret);
	}

	private static void log(Object obj) {
		//System.out.println(obj);
	}

}
