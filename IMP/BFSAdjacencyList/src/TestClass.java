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
		Graph graph = new Graph(N);
        for(int i=0; i<M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            graph.addEdge(from, to);
            graph.addEdge(to, from);
        }
        Solution1 sol = new Solution1(graph);
        System.out.println( sol.bfs(1, N) );
	}
}



class Solution1 {
	private Graph graph;
	Queue<Node> queue;
	HashSet<Integer> visited;
	public Solution1(Graph graph) {
		this.graph = graph;
	}
	public int bfs(int src, int dest) {
		queue = new LinkedList<Node>();
		visited = new HashSet<Integer>();
		addNode(src,0);
		while(!queue.isEmpty()) {
			Node parent = queue.poll();
			for(int child : graph.connectedNodes(parent.node)) {
				if(child == dest) {
					return parent.depth+1;
				}
				queue.add( new Node(child,parent.depth+1) );
			}
		}
		return -1;
	}
	private void addNode(int node, int depth) {
		queue.add( new Node(node,depth) );
		visited.add(node);
	}
}

class Node {
	public int node;
	public int depth;
	public Node(int node, int depth) {
		this.node = node;
		this.depth = depth;
	}
}

class Graph {
	int n;
	Map<Integer,List<Integer>> adjacencyList;
	public Graph(int n) {
		this.n = n;
		adjacencyList = new HashMap<Integer,List<Integer>>();
		for(int i=1; i<=n; i++) {
			adjacencyList.put(i, new LinkedList<Integer>());
		}
	}
	public void addEdge(int src, int dest) {
		adjacencyList.get(src).add(dest);
	}
	public List<Integer> connectedNodes(int from) {
		return adjacencyList.get(from);
	}
}
