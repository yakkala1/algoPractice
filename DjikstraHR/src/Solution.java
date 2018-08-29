import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	static Set<Integer> processed = new HashSet<Integer>();
	static Graph G;
	static PriorityQueue<TentDist> heap = new PriorityQueue<TentDist>();
	static int[] shortest;
	static int N;
	
    // Complete the shortestReach function below.
    static int[] shortestReach(int n, int[][] edges, int s) {
    	N = n;
    	G = new Graph(n, edges);
    	shortest = new int[n];
    	process( new TentDist(s,0) );
    	while( processed.size()<n && !heap.isEmpty() ) {
    		TentDist curT = heap.poll();
    		if( processed.contains(curT.node) )
    			continue;
    		process(curT);
    	}
    	return op(s);
    }

    private static int[] op(int s) {
    	int[] op = new int[N-1];
    	int opPointer = 0;
    	for(int i=0; i<N; i++) {
    		if( i!=(s-1) )
    			op[ opPointer++ ]  =  shortest[i];
    	}
    	return op;
	}

	private static void process(TentDist curT) {
    	int node = curT.node;
    	int dist = curT.dist;
    	processed.add( node );
    	setDistance( node,dist );
    	for( Edge edge : G.getEdges(node) ) {
    		int child = edge.to;
    		if( !processed.contains(child) ) {
    			heap.add( new TentDist(child,dist+edge.weight) );
    		}
    	}
	}

	private static void setDistance(int node, int dist) {
		shortest[node-1] = dist;
	}

	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int tItr = 0; tItr < t; tItr++) {
            String[] nm = scanner.nextLine().split(" ");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);
            int[][] edges = new int[m][3];
            for (int i = 0; i < m; i++) {
                String[] edgesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                for (int j = 0; j < 3; j++) {
                    int edgesItem = Integer.parseInt(edgesRowItems[j]);
                    edges[i][j] = edgesItem;
                }
            }
            int s = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            int[] result = shortestReach(n, edges, s);
            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));
                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        scanner.close();
    }
}

class Graph {
	int n;
	List< List<Edge> > edges = new ArrayList< List<Edge> >();
	public Graph(int n, int[][] edges) {
		this.n = n;
		initializeAllEdgeArrays();
		for(int[] edge : edges) {
			addEdge( edge[0], edge[1], edge[2] );
		}
	}
	public List<Edge> getEdges(int i) {
		return edges.get(i);
	}
	private void addEdge(int from, int to, int weight) {
		edges.get(from).add( new Edge(from,to,weight) );
		edges.get(to).add( new Edge(to,from,weight) );
	}
	private void initializeAllEdgeArrays() {
		for(int i=0; i<=n; i++) {
			edges.add( new ArrayList<Edge>() );
		}
	}
}

class Edge {
	int from,to,weight;
	public Edge(int from, int to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
}

class TentDist implements Comparable<TentDist> {
	public int node,dist;
	public TentDist(int node, int dist) {
		this.node = node;
		this.dist = dist;
	}
	@Override
	public int compareTo(TentDist o) {
		return Integer.compare(dist,o.dist);
	}
}