package lc_att;

public class Leetcode142LLCircle2 {

	public ListNode detectCycle(ListNode head) {

		if (head == null)
			return null;

		if (head.next == null)
			return null;

		ListNode fast = head;
		ListNode slow = head;

		// judge have circle or not
		while (fast != null && slow != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				break;
			}
		}

		// if there's a circle
		if (fast == slow) {
			System.out.println("fast.val= " + fast.val + " slow.val= " + slow.val);
			slow = head;
			while (slow != fast) {
				slow = slow.next;
				fast = fast.next;
			}
		}
		System.out.println("same point= " + fast.val);

		return slow;
	}

	public static void main(String[] args) {

		Leetcode142LLCircle2 lc = new Leetcode142LLCircle2();

		ListNode p0 = new ListNode(0);
		ListNode head = p0;

		 ListNode p1 = new ListNode(1);
		 p0.next = p1;
		 ListNode p2 = new ListNode(2);
		 p1.next = p2;
		 ListNode p3 = new ListNode(3);
		 p2.next = p3;
		 ListNode p4 = new ListNode(4);
		 p3.next = p4;
		 ListNode p5 = new ListNode(5);
		 p4.next = p5;
		 p5.next = p2;

		ListNode res = lc.detectCycle(head);
		if (res == null) {
			System.out.println("no cycle");
		} else {
			System.out.println("res.val= " + res.val);

		}

		// while (head != null) {
		// System.out.print(head.val + "->");
		// head = head.next;
		// }

	}

}
