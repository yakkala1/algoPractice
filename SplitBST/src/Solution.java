class Solution {
	
	TreeNode lessTree,moreTree,lessPointer,morePointer;
	private int V;
	
    public TreeNode[] splitBST(TreeNode root, int V) {
    	this.V = V;
        split(root);
        TreeNode[] array = new TreeNode[]{lessTree,moreTree};
        return array;
    }

	private void split(TreeNode node) {
		if( node==null )
			return;
		if( node.val==V ) {
			addToMoreTree( node.right );
			node.right = null;
			addToLessTree( node );
		} else if( node.val<V ) {
			TreeNode rightTree = node.right;
			node.right = null;
			addToLessTree( node );
			split(rightTree);
		} else {
			TreeNode leftTree = node.left;
			node.left = null;
			addToMoreTree( node );
			split(leftTree);
		}
	}

	private void addToMoreTree(TreeNode node) {
		if(node==null)
			return;
		if( moreTree==null ) {
			moreTree = node;
			morePointer = leftMost(node);
		} else {
			morePointer.left = node;
			morePointer = leftMost(node);
		}
	}

	private void addToLessTree(TreeNode node) {
		if(node==null)
			return;
		if( lessTree==null ) {
			lessTree = node;
			lessPointer = rightMost(node);
		} else {
			lessPointer.right = node;
			lessPointer = rightMost(node);
		}
	}
    
	private TreeNode leftMost(TreeNode node) {
		TreeNode cur = node;
		while( cur.left != null )
			cur = cur.left;
		return cur;
	}

	private TreeNode rightMost(TreeNode node) {
		TreeNode cur = node;
		while( cur.right != null )
			cur = cur.right;
		return cur;
	}

}