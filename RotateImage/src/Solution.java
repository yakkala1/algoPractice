import java.util.Arrays;

class Solution {
	
    public void rotate(int[][] matrix) {
    	printMatrix(matrix);
        int n = matrix.length;
        for(int i=0; i<=(n-1)/2; i++) {
        	for(int j=i; j<=n-2-i; j++) {
        		log("i : "+i);
        		log("j : "+j);
        		Position pos1 = new Position(i,j);
        		Position pos2 = getRotatedPosition(pos1,n);
        		Position pos3 = getRotatedPosition(pos2,n);
        		Position pos4 = getRotatedPosition(pos3,n);
        		int val1 = getValue(matrix,pos1);
        		int val2 = getValue(matrix,pos2);
        		int val3 = getValue(matrix,pos3);
        		int val4 = getValue(matrix,pos4);
        		setValue(matrix,pos1,val4);
        		setValue(matrix,pos2,val1);
        		setValue(matrix,pos3,val2);
        		setValue(matrix,pos4,val3);
        	}
        }
    	printMatrix(matrix);
    }

	private void printMatrix(int[][] matrix) {
		for(int i=0; i<matrix.length; i++) {
			log( Arrays.toString(matrix[i]) );
		}
	}

	private void log(Object obj) {
		//System.out.println(obj);
	}

	private void setValue(int[][] matrix, Position pos, int val) {
		matrix[pos.i][pos.j] = val;
	}

	private int getValue(int[][] matrix, Position pos) {
		return matrix[pos.i][pos.j];
	}

	private Position getRotatedPosition(Position pos, int n) {
		return new Position(pos.j,n-1-pos.i);
	}

}

class Position {
	public int i,j;
	public Position(int i, int j) {
		this.i = i;
		this.j = j;
	}
	@Override
	public boolean equals(Object obj) {
		Position other = (Position)obj;
		return i==other.i && j==other.j;
	}
}