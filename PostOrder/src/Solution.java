package src;

import java.util.Stack;

class Solution {

	Stack<Fn> stack = new Stack<Fn>();

	public void postOrder(Node node) {
		if(node!=null)
			stack.add(new Fn(node));
		while( !stack.empty() ) {
			Fn fn = stack.peek();
			fn.executeOneLine();
		}
	}

	class Fn {
		public Node node;
		public static final int 
		STARTED = 0,
		PRINTED = 1,
		LEFT_DONE = 2,
		COMPLETED = 3;
		int status;

		public Fn(Node node) {
			this.node = node;
			this.status = STARTED;
		}

		public void executeOneLine() {
			switch(status) {
			case(STARTED):
				print();
			break;
			case(PRINTED):
				processLeft();
			break;
			case(LEFT_DONE):
				processRight();
			break;
			case(COMPLETED):
				stack.pop();
			break;
			default:
				break;
			}
		}

		private void print() {
			System.out.println(node.value);
			status = PRINTED;
		}

		private void processLeft() {
			if(node.left!=null)
				stack.add( new Fn(node.left) );
			status = LEFT_DONE;
		}

		private void processRight() {
			if(node.right!=null)
				stack.add( new Fn(node.right) );
			status = COMPLETED;
		}

	}

}



