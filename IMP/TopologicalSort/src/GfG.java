import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class GfG {
	
    public static int[] topoSort(ArrayList<Integer>[] graph, int N)
    {
    	log("N : "+N);
    	log("graph size : "+graph.length);
    	Set<Integer> nodesWithNoEdges = getNodesWithNoEdges(graph,N);
    	Stack<Integer> stack = new Stack<Integer>();
    	Set<Integer> visited = new HashSet<Integer>();
    	for(int node : nodesWithNoEdges) {
    		process(node, graph, N, stack, visited);
    	}
    	log("stack size : "+stack.size());
    	log("stack : "+stack);
    	int[] ret = new int[N];
    	int index = 0;
    	while(!stack.empty()) {
    		ret[index++] = stack.pop();
    	}
    	return ret;
    }

	private static Set<Integer> getNodesWithNoEdges(ArrayList<Integer>[] graph, int N) {
		Set<Integer> ret = new HashSet<Integer>();
		for(int i=0; i<N; i++) {
			ret.add(i);
		}
		for(int i=0; i<N; i++) {
			for(int node:graph[i]) {
				ret.remove(node);
			}
		}
		return ret;
	}

	private static void process(int node, ArrayList<Integer>[] graph, int N, Stack<Integer> stack, Set<Integer> visited) {
		visited.add(node);
		for(int child:graph[node]) {
			if(!visited.contains(child))
				process(child, graph, N, stack, visited);
		}
		stack.push(node);
	}

	public static void log(Object obj) {
		//System.out.println(obj);
	}
	
}