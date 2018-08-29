class Solution {
	int nRows,nCols;
	
    public boolean searchMatrix(int[][] matrix, int target) {
    	nRows = matrix.length;
    	if(nRows==0)
    		return false;
    	nCols = matrix[0].length;
        int low = 0;
        int high = nRows*nCols-1;
        while(low<=high) {
        	log("low : "+low);
        	log("high : "+high);
        	int mid = low + (high-low)/2;
        	log("mid : "+mid);
        	int midValue = get(mid,matrix);
        	log("midValue : "+midValue);
        	if( midValue<target ) {
        		low = mid+1;
        	} else if( midValue>target ) {
        		high = mid-1;
        	} else {
        		return true;
        	}
        }
        return false;
    }
    
    private void log(Object obj) {
		System.out.println(obj);
	}

	private MatrixIndex getMatIndex(int pos) {
    	int i = pos/nCols;
    	int j = pos%nCols;
    	return new MatrixIndex(i, j);
    }
    
    private int getIndex(MatrixIndex matIndex) {
    	return matIndex.i*nRows + matIndex.j;
    }
    
    private int get(int pos, int[][] matrix) {
    	MatrixIndex matIndex = getMatIndex(pos);
    	return matrix[matIndex.i][matIndex.j];
    }
    
    class MatrixIndex {
    	public int i,j;
    	public MatrixIndex(int i, int j) {
    		this.i = i;
    		this.j = j;
    	}
    }
}

