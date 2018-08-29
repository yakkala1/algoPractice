import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
	int[][] mem;
	private String[] wordlist;
	
    public void findSecretWord(String[] wordlist, Master master) {
    	this.wordlist = wordlist;
    	int n = wordlist.length;
        mem = new int[n][n];
        for(int i=0; i<n; i++) {
        	for(int j=0; j<n; j++) {
        		mem[i][j] = matches(i,j);
        	}
        }
        
        LinkedList<Integer> possibles = new LinkedList<Integer>();
        for(int i=0; i<n; i++)
        	possibles.add(i);
        
        while( !possibles.isEmpty() ) {
        	int i=possibles.pop();
        	String str = wordlist[i];
        	int matches = master.guess(str);
        	LinkedList<Integer> newPossibles = new LinkedList<Integer>();
        	for(int j : possibles) {
        		if( mem[i][j] == matches )
        			newPossibles.add(j);
        	}
        	possibles = newPossibles;
        }
    }

	int matches(int i, int j) {
		char[] str1 = wordlist[i].toCharArray();
		char[] str2 = wordlist[j].toCharArray();
		Arrays.sort(str1);
		Arrays.sort(str2);
		int i1=0;
		int i2=0;
		int matches = 0;
		while(i1<str1.length && i2<str2.length) {
			if( str1[i1]==str2[i2] ) {
				matches++;
				i1++;
				i2++;
			} else if( str1[i1]<str2[i2] )
				i1++;
			else
				i2++;
		}
		return matches;
	}
    
}
