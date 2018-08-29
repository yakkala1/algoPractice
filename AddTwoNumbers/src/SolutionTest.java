import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class SolutionTest {
	Solution sol = new Solution();

	@Test
	public void test1() {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		ListNode expected = new ListNode(7);
		expected.next = new ListNode(0);
		expected.next.next = new ListNode(8);
		test(l1,l2,expected);
	}

	@Test
	public void test2() {
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(5);
		ListNode expected = new ListNode(7);
		test(l1,l2,expected);
	}

	@Test
	public void test3() {
		ListNode l1 = new ListNode(0);
		ListNode l2 = new ListNode(5);
		ListNode expected = new ListNode(5);
		test(l1,l2,expected);
	}

	@Test
	public void test4() {
		ListNode l1 = new ListNode(0);
		ListNode l2 = new ListNode(0);
		ListNode expected = new ListNode(0);
		test(l1,l2,expected);
	}
	
	@Test
	public void test5() {
	}
	
	public void test(ListNode l1, ListNode l2, ListNode expected) {
		ListNode ret = sol.addTwoNumbers(l1, l2);
		assertEquals(expected.val, ret.val);
	}
	
	public void log(Object obj) {
		System.out.println(obj);
	}

}
