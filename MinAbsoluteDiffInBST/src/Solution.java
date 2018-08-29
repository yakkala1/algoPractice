import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	Map<TreeNode,Integer> minimumMap,maximumMap;
    public int minimun(TreeNode root) {
        minimumMap = new HashMap<TreeNode,Integer>();
        maximumMap = new HashMap<TreeNode,Integer>();
        getMin(root);
        getMax(root);
        return getMinDiff(root);
    }

	private int getMinDiff(TreeNode node) {
		List<Integer> possibles = new ArrayList<Integer>();
		if( node.left!=null ) {
			possibles.add( getMinDiff(node.left) );
			possibles.add( node.val-getMax(node.left) );
		}
		if( node.right!=null ) {
			possibles.add( getMinDiff(node.right) );
			possibles.add( getMin(node.right)-node.val );
		}
		if( possibles.size()==0 )
			return Integer.MAX_VALUE;
		else
			return Collections.min(possibles);
	}

	private int getMin(TreeNode node) {
		if( !minimumMap.containsKey(node) )
			minimumMap.put( node,calculateMin(node) );
		return minimumMap.get(node);
	}

	private int calculateMin(TreeNode node) {
		List<Integer> possibles = new ArrayList<Integer>();
		possibles.add(node.val);
		if( node.left!=null )
			possibles.add( getMin(node.left) );
		if( node.right!=null )
			possibles.add( getMin(node.right) );
		return Collections.min(possibles);
	}

	private int getMax(TreeNode node) {
		if( !maximumMap.containsKey(node) )
			maximumMap.put( node,calculateMax(node) );
		return maximumMap.get(node);
	}

	private int calculateMax(TreeNode node) {
		List<Integer> possibles = new ArrayList<Integer>();
		possibles.add(node.val);
		if( node.left!=null )
			possibles.add( getMax(node.left) );
		if( node.right!=null )
			possibles.add( getMax(node.right) );
		return Collections.max(possibles);
	}

}
