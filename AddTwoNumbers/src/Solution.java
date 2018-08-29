class Solution {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int exess = 0;
		ListNode retHead,cur;
		cur = new ListNode(0);
		retHead = cur;
		while(true) {
			int n1 = 0;
			int n2 = 0;
			if(l1==null && l2==null)
				break;
			if(l1!=null)
				n1 = l1.val;
			if(l2!=null)
				n2 = l2.val;
			log("n1 : "+n1);
			log("n2 : "+n2);
			int value = (n1+n2+exess)%10;
			exess = (n1+n2+exess)/10;
			cur.next = new ListNode(value);
			cur = cur.next;
			log("cur : "+cur.val);
			if(l1 != null)
				l1 = l1.next;
			if(l2 != null)
				l2 = l2.next;
		}
		if(exess!=0)
			cur.next = new ListNode(exess);
		return retHead.next;
	}
	
	public void log(Object obj) {
//		System.out.println(obj);
	}

}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}