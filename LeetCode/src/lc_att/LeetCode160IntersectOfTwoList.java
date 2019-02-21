package lc_att;

public class LeetCode160IntersectOfTwoList {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		if (headA == null || headB == null) {
			return null;
		}

		int countA = 0;
		ListNode p = headA;
		while (p != null) {
			p = p.next;
			countA++;
		}

		int countB = 0;
		p = headB;
		while (p != null) {
			p = p.next;
			countB++;
		}

		int diff;
		ListNode fast;
		ListNode slow;
		if (countA > countB) {
			diff = countA - countB;
			fast = headA;
			slow = headB;
		} else {
			diff = countB - countA;
			fast = headB;
			slow = headA;
		}

		while (diff > 0) {
			fast = fast.next;
			diff--;
		}

		while (fast != null && slow != null) {
			if (fast != slow) {
				fast = fast.next;
				slow = slow.next;
			} else {
				return fast;
			}
		}

		return null;
	
	}

	public static void main(String[] args) {

		LeetCode160IntersectOfTwoList lc = new LeetCode160IntersectOfTwoList();
		ListNodeFunction lnf = new ListNodeFunction();
		// ListNode p1=new ListNode(1);
		// ListNode head=p1;
		// ListNode p2=new ListNode(2);
		// p1.next=p2;
		// ListNode p3=new ListNode(3);
		// p2.next=p3;
		// ListNode p4=new ListNode(4);
		// p3.next=p4;
		// ListNode p5=new ListNode(5);
		// p4.next=p5;

		int listLength = 2;
		ListNode headA = new ListNode(1);
		headA = lnf.createList(listLength, headA);

		ListNode q1 = new ListNode(10);
		ListNode headB = q1;
		ListNode q2 = new ListNode(9);
		q1.next = q2;
		ListNode q3 = new ListNode(1);
		q2.next = q3;
		ListNode q4 = new ListNode(2);
		q3.next = q4;

		// while (head != null) {
		// System.out.print(head.val + "->");
		// head = head.next;
		// }

		ListNode headAns = lc.getIntersectionNode(headA, headB);
		System.out.println(headAns);
		lnf.printListNode(headAns);

	}

}
