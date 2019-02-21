package test;

import lc_att.ListNode;
import lc_att.ListNodeFunction;

public class LinkedListTest {

	public ListNode mergetTwoList(ListNode head1,ListNode head2){
		
		System.out.println("come");
		ListNode p1=head1;
		
		while(head1!=null&&head2!=null){
			System.out.println("count");
			ListNode temp1=head1.next;
			ListNode temp2=head2.next;
			
			head1.next=head2;
			head2.next=temp1;
			head1=temp1;
			head2=temp2;
		}
		return p1;
	}
	
	
	public static void main(String[] args) {

		LinkedListTest llt=new LinkedListTest();
		ListNode head1 = new ListNode(1);
		ListNodeFunction lnf = new ListNodeFunction();

		lnf.createList(3, head1);
		lnf.printListNode(head1);
		
		ListNode head2=new ListNode(6);
		ListNode p2=head2;
		p2.next=new ListNode(5);
		p2=p2.next;
		p2.next=new ListNode(4);
		lnf.printListNode(head2);
		
		ListNode res=llt.mergetTwoList(head1,head2);
		lnf.printListNode(res);
	}

}
