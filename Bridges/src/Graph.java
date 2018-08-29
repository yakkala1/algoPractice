// A Java program to find bridges in a given undirected graph
import java.io.*;
import java.util.*;
import java.util.LinkedList;
 
// This class represents a undirected graph using adjacency list
// representation
class Graph
{
    private int V;   // No. of vertices
 
    // Array  of lists for Adjacency List Representation
    private LinkedList<Integer> adj[];
    int time = 0;
    static final int NIL = -1;
 
    // Constructor
    Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }
 
    // Function to add an edge into the graph
    void addEdge(int v, int w)
    {
        adj[v].add(w);  // Add w to v's list.
        adj[w].add(v);    //Add v to w's list
    }
 
	private void bridge() {
		int[] d = new int[V];
		int[] l = new int[V];
		int[] p = new int[V];
		dist = 0;
		dfs(0,d,l);
		for( int i=1; i<=p.length; i++ ) {
			int u = p[i];
			int v = i;
			if( l[i]<u )
				System.out.println( u+"-:w"
						+ ":w"
						+ ":w"
						+ ""+v );
		}
	}
    
	int dist;
    private void dfs(int node, int[] d, int[] l) {
		d[node] = dist;
		l[node] = dist;
		for( int child : adj[node] ) {
			if(  )
		}
	}

	public static void main(String args[])
    {
        // Create graphs given in above diagrams
        System.out.println("Bridges in first graph ");
        Graph g1 = new Graph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        g1.bridge();
        System.out.println();
 
        System.out.println("Bridges in Second graph");
        Graph g2 = new Graph(4);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);
        g2.bridge();
        System.out.println();
 
        System.out.println("Bridges in Third graph ");
        Graph g3 = new Graph(7);
        g3.addEdge(0, 1);
        g3.addEdge(1, 2);
        g3.addEdge(2, 0);
        g3.addEdge(1, 3);
        g3.addEdge(1, 4);
        g3.addEdge(1, 6);
        g3.addEdge(3, 5);
        g3.addEdge(4, 5);
        g3.bridge();
    }

}
// This code is contributed by Aakash Hasija

