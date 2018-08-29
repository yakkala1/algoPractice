import java.util.HashMap;
import java.util.Map;

public class Solution {
	Map<TreeNode,Integer> map;
    public int kthSmallest(TreeNode root, int k) {
        map = new HashMap<TreeNode,Integer>();
        getCount(root);
        return search(root,k);
    }
    
	private int search(TreeNode node, int k) {
		int leftCount = getCount(node.left);
		if( leftCount>=k )
			return search(node.left,k);
		else if( leftCount==k-1 )
			return node.val;
		else
			return search(node.right,k-leftCount-1);
	}

	private int getCount(TreeNode node) {
		if( node==null )
			return 0;
		else if( map.containsKey(node) )
			return map.get(node);
		else {
			int n = getCount(node.left)+getCount(node.right)+1;
			map.put(node, n);
			return n;
		}
	}

}
