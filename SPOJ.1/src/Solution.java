import java.util.*;
import java.lang.*;

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		while(true) {
			int N = sc.nextInt();
			int B = sc.nextInt();
			if(N==-1 && B==-1)
				break;
			int[] pop = new int[N];
			for(int i=0; i<N; i++)
				pop[i] = sc.nextInt();
			int ret = solve(N,B,pop);
			System.out.println(ret);
		}
	}

	private static int solve(int N, int B, int[] pop) {
		if(N==0)
			return 0;
		log("N:"+N+"; B:"+B);
		PriorityQueue<Node> heap = new PriorityQueue<Node>();
		int rem = B;
		for(int p : pop) {
			Node node = new Node(p,1);
			rem--;
			heap.add(node);
		}
		while(rem>0) {
			Node n = heap.poll();
			n.nBallots = n.nBallots+1;
			rem--;
			heap.add(n);
		}
		int ret = heap.peek().population/heap.peek().nBallots;
		if(heap.peek().population%heap.peek().nBallots != 0)
			ret++;
		return ret;
	}
	
	public static  void log(Object obj) {
		System.out.println(obj);
	}
	
	static class Node implements Comparable<Node> {
		public int population,nBallots;
		public Node(int pop, int n) {
			this.population = pop;
			this.nBallots = n;
		}
		
		@Override
		public int compareTo(Node o) {
			long thisPop = population;
			long thisN = nBallots;
			long oPop = o.population;
			long oN = o.nBallots;
			return -Long.compare(
					thisPop*oN,
					oPop*thisN
					);
		}
	}
	
}
