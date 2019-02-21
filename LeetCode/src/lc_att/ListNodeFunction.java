package lc_att;

public class ListNodeFunction {

	// create linkedlist
	public ListNode createList(int listLength, ListNode head) {

		ListNode pre = head;

		for (int i = 0; i < listLength - 1; i++) {
			ListNode curr = new ListNode(pre.val + 1);
			// System.out.print(curr.val +" ");
			pre.next = curr;
			pre = curr;
			curr = curr.next;
		}

		// System.out.println();

		// while(head!=null){
		// System.out.print(head.val+"->");
		// head=head.next;
		// }

		return head;
	}

	public void printListNode(ListNode head) {
		ListNode p1 = head;
		while (p1 != null) {
			System.out.print(p1.val + "->");
			p1 = p1.next;
		}
		System.out.println();
	}
}
