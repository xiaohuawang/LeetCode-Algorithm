package lc_ea;

import node.ListNode;

//Given this linked list: 1->2->3->4->5
//
//For k = 2, you should return: 2->1->4->3->5
//
//For k = 3, you should return: 3->2->1->4->5

public class Leetcode25 {

	public static ListNode reverseKGroup(ListNode head, int k) {

		ListNode current_node = head;

		for (int i = 0; i < k - 1; i++) {
			current_node = current_node.next;
		}
		ListNode current_next = current_node.next;

		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode p1 = new ListNode(1);
		ListNode p2 = new ListNode(2);
		ListNode p3 = new ListNode(3);
		ListNode p4 = new ListNode(4);
		ListNode p5 = new ListNode(5);
		ListNode head = p1;

		head.next = p2;
		p2.next = p3;
		p3.next = p4;
		p4.next = p5;
		reverseKGroup(head, 3);
	}

}
