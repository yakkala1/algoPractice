import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
	
    public List<Integer> countSmaller(int[] nums) {
    	int n = nums.length;
    	if(n==0)
    		return new ArrayList<Integer>();
    	List<Integer> ret = new ArrayList<Integer>();
    	Node tree = new Node( nums[n-1] );
    	ret.add(0);
    	for( int i=n-2; i>=0; i-- ) {
    		Node node = new Node(nums[i]);
    		ret.add( tree.insert(node) );
    	}
    	Collections.reverse(ret);
    	return ret;
    }

}

class Node {
	public int value,count,treeSize;
	public Node left,right;
	public Node(int value) {
		this.value = value;
		this.count = 1;
		this.treeSize = 1;
	}
	public int insert(Node node) {
		treeSize++;
		if( node.value<this.value ) {
			return insertLeft(node);
		} else if( node.value>this.value ) {
			int nSmallerInRightTree = insertRight(node);
			return this.count+treeSize(left)+nSmallerInRightTree;
		} else {
			count++;
			return treeSize(left);
		}
	}
	private int treeSize(Node node) {
		if(node == null)
			return 0;
		else
			return node.treeSize;
	}
	private int insertRight(Node node) {
		if(this.right == null) {
			this.right = node;
			return 0;
		} else 
			return this.right.insert(node);
	}
	private int insertLeft(Node node) {
		if(this.left == null) { 
			this.left = node;
			return 0;
		} else
			return this.left.insert(node);
	}
}