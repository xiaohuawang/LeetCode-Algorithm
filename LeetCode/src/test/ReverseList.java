package test;

import lc.ListNode;
import lc.ListNodeFunction;

public class ReverseList {

	private ListNode reverse(ListNode head) {

		ListNode pre = null;
		ListNode curr = head;

		while (curr != null) {

			ListNode next = curr.next;
			curr.next = pre;
			pre = curr;
			curr = next;

		}
		System.out.println("curr.val= " + curr);
		System.out.println("pre.val= " + pre.val);
		// lnf.printListNode(pre);

		return pre;
	}

	public static void main(String[] args) {

		ListNodeFunction lnf = new ListNodeFunction();
		ListNode head = new ListNode(1);
		ReverseList rl = new ReverseList();

		lnf.createList(5, head);
		lnf.printListNode(head);
		ListNode res = rl.reverse(head);
		lnf.printListNode(res);
	}

}
