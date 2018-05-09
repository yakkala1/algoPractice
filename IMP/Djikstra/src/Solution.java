import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Solution {

    /*
     * Complete the shortestReach function below.
     */
    static int[] shortestReach(int n, int[][] edges, int s) {
    	Graph graph = new Graph(n);
    	graph.process(edges);
    	int[] ret = new int[n+1];
    	for(int i=0; i<=n; i++) {
    		ret[i] = -1;
    	}
    	Logger.log( "ret : "+Arrays.toString(ret) );
    	PriorityQueue<NodeAndDistance> heap = new PriorityQueue<NodeAndDistance>();
    	heap.add( new NodeAndDistance(s, 0) );
    	while(!heap.isEmpty()) {
    		NodeAndDistance cur = heap.poll();
    		if( ret[cur.node]==-1 ) {
    			recordNode(ret, cur);
    			for(Edge edge : graph.getConnectedEdges(cur.node)) {
    				heap.add( new NodeAndDistance(edge.to,cur.distance+edge.weight) );
    			}
    		}
    	}
    	Logger.log( "ret : "+Arrays.toString(ret) );
    	ret = processOutput(ret,s);
    	return ret;
    }

	private static int[] processOutput(int[] op, int src) {
		int[] ret = new int[op.length-1];
		int retIndex = 0;
		for(int opIndex=1; opIndex<op.length; opIndex++) {
			if(opIndex+1 == src) {
			} else {
				ret[retIndex++] = op[opIndex];
			}
		}
		return ret;
	}

	private static void recordNode(int[] ret, NodeAndDistance cur) {
		ret[cur.node] = cur.distance;
	}

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(scanner.nextLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0].trim());

            int m = Integer.parseInt(nm[1].trim());

            int[][] edges = new int[m][3];

            for (int edgesRowItr = 0; edgesRowItr < m; edgesRowItr++) {
                String[] edgesRowItems = scanner.nextLine().split(" ");

                for (int edgesColumnItr = 0; edgesColumnItr < 3; edgesColumnItr++) {
                    int edgesItem = Integer.parseInt(edgesRowItems[edgesColumnItr].trim());
                    edges[edgesRowItr][edgesColumnItr] = edgesItem;
                }
            }

            int s = Integer.parseInt(scanner.nextLine().trim());

            int[] result = shortestReach(n, edges, s);

            for (int resultItr = 0; resultItr < result.length; resultItr++) {
                bufferedWriter.write(String.valueOf(result[resultItr]));

                if (resultItr != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }
}

class Graph {
	int n;
	List<Set<Edge>> edges;
	Graph(int n) {
		this.n = n;
		edges = new ArrayList<Set<Edge>>();
		for(int i=0; i<=n; i++) {
			edges.add(new HashSet<Edge>());
		}
	}
	public void process(int[][] edges2) {
		for(int[] row:edges2) {
			int from = row[0];
			Edge edge = new Edge(row[1],row[2]);
			addEdge(from, edge);
		}
	}
	Set<Edge> getConnectedEdges(int node) {
		return edges.get(node);
	}
	public void addEdge(int node, Edge edge) {
		edges.get(node).add(edge);
	}
}

class Edge {
	public int to,weight;

	public Edge(int to, int weight) {
		this.to = to;
		this.weight = weight;
	}
	
	@Override
	public boolean equals(Object obj) {
		Edge o = (Edge)obj;
		return (this.to==o.to && this.weight==o.weight);
	}
	
}

class NodeAndDistance implements Comparable<NodeAndDistance> {
	public int node,distance;
	public NodeAndDistance(int node, int distance) {
		this.node = node;
		this.distance = distance;
	}
	@Override
	public int compareTo(NodeAndDistance o) {
		return Integer.compare(this.distance, o.distance);
	}
}

class Logger {
	public static void log(Object obj) {
		System.out.println(obj);
	}
}