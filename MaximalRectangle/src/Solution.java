import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
	
    public int maximalRectangle(char[][] matrix) {
    	if(matrix.length==0 || matrix[0].length==0)
    		return 0;
    	log("matrix");
    	log2dArray(matrix);
    	int[][] heights = getHeights(matrix);
    	log("heights");
    	log2dArray(heights);
    	int nRows = matrix.length;
    	int nCols = matrix[0].length;
    	int max = 0;
    	int i=0;
    	for(int[] row : heights) {
    		log("i : "+i++);
    		log( "row : "+Arrays.toString(row) );
    		List<Integer> areas = getAreas(row);
    		log("areas : "+areas);
    		max = Math.max(max, Collections.max(areas));
     	}
    	return max;
    }

	private void log2dArray(int[][] matrix) {
		for(int[] row : matrix) {
			log( Arrays.toString(row) );
		}
	}

	private void log2dArray(char[][] matrix) {
		for(char[] row : matrix) {
			log( Arrays.toString(row) );
		}
	}

	private void log(Object obj) {
		System.out.println(obj);
	}

	private List<Integer> getAreas(int[] row) {
		List<Integer> rightLimit = getRightLimit(row);
		List<Integer> leftLimit = getLefttLimit(row);
		List<Integer> area = new ArrayList<Integer>();
		for(int i=0; i<row.length; i++) {
			int height = row[i];
			int width = rightLimit.get(i)-leftLimit.get(i)-1;
			area.add( height*width );
		}
		return area;
	}

	private List<Integer> getLefttLimit(int[] row) {
		List<Integer> ret = new ArrayList<Integer>();
		int n = row.length;
		for(int i=0; i<n; i++)
			ret.add(0);
		ret.set(0,-1);
		for(int i=1; i<n; i++) {
			int possible = i-1;
			while( possible>=0 && row[possible]>=row[i] )
				possible = ret.get(possible);
			ret.set(i, possible);
		}
		return ret;
	}

	private List<Integer> getRightLimit(int[] row) {
		List<Integer> ret = new ArrayList<Integer>();
		int n = row.length;
		for(int i=0; i<n; i++)
			ret.add(0);
		ret.set(n-1, n);
		for(int i=n-2; i>=0; i--) {
			int possible = i+1;
			while( possible<n && row[possible]>=row[i] )
				possible = ret.get(possible);
			ret.set(i, possible);
		}
		return ret;
	}

	private int[][] getHeights(char[][] matrix) {
		int[][] heights = new int[matrix.length][matrix[0].length];
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				int val = getValue( matrix[i][j] );
				int prevHeight = (i-1>=0) ? heights[i-1][j] : 0;
				heights[i][j] = ((val==0) ? 0 : val+prevHeight);
			}
		}
		return heights;
	}

	private int getValue(char c) {
		return c=='0' ? 0 : 1;
	}

}
