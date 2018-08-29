class Solution {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		int size = getSize(head);
		if( n==size ) { 
			head = head.next;
			return head;
		} else {
			ListNode node = getNthNode(head,size-n);
			node.next = node.next.next;
			return head;
		}
	}

	private ListNode getNthNode(ListNode head, int n) {
		for(int i=1; i<n; i++) {
			head = head.next;
		}
		return head;
	}

	private int getSize(ListNode cur) {
		int size = 1;
		while(cur.next!=null) {
			cur = cur.next;
			size++;
		}
		return size;
	}

}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}