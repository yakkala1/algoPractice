import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
	
    private int[][] memory;

	public int minDistance(String word1, String word2) {
        initializeMemory(word1.length(), word2.length());
        return dp(word1, word2);
    }
    
    private void initializeMemory(int size1, int size2) {
		memory = new int[size1+1][size2+1];
		for(int i=0; i<size1+1; i++) {
			for(int j=0; j<size2+1; j++) {
				memory[i][j] = -1;
			}
		}
	}

	public int dp(String word1, String word2) {
		//System.out.println(word1+":"+word2);
		//printMemory();
    	int l1 = word1.length();
    	int l2 = word2.length();
    	if( memory[l1][l2] != -1 )
    		return memory[l1][l2];
    	else {
    		int ans = calculate(word1,word2);
    		memory[l1][l2] = ans;
    		return ans;
    	}
    }
    
    private void printMemory() {
    	System.out.println("memory");
		for(int i=0; i<memory.length; i++) {
			System.out.println(Arrays.toString(memory[i]));
		}
	}

	int calculate(String a, String b) {
    	ArrayList<Integer> possibleSolutions = new ArrayList<Integer>();
    	int l1 = a.length();
    	int l2 = b.length();
    	if(l1==0 && l2==0)
    		return 0;
    	if(l1 != 0) {
    		String a1 = a.substring(0,l1-1);
    		String b1 = b;
    		int ans = dp(a1,b1)+1;
    		possibleSolutions.add(ans);
    	}
    	if(l1!=0 && l2!=0) {
    		String a1 = a.substring(0,l1-1);
    		String b1 = b.substring(0,l2-1);
    		int ans;
    		if(a.charAt(l1-1) == b.charAt(l2-1))
    			ans = dp(a1,b1);
    		else
    			ans = dp(a1,b1)+1;
    		possibleSolutions.add(ans);
    	}
    	if(l2!=0) {
    		String a1 = a;
    		String b1 = b.substring(0,l2-1);
    		int ans = dp(a1,b1)+1;
    		possibleSolutions.add(ans);
    	}
    	return Collections.min(possibleSolutions);
    }
    
}