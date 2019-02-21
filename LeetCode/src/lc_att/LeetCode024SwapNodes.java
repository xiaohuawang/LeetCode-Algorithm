package lc_att;

public class LeetCode024SwapNodes {

	public ListNode swapPairs(ListNode head) {

//		ListNodeFunction lnf = new ListNodeFunction();
		ListNode p1 = head;
		ListNode p2 = head.next;
		ListNode p3 = head;
		ListNode p4 = head.next;

		split(p1,p2);
//		lnf.printListNode(p3);
//		lnf.printListNode(p4);
		
		ListNode res=merge(p3,p4);
		return res;
	}

	private ListNode merge(ListNode p3, ListNode p4) {
		
		ListNode head=p4;
//		System.out.println("p3.val= "+p3.val);
//		System.out.println("p4.val= "+p4.val);
		while(p3.next!=null&&p4.next!=null){
			ListNode temp3=p3.next;
			ListNode temp4=p4.next;
			
			p4.next=p3;
			p3.next=temp4;
			
			p3=temp3;
			p4=temp4;
		}
		
		if(p3!=null){
			p4.next=p3;
		}
//		System.out.println(p3.val);
//		System.out.println(p4.val);
		
		return head;
//		ListNodeFunction lnf = new ListNodeFunction();
//		lnf.printListNode(head);
	}

	private void split(ListNode p1, ListNode p2) {

		ListNode head1=p1;
		ListNode head2=p2;
		while (p1.next != null&&p2.next!=null) {
			ListNode temp1 = p1.next.next;
			ListNode temp2 = p2.next.next;

			p1.next = temp1;
			p2.next = temp2;
			p1 = p1.next;
			p2 = p2.next;
		}
		if(p1.next!=null){
			p1.next=null;
		}
//		ListNodeFunction lnf = new ListNodeFunction();
		
//		lnf.printListNode(head1);
//		lnf.printListNode(head2);
	}

	public static void main(String[] args) {
		LeetCode024SwapNodes lc = new LeetCode024SwapNodes();
		ListNodeFunction lnf = new ListNodeFunction();

		ListNode head = new ListNode(1);
		lnf.createList(6, head);
		ListNode res = lc.swapPairs(head);
		lnf.printListNode(res);
	}

}
