import java.util.HashSet;
import java.util.Set;

public class Solution {
	
    private int[][] grid;

	public int numMagicSquaresInside(int[][] grid) {
    	this.grid = grid;
        int nRows = grid.length;
        if(nRows==0)
        	return 0;
        int nCols = grid[0].length;
        int count = 0;
        for(int i=0; i+2<nRows; i++) {
        	for(int j=0; j+2<nCols; j++) {
        		if( isMagic(grid, i, j) )
        			count++;
        	}
        }
        return count;
    }

	private boolean isMagic(int[][] grid, int i, int j) {
		log( String.format("isMagic i:%d j:%d",i,j) );
		
		Set<Integer> set = new HashSet<Integer>();
		set.add( 1 );
		set.add( 2 );
		set.add( 3 );
		set.add( 4 );
		set.add( 5 );
		set.add( 6 );
		set.add( 7 );
		set.add( 8 );
		set.add( 9 );
		for(int k=0; k<3; k++) {
			for(int l=0; l<3; l++) {
				set.remove( grid[i+k][j+l] );
			}
		}
		if( !set.isEmpty() )
			return false;
		
		int sum = rowSum(i,j);
		for(int k=0; k<3; k++) {
			log(rowSum(i+k,j));
			log(colSum(i,j+k));
			if( rowSum(i+k,j) != sum )
				return false;
			if( colSum(i,j+k) != sum )
				return false;
		}
		int diag1 = grid[i][j] + grid[i+1][j+1] + grid[i+2][j+2];
		int diag2 = grid[i+2][j] + grid[i+1][j+1] + grid[i][j+2];
		log(diag1);
		log(diag2);
		if( diag1!=sum )
			return false;
		if( diag2!=sum )
			return false;
		return true;
	}

	private void log(Object obj) {
		System.out.println(obj);
	}

	private int colSum(int i, int j) {
		return grid[i][j] + grid[i+1][j] + grid[i+2][j];
	}

	private int rowSum(int i, int j) {
		return grid[i][j] + grid[i][j+1] + grid[i][j+2];
	}

}
