import java.util.Arrays;

public class Solution {
	int[][] mem;
	String s1,s2;
	
    public int minimumDeleteSum(String s1, String s2) {
    	log("s1 : "+s1);
    	log("s2 : "+s2);
    	this.s1 = s1;
    	this.s2 = s2;
    	int n1 = s1.length();
    	int n2 = s2.length();
    	mem = new int[n1+1][n2+1];
    	
    	mem[0][0] = 0;
    	for(int i=1; i<=n1; i++) {
    		mem[i][0] = mem[i-1][0]+ascii(s1.charAt(i-1)); 
    	}
    	for(int i=1; i<=n2; i++) {
    		mem[0][i] = mem[0][i-1]+ascii(s2.charAt(i-1));
    	}
    	logMem();
    	
    	for(int i=1; i<=n1; i++) {
    		for(int j=1; j<=n2; j++) {
    			mem[i][j] = calculate(i,j);
    		}
    	}
    	logMem();
	
    	return mem[n1][n2];
    }

	private void logMem() {
		for(int[] row : mem) 
			log( Arrays.toString(row) );
	}

	private void log(Object obj) {
		System.out.println(obj);
	}

	private int calculate(int i1, int i2) {
		log("-----------------------------------------");
		log("calculate : "+i1+","+i2);
		char c1 = s1.charAt(i1-1);
		char c2 = s2.charAt(i2-1);
		log("c1 : "+c1);
		log("c2 : "+c2);
		if( c1 == c2 )
			return mem[i1-1][i2-1];
		else {
			return Math.min(
					(int)c1 + mem[i1-1][i2],
					(int)c2 + mem[i1][i2-1]
					);
		}
	}

	private int ascii(char c) {
		return (int)c;
	}

}
