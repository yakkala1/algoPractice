
public class GfG {
	
	public void preorder(Node root) {
		if(root==null)
			return;
		System.out.print(root.data+" ");
		preorder(root.left);
		preorder(root.right);
	}

}
