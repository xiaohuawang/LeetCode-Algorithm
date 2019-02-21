package lc_att;

public class LeetCode160InterTwoList {

	int diff = 0;

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		lenDifference(headA, headB);
		System.out.println("diff= " + diff);

		if (diff > 0) {
			while (diff > 0) {
				headA = headA.next;
				diff--;
			}
		} else {
			while (diff < 0) {
				headB = headB.next;
				diff++;
			}
		}
		
		System.out.println("headA begin value= " + headA.val);
		System.out.println("headB begin value= " + headB.val);

		while (headA != null && headB != null) {
			if (headA.val == headB.val) {
				return headA;
			}
			headA = headA.next;
			headB = headB.next;
		}
		return null;
	}

	public void lenDifference(ListNode headA, ListNode headB) {

		int len1 = 0, len2 = 0;

		while (headA != null) {
			headA = headA.next;
			len1++;
		}

		while (headB != null) {
			headB = headB.next;
			len2++;
		}
		diff = len1 - len2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

		// ListNode p1 = new ListNode(9);
		// ListNode p2 = new ListNode(8);
		// ListNode p3 = new ListNode(7);
		ListNode p4 = new ListNode(3);
		ListNode p5 = new ListNode(4);
		ListNode p6 = new ListNode(5);

		// p1.next = p2;
		// p2.next = p3;
		// p3.next = p4;
		p4.next = p5;
		p5.next = p6;

		ListNode headA = n1;
		ListNode headB = p4;

		// ListNode headA = p1;
		// ListNode headB = null;

		LeetCode160InterTwoList lc = new LeetCode160InterTwoList();
		ListNode res = lc.getIntersectionNode(headA, headB);
		System.out.println(res);
		// System.out.println("common begin value= "+res.val);
	}

}
