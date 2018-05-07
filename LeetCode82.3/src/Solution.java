import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
	
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Map<Integer,Integer> maxProfitForDifficulty = new HashMap<Integer,Integer>();
        int n = difficulty.length;
        
        for(int i=0; i<n; i++) {
        	int diff = difficulty[i];
        	int prof = profit[i];
        	if(!maxProfitForDifficulty.containsKey(diff)) 
        		maxProfitForDifficulty.put(diff, 0);
        	int maxProf = Math.max(prof, maxProfitForDifficulty.get(diff));
        	maxProfitForDifficulty.put(diff, maxProf);
        }
        
        Arrays.sort(difficulty);
        Arrays.sort(worker);
        
        log(maxProfitForDifficulty);
        log("diff : " + Arrays.toString(difficulty) );
        log("workers : " + Arrays.toString(worker) );
        
        int w = 0;
        int d = 0;
        int ret = 0;
        int maxP = 0;
        for(w=0; w<worker.length; w++) {
        	while(d<difficulty.length && difficulty[d]<=worker[w]) {
        		maxP = Math.max(maxP , maxProfitForDifficulty.get(difficulty[d]) );
        		d++;
        	}
        	ret += maxP;
        }
        
        return ret;
    }
    
    private void log(Object obj) {
    	System.out.println(obj);
    }
    

}