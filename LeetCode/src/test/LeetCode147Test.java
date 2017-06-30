package test;

import lc.ListNode;

public class LeetCode147Test {

	public ListNode insertionSortList(ListNode head) {
		
		return null;
		
	}
	
	public static void main(String[] args) {
		
		LeetCode147Test lc=new LeetCode147Test();
		ListNode n1 = new ListNode(30);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(4); 
		ListNode n4 = new ListNode(20);
		ListNode n5 = new ListNode(5);
 
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		ListNode head=n1;
		
		lc.insertionSortList(head);

	}

}
