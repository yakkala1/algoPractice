import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	private Graph graph;
	Queue<Node> queue;
	HashSet<Integer> visited;
		
	public int bfs(Graph graph, int src, int dest) {
		this.graph = graph;
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

	static class Node {
		public int node;
		public int depth;
		public Node(int node, int depth) {
			this.node = node;
			this.depth = depth;
		}
	}

	static class Edge {
		public int to;
		public int weight;
		public Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}
	
	static class Graph {
		int n;
		LinkedList<Integer>[] adjacencyListArray;
		public Graph(int n) {
			this.n = n;
			adjacencyListArray = new LinkedList[n];
		}
		public void addEdge(int src, int dest) {
			adjacencyListArray[src].add(dest);
		}
		public LinkedList<Integer> connectedNodes(int from) {
			return adjacencyListArray[from];
		}
	}
	
}
