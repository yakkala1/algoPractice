/* IMPORTANT: Multiple classes and nested static classes are supported */

//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=0; i<T; i++) {
        	test(sc);
        }
    }

	private static void test(Scanner sc) {
		int N = sc.nextInt();
		int M = sc.nextInt();
        int[][] matrix = new int[N+1][N+1];
        for(int i=0; i<M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            matrix[from][to] = 1;
            matrix[to][from] = 1;
        }
        Solution1 sol = new Solution1(matrix);
        System.out.println( sol.bfs(1, N) );
	}
}



class Solution1 {
	private int[][] matrix;
	Queue<Node> queue;
	HashSet<Integer> visited;
	
	public Solution1(int[][] matrix) {
		this.matrix = matrix;
	}
	
	public int bfs(int src, int dest) {
		queue = new LinkedList<Node>();
		visited = new HashSet<Integer>();
		addNode(src,0);
		while(!queue.isEmpty()) {
			Node parent = queue.poll();
			for(int child : getChildren(parent.node)) {
				if( !visited.contains(child) ) {
					addNode(child, parent.depth+1);
					if(child == dest) {
						return parent.depth+1;
					}
				}
			}
		}
		return -1;
	}
	
	private void addNode(int node, int depth) {
		queue.add( new Node(node,depth) );
		visited.add(node);
	}

	private List<Integer> getChildren(Integer parent) {
		List<Integer> ret = new ArrayList<Integer>();
		int n = matrix.length;
		for(int i=0; i<n; i++) {
			if(matrix[parent][i] == 1)
				ret.add(i);
		}
		return ret;
	}

	static class Node {
		public int node;
		public int depth;
		public Node(int node, int depth) {
			this.node = node;
			this.depth = depth;
		}
	}

}

