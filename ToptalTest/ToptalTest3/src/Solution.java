import java.lang.reflect.Array;
import java.util.*;

class Solution {
	Queue<Integer> queue, nextQueue;
	HashSet<Integer> visited;
	
    public int[] solution(int[] T) {
    	int n = T.length;
    	Graph G = new Graph(n);
    	int capital = 0;
    	for(int i=0; i<n; i++) {
    		int p = T[i];
    		if(p==i)
    			capital = i;
    		else 
    			G.addEdge(i, p);
    	}
    	log("G : "+G);
    	int[] ret = new int[n];
    	queue = new LinkedList<Integer>();
    	nextQueue = new LinkedList<Integer>();
    	visited = new HashSet<Integer>();
    	queue.add(capital);
    	visited.add(capital);
    	int depth = 0;
    	ret[depth++] = queue.size();
		while(!queue.isEmpty()) {
			Integer parent = queue.poll();
			log("parent : "+parent);
			LinkedList<Integer> connectedNodes = G.connectedNodes(parent);
			for(int child : connectedNodes) {
				if( !visited.contains(child) ) {
					nextQueue.add(child);
					visited.add(child);
				}
			}
			if( queue.isEmpty() ) {
				queue = nextQueue;
				nextQueue = new LinkedList<Integer>();
				ret[depth++] = queue.size();
			}
			log("q : "+queue);
			log("nq : "+nextQueue);
		}
		log("ret : "+Arrays.toString(ret));
		return ret;
    }
	
	private void log(Object obj) {
		System.out.println(obj);
	}

	static class Node {
		public int node;
		public Node(int node, int depth) {
			this.node = node;
		}
	}

	static class Edge {
		public int from,to;
		public Edge(int from, int to) {
			this.from = from;
			this.to = to;
		}
	}

	static class Graph {
		int n;
		LinkedList<Integer>[] adjacencyListArray;
		public Graph(int n) {
			this.n = n;
			adjacencyListArray = new LinkedList[n];
			for(int i=0; i<n; i++) {
				adjacencyListArray[i] = new LinkedList<Integer>();
			}
		}
		public void addEdge(int src, int dest) {
			adjacencyListArray[src].add(dest);
			adjacencyListArray[dest].add(src);
		}
		public LinkedList<Integer> connectedNodes(int from) {
			return adjacencyListArray[from];
		}
		@Override
		public String toString() {
			return Arrays.toString(adjacencyListArray);
		}
	}
	
}