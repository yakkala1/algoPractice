import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
	
    public List<List<Integer>> threeSum(int[] nums) {
    	int n = nums.length;
        List<Integer> positives = new ArrayList<Integer>();
        List<Integer> negatives = new ArrayList<Integer>();
        Set<Integer> numbersSet = new HashSet<Integer>();
        boolean containsZero = false;
        int nZeroes = 0;
        for(int num:nums) {
        	numbersSet.add(num);
        	if(num>0) {
        		positives.add(num);
        	} else if(num<0) {
        		negatives.add(num);
        	} else {
        		nZeroes++;
        		containsZero = true;
        	}
        }
        Collections.sort(negatives);
        Collections.sort(positives);
        Set<Triplet> triplets = new HashSet<Triplet>();
        for(int i=0; i<negatives.size(); i++) {
        	for(int j=0; j<i; j++) {
        		int sum = negatives.get(i) + negatives.get(j);
        		if( numbersSet.contains(-sum) ) {
        			triplets.add( new Triplet( negatives.get(i), negatives.get(j), -sum) );
        		}
        	}
        }
        for(int i=0; i<positives.size(); i++) {
        	for(int j=0; j<i; j++) {
        		int sum = positives.get(i) + positives.get(j);
        		if( numbersSet.contains(-sum) ) {
        			triplets.add( new Triplet( positives.get(i), positives.get(j), -sum) );
        		}
        	}
        }
        if(containsZero) {
        	for(int negative : negatives) {
        		if(numbersSet.contains( -negative )) {
        			triplets.add( new Triplet(negative,0,-negative) );
        		}
        	}
        }
        if( nZeroes>=3 ) {
        	triplets.add( new Triplet(0,0,0) );
        }
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for(Triplet triplet : triplets) {
        	ret.add( triplet.list );
        }
        return ret;
    }
    
    private void log(Object obj) {
    	System.out.println(obj);
    }

}

class Triplet {
	public List<Integer> list = new ArrayList<Integer>();
	public Triplet(int i,int j, int k) {
		list.add(i);
		list.add(j);
		list.add(k);
		Collections.sort(list);
	}
	@Override
	public int hashCode() {
		return toString().hashCode();
	}
	@Override
	public boolean equals(Object o) {
		Triplet other = (Triplet)o;
		return toString().equals( other.toString() );
	}
	@Override
	public String toString() {
		return list.get(0)+","+list.get(1)+","+list.get(2);
	}
}