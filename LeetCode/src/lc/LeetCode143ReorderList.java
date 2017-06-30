package lc;

public class LeetCode143ReorderList {

	// method 1: non-recursive
	public void reorderList(ListNode head) {
		
		ListNodeFunction lnf=new ListNodeFunction();
		
		if (head == null || head.next == null)
			return;
		// 1)找到中点，然后截成两条链表；
		ListNode p1=head;
		ListNode p2=head;
		ListNode p=head;
		
		while(p2.next!=null&&p2.next.next!=null){
//		while(p2!=null&&p2.next!=null){
			p1=p1.next;
			p2=p2.next.next;
		}
		
//		System.out.println("p1.val="+p1.val);
//		System.out.println("p2.val="+p2.val);
		
		p2=p1.next;
		p1.next=null;
		// 无论 12345 或 123456
		// 此时p1都在3，从3后面断开。123/45,123/456
		// p1,p2分别为两段 linkedlist 的起点
//		System.out.println("p2.val= "+p2.next.next.val);
		// （2）将后面一条链表reverse；
		ListNode head1=p;
		ListNode head2=reverse(p2);	
		
//		lnf.printListNode(head1);
//		lnf.printListNode(head2);
		// （3）将两条链表按顺序依次merge起来。

		putTogether(head1,head2);
		
		System.out.println("result is here");
		lnf.printListNode(p);
		return;
	}

	private void putTogether(ListNode head1, ListNode head2) {

		while (head1 != null && head2 != null) {

			ListNode temp1 = head1.next;
			ListNode temp2 = head2.next;
			System.out.println("count");
			head1.next = head2;
			head2.next = temp1;
			head1 = temp1;
			head2 = temp2;

		}
	}
	
	private ListNode reverse(ListNode p2) {
		
		ListNode pre=null;
		ListNode curr=p2;
		
		while(curr!=null){
			ListNode temp=curr.next;
			curr.next=pre;
			pre=curr;
			curr=temp;
		}
//		System.out.println("curr"+curr.val);
//		System.out.println("pre="+pre.val);
		return pre;
	}
	

	// Method 2: recursive
	// public ListNode recursive_reverse(ListNode head) {
	// if(head == null || head.next==null)
	// return head;
	// return recursive_reverse(head, head.next);
	// }
	//
	// private ListNode recursive_reverse(ListNode current, ListNode next) {
	// if (next == null) return current;
	// ListNode newHead = recursive_reverse(current.next, next.next);
	// next.next = current;
	// current.next = null;
	// return newHead;
	// }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNodeFunction lnd = new ListNodeFunction();
		LeetCode143ReorderList lc = new LeetCode143ReorderList();
		ListNode head = new ListNode(1);

		lnd.createList(6, head);
		lnd.printListNode(head);
		System.out.println();
		lc.reorderList(head);
//		ListNode res=lc.reorderList(head);
//		lnd.printListNode(res);
	}

}
