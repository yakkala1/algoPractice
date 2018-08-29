import java.util.*;
import java.lang.*;

class Main
{
	//A left
	//B top
	static int[][] mem,A,B,sumA,sumB;
	static int nRows,nCols;
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		nRows = sc.nextInt();
		nCols = sc.nextInt();
		
		if(nRows==0 && nCols==0)
			return;
		
		A = new int[nRows][nCols];
		for(int i=0; i<nRows; i++) {
			for(int j=0; j<nCols; j++) {
				A[i][j] = sc.nextInt();
			}
		}
		
		B = new int[nRows][nCols];
		for(int i=0; i<nRows; i++) {
			for(int j=0; j<nCols; j++) {
				B[i][j] = sc.nextInt();
			}
		}
		
		initialize();
		
		System.out.println( solve(nRows,nCols,A,B) );
	}

	private static void initialize() {
		mem = new int[nRows][nCols];
		sumA = new int[nRows][nCols];
		sumB = new int[nRows][nCols];
		for(int i=0; i<nRows; i++) {
			for(int j=0; j<nCols; j++) {
				mem[i][j] = -1;
				sumA[i][j] = -1;
				sumB[i][j] = -1;
			}
		}
	}

	private static int solve(int nRows, int nCols, int[][] A, int[][] B) {
		return get(0,0);
	}

	private static int get(int i, int j) {
		if( outOfLimits(i,j) )
			return 0;
		if( mem[i][j] == -1 )
			mem[i][j] = calculate(i,j);
		return mem[i][j];
	}

	private static int calculate(int i, int j) {
		return Math.max(
				sumA(i,j) + get(i,j+1),
				sumB(i,j) + get(i+1,j)
				);
	}

	private static int sumB(int i, int j) {
		if( outOfLimits(i,j) )
			return 0;
		if( sumB[i][j]==-1 )
			sumB[i][j] = calculateSumB(i,j);
		return sumB[i][j];
	}

	private static int calculateSumB(int i, int j) {
		return sumB(i,j+1) + B[i][j];
	}

	private static int sumA(int i, int j) {
		if( outOfLimits(i,j) )
			return 0;
		if( sumA[i][j]==-1 )
			sumA[i][j] = calculateSumA(i,j);
		return sumA[i][j];
	}

	private static int calculateSumA(int i, int j) {
		return sumA(i+1,j) + A[i][j];
	}

	private static boolean outOfLimits(int i, int j) {
		return !inLimits(i, j);
	}

	private static boolean inLimits(int i, int j) {
		return (i>=0) && (i<nRows) && (j>=0) && (j<nCols);
	}
	
}
