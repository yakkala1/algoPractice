import java.util.*;

class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        int n = quality.length;
        List<Worker> workers = loadWorkers(quality,wage);
        Collections.sort(workers, new Comparator<Worker>() {
        	public int compare(Worker w1, Worker w2) {
        		return Double.compare(w1.wq, w2.wq);
        	}
		});
        log("workers : "+workers);
        PriorityQueue<Worker> heap = new PriorityQueue<Worker>(K,new Comparator<Worker>() {
        	public int compare(Worker w1, Worker w2) {
				return -Integer.compare(w1.quality, w2.quality);
			}
		});
        double cost = 0;
        double wq = workers.get(K-1).wq;
        for(int i=0; i<K; i++) {
        	heap.add( workers.get(i) );
        	cost += workers.get(i).quality*wq;
        	log( heap.peek() );
        }
        log("heap : "+heap);
        log("cost : "+cost);
        double minCost = cost;
        for(int i=K; i<n; i++) {
        	log("");
        	Worker worker = workers.get(i);
        	if( worker.quality < heap.peek().quality ) {
        		double newWq = worker.wq;
        		Worker removingWorker = heap.poll();
        		log("removedWorker : "+removingWorker);
        		heap.add(worker);
        		cost = (cost/wq - removingWorker.quality + worker.quality)*newWq;
        		wq = newWq;
        	}
        	log("heap : "+heap);
        	log("cost : "+cost);
         	minCost = Math.min(minCost, cost);
        }
        return minCost;
    }

	private List<Worker> loadWorkers(int[] quality, int[] wage) {
		List<Worker> workers = new ArrayList<Worker>();
		for(int i=0; i<quality.length; i++) {
			Worker w = new Worker( quality[i],wage[i] );
			workers.add(w);
		}
		return workers;
	}
	
	public void log(Object obj) {
		//System.out.println(obj);
	}
}

class Worker {
	public int quality, wage;
	public double wq;
	public Worker(int quality, int wage) {
		this.quality = quality;
		this.wage = wage;
		this.wq = (double)wage/(double)quality;
	}
	@Override
	public String toString() {
		return String.format("{ wq:%f,q:%d,w:%d }", wq, quality, wage);
	}
}