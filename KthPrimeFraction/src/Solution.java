import java.util.PriorityQueue;

class Solution {
	
    private int[] A;
    int n;

	public int[] kthSmallestPrimeFraction(int[] A, int K) {
    	this.n = A.length;
    	this.A = A;
        PriorityQueue<Fraction> heap = new PriorityQueue<Fraction>();
        for(int i=0; i<n; i++) {
        	int numerator = A[i];
        	int denominator = A[n-1];
        	if(numerator < denominator)
        		heap.add( new Fraction(numerator, denominator, n-1) );
        }
        for(int i=0; i<K; i++) {
        	log(heap);
        	Fraction smallestFraction = heap.poll();
        	if(i == K-1)
        		return smallestFraction.toArray();
        	Fraction nextFraction = getNextFraction(smallestFraction);
        	if(nextFraction != null)
        		heap.add(nextFraction);
        }
        return new int[]{0,0};
    }

	private void log(Object obj) {
		System.out.println(obj);
	}

	private Fraction getNextFraction(Fraction fraction) {
		int nextNumerator = fraction.numerator;
		int nextIndex = fraction.denominatorIndex - 1;
		if( nextIndex < 0 )
			return null;
		int nextDenominator = A[nextIndex];
		if(nextNumerator >= nextDenominator)
			return null;
		return new Fraction(nextNumerator, nextDenominator, nextIndex);
	}
    
}

class Fraction implements Comparable<Fraction> {
	public int numerator, denominator;
	public int denominatorIndex;
	Fraction(int num, int den, int index) {
		this.numerator = num;
		this.denominator = den;
		this.denominatorIndex = index;
	}
	public int[] toArray() {
		return new int[]{numerator,denominator};
	}
	@Override
	public int compareTo(Fraction o) {
		return Integer.compare(this.numerator*o.denominator , o.numerator*this.denominator);
	}
	@Override
	public String toString() {
		return "["+numerator+","+denominator+","+denominatorIndex+"]";
	}
}