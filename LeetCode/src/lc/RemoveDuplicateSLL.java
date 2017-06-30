package lc;

public class RemoveDuplicateSLL {

	public void remove_duplicates(ListNode head) {
		ListNode ptr1 = null, ptr2 = null, dup = null;
		ptr1 = head;

		/* Pick elements one by one */
		while (ptr1 != null && ptr1.next != null) {
			ptr2 = ptr1;

			/*
			 * Compare the picked element with rest of the elements
			 */
			while (ptr2.next != null) {

				/* If duplicate then delete it */
				if (ptr1.val == ptr2.next.val) {

					/* sequence of steps is important here */
					dup = ptr2.next;
					ptr2.next = ptr2.next.next;
					// System.gc();
				} else /* This is tricky */ {
					ptr2 = ptr2.next;
				}

			}
			ptr1 = ptr1.next;
		}
	}

	public void printList(ListNode node) {
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}

	public static void main(String[] args) {

		RemoveDuplicateSLL rdl = new RemoveDuplicateSLL();

		ListNode head = new ListNode(10);
		head.next = new ListNode(12);
		head.next.next = new ListNode(11);
		head.next.next.next = new ListNode(11);
		head.next.next.next.next = new ListNode(12);
		head.next.next.next.next.next = new ListNode(11);
		head.next.next.next.next.next.next = new ListNode(10);

		System.out.println("Linked List before removing duplicates : \n ");
		rdl.printList(head);

		rdl.remove_duplicates(head);
		System.out.println("");
		System.out.println("Linked List after removing duplicates : \n ");
		rdl.printList(head);
	}
}
