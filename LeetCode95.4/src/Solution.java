import java.util.HashMap;
import java.util.Map;

class Solution {
	Map<Params,Integer> mem = new HashMap<Params,Integer>();
	int n;
	private int[] profit;
	private int[] groups;
	
    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
    	n = profit.length;
    	Map<Params,Integer> memPrev = computeMemMinusOne(G, P);
    	Map<Params,Integer> mem = new HashMap<Params,Integer>();
    	log(memPrev);
    	for(int i=0; i<n; i++) {
    		mem = new HashMap<Params,Integer>();
    		for(int g=-1; g<=G; g++) {
    			for(int p=-1; p<=P; p++) {
    				int gi = group[i];
    				int pi = profit[i];
    				int val = (getVal(memPrev,g,p) + getVal(memPrev,g-gi,p-pi)) % 1_000_000_007;
    				mem.put( new Params(g,p) , val);
    			}
    		}
    		log("");
    		log("i : "+i);
    		log(mem);
    		memPrev = mem;
    	}
        return mem.get( new Params(G,P) );
    }

	private int getVal(Map<Params, Integer> memPrev, int i, int j) {
		i = Math.max(-1, i);
		j = Math.max(-1, j);
		return memPrev.get( new Params(i,j) );
	}

	private Map<Params, Integer> computeMemMinusOne(int G, int P) {
		Map<Params,Integer> memMinusOne = new HashMap<Params,Integer>();
    	for(int g=-1; g<=G; g++) {
    		for(int p=-1; p<=P; p++) {
    			int val;
    			if(g==-1)
    				val = 0;
    			else if(p<=0)
    				val = 1;
    			else
    				val = 0;
    			memMinusOne.put( new Params(g,p) , val);
    		}
    	}
    	return memMinusOne;
	}
	
	private void log(Object obj) {
		System.out.println(obj);
	}
	
	class Params {
		public int G,P;
		public Params(int G, int P) {
			this.G = G;
			this.P = P;
		}
		@Override
		public boolean equals(Object other) {
			Params o = (Params)other;
			return this.G==o.G
					&& this.P==o.P;
		}
		@Override
		public int hashCode() {
			return Integer.hashCode(3*G+17*P);
		}
		@Override 
		public String toString() {
			return String.format("(%d:%d)", G, P);
		}
	}

    
}