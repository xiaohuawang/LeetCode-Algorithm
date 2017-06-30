package lc;

import java.util.Scanner;

public class LeetCode025ReverseKNodes {

	// Given a linked list, reverse the nodes of a linked list k at a time and
	// return its modified list.
	//
	// If the number of nodes is not a multiple of k then left-out nodes in the
	// end should remain as it is.
	//
	// You may not alter the values in the nodes, only nodes itself may be
	// changed.
	//
	// Only constant memory is allowed.
	//
	// For example,
	// Given this linked list: 1->2->3->4->5
	//
	// For k = 2, you should return: 2->1->4->3->5
	//
	// For k = 3, you should return: 3->2->1->4->5

	public ListNode reverseKGroup(ListNode head, int k) {

//		System.out.println("head.val= " + head.val);
		ListNode p1 = head;
		ListNode p2 = head;
		ListNode p3 = head;
		ListNode p4 = head;
		int count = 0;
		int len = 0;

		while (p1 != null) {
			len++;
			p1 = p1.next;
		}

		System.out.println("len= " + len);
		System.out.println();

		if (k > len) {
			return p2;
		} else {
			for(int i=0;i<len;i++){
//			while (p2 != null) {
				if(i%k==0){
					System.out.println("it comes    i= "+i+"  p2.val= "+p2.val);
					System.out.println(p2.next.val);
					p2=reverse(p2,k,p2.next);
//					System.out.println("p2.val= "+p2.val);
				}
				p2=p2.next;
				System.out.println();
			}
		}
		System.out.println("p2= "+p2.val);
		// System.out.println("p2.val= " + p2.val);
		// ListNode newhead2 = p2.next;
		// p2.next = null;
		// ListNode newtail1 = reverse(p3);
		// System.out.println("new tail1.val= " + newtail1.val);
		// p4.next = newhead2;
		// // System.out.println("p2=" + p2.val);
		// return newtail1;
		return null;

	}

	private ListNode reverse(ListNode p2,int k,ListNode p2Next) {
		
		ListNodeFunction lnf=new ListNodeFunction();
		ListNode head=p2;
		System.out.println("p2.val= "+p2.val);
		ListNode curr = p2;
		ListNode pre = null;
		System.out.println("k= "+k);
		
		for(int i=0;i<k;i++){
//		while (curr != null) {
			ListNode temp = curr.next;
			curr.next = pre;
			pre = curr;
			curr = temp;
		}
		head.next=p2Next;
//		lnf.printListNode(pre);
		
		return head;
	}

	// when k==2,
	// it should be 2-1-4-3-5

	public static void main(String[] args) {

		LeetCode025ReverseKNodes lc = new LeetCode025ReverseKNodes();
		ListNodeFunction lnf = new ListNodeFunction();

		ListNode head = new ListNode(1);
		lnf.createList(10, head);
		Scanner sc = new Scanner(System.in);
		System.out.println("pls input the k");

		int k = sc.nextInt();
//		ListNode res = lc.reverseKGroup(head, k);
		ListNode res = lc.reverseKGroupAns(head, k);
		lnf.printListNode(res);

	}

	public ListNode reverseKGroupAns(ListNode head, int k) {
		if (head == null || k == 1)
			return head;

		ListNode fake = new ListNode(0);
		fake.next = head;
		ListNode pre = fake;
		int i = 0;

		ListNode p = head;
		while (p != null) {
			i++;
			if (i % k == 0) {
				System.out.println("come   p.val= "+p.val);
				pre = reverse(pre, p.next);
				p = pre.next;
			} else {
				p = p.next;
			}
		}

		return fake.next;
	}

	/*
	 * 0->1->2->3->4->5->6 | | pre next
	 *
	 * after calling pre = reverse(pre, next)
	 *
	 * 0->3->2->1->4->5->6 | | pre next
	 */
	public ListNode reverse(ListNode pre, ListNode next) {
		
		System.out.println("pre= "+pre.val);
		System.out.println("next= "+next.val);
		ListNode last = pre.next;
		ListNode curr = last.next;

		while (curr != next) {
			last.next = curr.next;
			curr.next = pre.next;
			pre.next = curr;
			curr = last.next;
		}
		System.out.println("last= "+last.val);
		System.out.println();
		
		return last;
	}

}
