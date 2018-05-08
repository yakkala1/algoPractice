/*
 * https://practice.geeksforgeeks.org/problems/inorder-traversal/1
 * */
public class GFG {
	
	public void inOrder(Node root) {
		if(root == null)
			return;
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}

}
