import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

/*
 * https://www.hackerearth.com/practice/algorithms/graphs/minimum-spanning-tree/practice-problems/algorithm/minimum-spanning-tree-5/
 */


public class TestClass {
	
    private static FileOutputStream os;

	public static void main(String args[] ) throws Exception {
    	//os = new FileOutputStream(new File("/tmp/t"));
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int M = sc.nextInt();
    	Graph graph = new Graph(N);
    	for(int i=0; i<M; i++) {
    		graph.addEdge(sc.nextInt(), sc.nextInt(), sc.nextInt());
    	}
    	solve(graph);
    }

	private static void solve(Graph graph) {
		List<Edge> edgesInTree = new LinkedList<Edge>();
		List<Edge> allEdges = graph.getSortedEdges();
		Map<Integer,Integer> parent = initializeParent(graph);
		for(Edge edge:allEdges) {
			int from = edge.from;
			int to = edge.to;
			int weight = edge.weight;
			int fromRoot = getRoot(from, parent);
			int toRoot = getRoot(to, parent);
 			log("\n");
 			log("from : "+from);
 			log("to : "+to);
 			log("fromRoot : "+fromRoot);
 			log("toRoot : "+toRoot);
 			if(fromRoot==-1 && toRoot==-1) {
 				log("case 1");
 				parent.put(from, to);
 				parent.put(to, to);
 				edgesInTree.add(edge);
 			} else if(fromRoot==toRoot) {
 				log("case 2");
 				//discard edge
 			} else if(fromRoot!=-1 && toRoot!=-1 && fromRoot!=toRoot) {
 				log("case 3");
 				parent.put(toRoot, fromRoot);
 				edgesInTree.add(edge);
 			} else if(fromRoot!=-1 && toRoot==-1) {
 				log("case 4");
 				parent.put(to, fromRoot);
 				edgesInTree.add(edge);
 			} else if(toRoot!=-1 && fromRoot==-1) {
 				log("case 5");
 				parent.put(from, toRoot);
 				edgesInTree.add(edge);
 			}
 			if( edgesInTree.size() == graph.nNodes()-1 ) {
 				break;
 			}
		}
		int ret = 0;
		for(Edge edge : edgesInTree) {
			ret += edge.weight;
		}
		System.out.println(ret);
	}

	private static Map<Integer, Integer> initializeParent(Graph graph) {
		Map<Integer,Integer> ret = new HashMap<Integer,Integer>();
		for(int node : graph.getNodes()) {
			ret.put(node, -1);
		}
		return ret;
	}

	private static Integer getRoot(int node, final Map<Integer, Integer> parentMap) {
		int parent = parentMap.get(node);
		if(parent==-1 || parent==node) {
			return parent;
		} else {
			return getRoot(parent, parentMap);
		}
	}

	private static void log(Object obj) {
//		try {
//			String string = obj.toString()+"\n";
//			os.write(string.getBytes());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}



class Graph {
	Map<String,Integer> edges;
	int N;
	public Graph(int N) {
		this.N = N;
		edges = new HashMap<String,Integer>();
	}
	public int nNodes() {
		return N;
	}
	public void addEdge(int node1, int node2, int weight) {
		if(node1==node2)
			return;
		String key = getKey(node1,node2);
		if( !edges.containsKey(key) ) {
			edges.put( key,weight );
		} else {
			int min = Math.min( weight,edges.get(key) );
			edges.put(key, min);
		}
	}
	private String getKey(int node1, int node2) {
		if(node1 > node2) {
			return getKey(node2,node1);
		} else {
			return node1+","+node2;
		}
	}
	public List<Edge> getSortedEdges() {
		List<Edge> ret = new ArrayList<Edge>();
		PriorityQueue<Edge> heap = new PriorityQueue<Edge>();
		for(String key : edges.keySet()) {
			Integer node1 = getNode1(key);
			Integer node2 = getNode2(key);
			Integer weight = edges.get(key);
			heap.add(new Edge(node1,node2,weight));
		}
		while(!heap.isEmpty()) {
			ret.add( heap.poll() );
		}
		return ret;
	}
	private Integer getNode2(String key) {
		String[] nodes = key.split(",");
		return Integer.parseInt(nodes[1]);
	}
	private Integer getNode1(String key) {
		String[] nodes = key.split(",");
		return Integer.parseInt(nodes[0]);
	}
	public Set<Integer> getNodes() {
		Set<Integer> ret = new HashSet<Integer>();
		for(String key : edges.keySet()) {
			int node1 = getNode1(key);
			int node2 = getNode2(key);
			ret.add(node1);
			ret.add(node2);
		}
		return ret;
	}
}

class Edge implements Comparable<Edge> {
	public int from,to,weight;
	public Edge(int from, int to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
	@Override
	public boolean equals(Object obj) {
		Edge other = (Edge)obj;
		return (this.from==other.from && this.to==other.to) 
				|| (this.from==other.to && this.to==other.from);
	}
	@Override
	public int hashCode() {
		return Integer.hashCode(from)+Integer.hashCode(to);
	}
	@Override
	public int compareTo(Edge o) {
		return Integer.compare(this.weight, o.weight);
	}
}