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
		Map<Integer,Set<Integer>> setsOfNode = new HashMap<Integer,Set<Integer>>();
		List<Edge> edgesInTree = new LinkedList<Edge>();
		List<Edge> allEdges = graph.getSortedEdges();
		for(Edge edge:allEdges) {
			int from = edge.from;
			int to = edge.to;
			if(from==1351) {
				log("there");
			}
			if(from==to)
				continue;
			int weight = edge.weight;
			Set<Integer> fromSet = setsOfNode.getOrDefault(from, null);
			Set<Integer> toSet = setsOfNode.getOrDefault(to, null);
 			log("\n");
 			log("from : "+from);
 			log("to : "+to);
 			log("fromSet : "+fromSet);
 			log("toSet : "+toSet);
 			if(fromSet==null && toSet==null) {
 				log("case 1");
 				Set<Integer> newSet = new HashSet<Integer>();
 				newSet.add(from);
 				newSet.add(to);
 				edgesInTree.add(edge);
 				setsOfNode.put(from, newSet);
 				setsOfNode.put(to, newSet);
 			} else if(fromSet==toSet) {
 				log("case 2");
 			} else if(fromSet!=null && toSet!=null) {
 				log("case 3");
 				if(from==1351) {
 					log("there");
 				}
 				fromSet.addAll(toSet);
 				for(int i:toSet) {
 					setsOfNode.put(i, fromSet);
 				}
 				edgesInTree.add(edge);
 			} else if(fromSet!=null && toSet==null) {
 				log("case 4");
 				fromSet.add(to);
 				setsOfNode.put(to, fromSet);
 				edgesInTree.add(edge);
 			} else if(toSet!=null && fromSet==null) {
 				log("case 5");
 				toSet.add(from);
 				setsOfNode.put(from, toSet);
 				edgesInTree.add(edge);
 			}
 			int setN = 1;
 			int calcEdges = 0;
// 			for(Set<Integer> set : setsFound) {
// 				log(setN+" : setSize : "+set.size());
// 				setN++;
// 				calcEdges += set.size()-1;
// 			}
 			log("calcEdges : "+calcEdges);
 			log("nEdges : "+edgesInTree.size());
 			log("condition : "+(calcEdges==edgesInTree.size()));
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

	private static Set<Integer> setOfNode(int to) {
		// TODO Auto-generated method stub
		return null;
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

	private static boolean treeFormed(Graph graph, List<Set<Integer>> setsFound, List<Edge> edgesInTree) {
		return setsFound.size()==1 && setsFound.get(0).size()==graph.nNodes();
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