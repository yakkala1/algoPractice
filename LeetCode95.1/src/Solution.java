class Solution {
    
    int[] sums,piles;
    int[][] mem;
    int n;
    
    public boolean stoneGame(int[] piles) {
        this.piles = piles;
        this.n = piles.length;
        computeSums();
        this.mem = new int[n+1][n+1];
        for(int i=0; i<=n; i++) {
            for(int j=0; j<=n; j++) {
                mem[i][j] = -1;
            }
        }
        int firstScore = score(0,n);
        int secondScore = sums[n] - firstScore;
        return firstScore>secondScore;
    }
    
    private int score(int from, int to) {
        if( mem[from][to]!=-1 )
            return mem[from][to];
        else {
            mem[from][to] = calculate(from,to);
            return mem[from][to];
        }
    }
    
    private int calculate(int from, int to) {
        if( from>=to )
            return 0;
        else {
            int sum = sum(from,to);
            return Math.max( sum-score(from,to-1) , sum-score(from+1,to) );
        }
    }
    
    private int sum(int from, int to) {
        return sums[to]-sums[from];
    }
    
    private void computeSums() {
        sums = new int[n+1];
        int sum = 0;
        for(int i=0; i<n; i++) {
            sums[i] = sum;
            sum += piles[i];
        }
        sums[n] = sum;
    }
    
}