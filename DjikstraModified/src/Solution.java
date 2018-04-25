import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        if(src == dst)
        	return 0;
        
        Map<Integer,List<Edge>> edges = initializeEdges(flights);
        Map<Integer,Integer> distances = initializeDistances();
        PriorityQueue<Tentative> heap = new PriorityQueue<Tentative>();
        
        heap.add(new Tentative(src, 0, 0));
        
        while(true) {
        	if(heap.isEmpty())
        		break;
        	
        	Tentative cur = heap.poll();
        	distances.put( cur.node , Math.min(cur.cost,distances.get(cur.node)) );
        	if(cur.stops>=k)
        		break;
        	for(Edge e : edges.get(cur.node)) {
        		if(distances.get(e.to) < cur.cost+e.cost) {
        			Tentative tentative = new Tentative(
        					e.to, cur.cost+e.cost, cur.stops+1);
        			heap.add(tentative);
        		}
        	}
        }
    }

}

class Edge {
    public int from,to,cost;
    public Edge(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}

class Tentative implements Comparable<Tentative> {
	public static int k;
    public int node,cost,stops;
    public Tentative(int to, int cost, int stops) {
        this.node = to;
        this.cost = cost;
        this.stops = stops;
    }
	@Override
	public int compareTo(Tentative other) {
		if(this.stops>k && other.stops<=k) {
			return -1;
		} else if(this.stops<=k && other.stops>k) {
			return 1;
		} else {
			return Integer.compare(this.cost, other.cost);
		}
	}
}
