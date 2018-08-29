import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if(dst==src)
            return 0;
        
        Map<Integer,List<Edge>> edgesOfNodes = new HashMap<Integer,List<Edge>>();
        for(int i=0; i<n; i++) {
        	edgesOfNodes.put(i , new ArrayList<Edge>());
        }
//        for(int[] flight : flights) {
 //           Edge edge = new Edge(flight);
  //      }
        
        int[] totalCost = new int[n];
        for(int i=0; i<n; i++) {
            totalCost[i] = Integer.MAX_VALUE;
        }
        // Set<Integer> unvisited = new HashSet<Integer>();
        // for(int i=0; i<n; i++) {
        //     unvisited.add(i);
        // }
        PriorityQueue<TentativeDistance> heap = new PriorityQueue<TentativeDistance>();
        totalCost[src] = 0;
        heap.add(new TentativeDistance(src,0,0));
        // unvisted.remove(src);
        
        while(true) {
            if(heap.isEmpty())
                return -1;
            TentativeDistance cur = heap.poll();
            if(cur.stops >= K)
            	continue;
            for(Edge edge : edgesOfNodes.get(cur.node)) {
                if(edge.to == dst)
                    return edge.cost+cur.cost;
                if( totalCost[cur.node]+edge.cost < totalCost[edge.to] )
                    heap.add(new TentativeDistance(edge.to,edge.cost,cur.stops+1));
            }
        }
        
    }
    
}

class Edge {
    public int from;
    public int to;
    public int cost;
    
    public Edge(int[] flight) {
        this.from = flight[0];
        this.to = flight[1];
        this.cost = flight[2];
    }
}

class TentativeDistance implements Comparable<TentativeDistance> {
    public int node;
    public int cost;
    public int stops;
    
    public TentativeDistance(int node, int cost, int stops) {
        this.node = node;
        this.cost = cost;
        this.stops = stops;
    }
    
    public int compareTo(TentativeDistance other) {
    	return Integer.compare(this.cost,other.cost);
    }
}
