import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
	private int[][] matrix;
	Queue<Node> queue;
	HashSet<Integer> visited;
	
	public Solution(int[][] matrix) {
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
