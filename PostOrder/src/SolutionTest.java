package src;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void test1() {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		node5.left = node8;
		Solution sol = new Solution();
		sol.postOrder( node1 );
	}

	@Test
	public void test2() {
	}

	@Test
	public void test3() {
	}

	@Test
	public void test4() {
	}
	
	public void test() {
		
	}
	
	public void log(Object obj) {
		System.out.println(obj);
	}

}
