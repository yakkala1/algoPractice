import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
	boolean[] ret;
	Integer[] parents;
	Integer[] dist;
	Integer[] low;
	int[] nChildren;
	boolean[] visited;
	Graph G;
	int N;
	int time = 0;
	
	public boolean[] articulationPoints(Graph G) {
		initializeFields(G);
		Logger.log("ret : "+Arrays.toString(ret));
		Logger.log("parents : "+Arrays.toString(parents));
		Logger.log("dist : "+Arrays.toString(dist));
		Logger.log("low : "+Arrays.toString(low));
		Logger.log("nChildren : "+Arrays.toString(nChildren));
		Logger.log("visited : "+Arrays.toString(visited));
		if(N==0)
			return ret;
		else {
			for(int i=0; i<N; i++) {
				if( !visited[i] ) {
					dfs(i,-1);
				}
			}
		}
		Logger.log("ret : "+Arrays.toString(ret));
		Logger.log("parents : "+Arrays.toString(parents));
		Logger.log("dist : "+Arrays.toString(dist));
		Logger.log("low : "+Arrays.toString(low));
		Logger.log("nChildren : "+Arrays.toString(nChildren));
		Logger.log("visited : "+Arrays.toString(visited));
		checkRootNodeCondition();
		checkLowPointCondition();
		return ret;
	}

	private void initializeFields(Graph G) {
		this.G = G;
		N = G.nNodes();
		ret = new boolean[N];
		parents = new Integer[N];
		dist = new Integer[N];
		low = new Integer[N];
		nChildren = new int[N];
		visited = new boolean[N];
		for(int i=0; i<N; i++) {
			ret[i] = false;
			parents[i] = null;
			dist[i] = Integer.MAX_VALUE;
			low[i] = Integer.MAX_VALUE;
			nChildren[i] = 0;
			visited[i] = false;
		}
	}

	private void checkRootNodeCondition() {
		for(int i=0; i<N; i++) {
			if(parents[i]==null && nChildren[i]>=2) {
				ret[i] = true;
			}
		}
	}

	private void checkLowPointCondition() {
		for(int i=0; i<N; i++) {
			Integer parent = parents[i];
			Integer child = i;
			if(parent!=null && parents[parent]!=null && dist[parent]<=low[child]) {
				ret[parent] = true;
			}
		}
	}

	private void dfs(int node, int parent) {
		visited[node] = true;
		dist[node] = time++;
		low[node] = dist[node];
		List<Integer> children = G.getConnectedNodes(node);
		for(int child : children) {
			if(child==parent)
				continue;
			if( !visited[child] ) {
				parents[child] = node;
				dfs(child,node);
				nChildren[node] = nChildren[node]+1;
			} 
			low[node] = Math.min(low[node], low[child]);
		}
	}
	
}

class Graph {
	int N;
	List<List<Integer>> edges = new ArrayList<List<Integer>>();
	public Graph(int N) {
		this.N = N;
		for(int i=0; i<N; i++) {
			edges.add( new ArrayList<Integer>() );
		}
	}
	public void addEdge(int node1, int node2) {
		this.edges.get(node1).add(node2);
		this.edges.get(node2).add(node1);
	}
	public int nNodes() {
		return N;
	}
	public List<Integer> getConnectedNodes(int node) {
		return edges.get(node);
	}
}