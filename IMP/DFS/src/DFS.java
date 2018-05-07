import java.util.*;

public class DFS {
	Graph graph;
	Set<Integer> visited;
	public DFS(Graph graph) {
		this.graph = graph;
	}
	public void startDFS(int src) {
		this.visited = new HashSet<Integer>();
		dfs(src);
	}
	private void dfs(int src) {
		visited.add(src);
		System.out.println(src);
		for(int child : graph.getConnectedNodes()) {
			if( !visited.contains(child) ) {
				dfs(child);
			}
		}
	}
}

class Graph {
	//TODO
	public List<Integer> getConnectedNodes() {
		//TODO
		return null;
	}
}