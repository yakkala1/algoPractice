
class GfG
{
	int detectLoop(Node head)
	{
		Node p1 = head.next;
		Node p2 = head.next.next;
		while(
				p1.next != null && 
				p2.next != null &&
				p2.next.next != null
		) {
			if(p1 == p2)
				return 1;
			else {
				p1 = p1.next;
				p2 = p2.next.next;
			}
		}
		return 0;
	}
}

