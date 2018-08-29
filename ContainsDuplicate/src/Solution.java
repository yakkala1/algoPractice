import java.util.Arrays;
import java.util.TreeSet;

public class Solution {

	private int[] nums;
	private int k;
	private int t;

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if(k==0)
			return false;
		if(k<0 || t<0)
			return false;
		log("");
		log("");
		log( "nums : "+Arrays.toString(nums) );
		log("k : "+k);
		log("t : "+t);
		this.nums = nums;
		this.k = k;
		this.t = t;
		TreeSet<Integer> leftSet = new TreeSet<Integer>();
		TreeSet<Integer> rightSet = new TreeSet<Integer>();
		for(int i=0; i<rightLimit(0) && i<nums.length; i++) {
			rightSet.add( nums[i] );
		}
		for(int i=0; i<nums.length; i++) {
			int toRemoveIndex = substract(leftLimit(i),1);
			int toAddIndex = rightLimit(i);
			if( toRemoveIndex>=0 )
				leftSet.remove( nums[toRemoveIndex] );
			if( i-1>=0 )
				leftSet.add( nums[i-1] );
			rightSet.remove( nums[i] );
			if( toAddIndex<nums.length )
				rightSet.add( nums[toAddIndex] );
//			log("nums["+i+"] : "+nums[i] );
//			log(leftSet+"_"+rightSet);
//			log( (i-k) +" to "+ (i+k) );
//			log("------------------");
			if( leftSet.size()<shouldBeLeftSize(i)
					|| rightSet.size()<shouldBeRightSize(i)
					|| leftSet.subSet( substract(nums[i],t) , add(1,add(nums[i],t)) ).size()>0
					|| rightSet.subSet( substract(nums[i],t) , add(1,add(nums[i],t)) ).size()>0
					)
				return true;
		}
		return false;
	}
	
	private int add(int a, int b) {
		long sum = (long)a+(long)b;
		if( sum>Integer.MAX_VALUE )
			return Integer.MAX_VALUE;
		else if( sum<Integer.MIN_VALUE )
			return Integer.MIN_VALUE;
		else
			return (int)sum;
	}

	private Integer substract(int a, int b) {
		return add(a,-b);
	}

	private int shouldBeRightSize(int i) {
		return Math.min(k, nums.length-1-i);
	}

	private int shouldBeLeftSize(int i) {
		return Math.min(k, i);
	}

	private int rightLimit(int i) {
		return i+k;
	}

	private int leftLimit(int i) {
		return i-k;
	}
	
	private void log(Object obj) {
		System.out.println(obj);
	}

}