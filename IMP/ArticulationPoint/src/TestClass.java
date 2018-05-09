/*
 * https://www.hackerearth.com/practice/algorithms/graphs/articulation-points-and-bridges/practice-problems/algorithm/rhezo-and-destructive-mind/
 * */

import java.util.Scanner;

class TestClass {
    public static void main(String args[] ) throws Exception {
    	Scanner sc = new Scanner(System.in);
    	int[] nEdges;
    	int N = sc.nextInt();
    	Logger.log("N : "+N);
    	int M = sc.nextInt();
    	Logger.log("M : "+M);
    	Graph G = new Graph(N);
    	nEdges = new int[N+1];
    	for(int i=0; i<M; i++) {
    		int node1 = sc.nextInt();
    		int node2 = sc.nextInt();
    		nEdges[node1]++;
    		if(node2!=node1)
    			nEdges[node2]++;
    		if(node1==node2)
    			continue;
    		if(!G.getConnectedNodes(node1-1).contains(node2-1))
    			G.addEdge(node1-1, node2-1);
    	}
    	Solution sol = new Solution();
    	boolean[] ret = sol.articulationPoints(G);
    	int Q = sc.nextInt();
    	Logger.log("Q : "+Q);
    	for(int i=0; i<Q; i++) {
    		int q = sc.nextInt();
    		Logger.log("q : "+q);
    		if(ret[q-1]) {
    			System.out.println("Satisfied "+nEdges[q]);
    		} else {
    			System.out.println("Not Satisfied");
    		}
    	}
    }
}