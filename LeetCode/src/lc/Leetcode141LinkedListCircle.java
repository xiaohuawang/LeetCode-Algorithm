package lc;

public class Leetcode141LinkedListCircle {

	
	public boolean hasCycle(ListNode head) {
		
		if(head==null){
			return false;
		}
		if(head.next==null){
			return false;
		}
		ListNode fast=head;
		ListNode slow=head;
		
		while(fast.next!=null&&fast!=null&&slow.next!=null){
			fast=fast.next.next;
			slow=slow.next;
			if(fast==slow){
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {

		Leetcode141LinkedListCircle lc=new Leetcode141LinkedListCircle();
		
		ListNode p0 = new ListNode(0);
		ListNode head = p0;
		
//		ListNode p1 = new ListNode(1);
//		p0.next = p1;
//		ListNode p2 = new ListNode(2);
//		p1.next = p2;
//		ListNode p3 = new ListNode(3);
//		p2.next = p3;
//		ListNode p4 = new ListNode(4);
//		p3.next = p4;
//		ListNode p5 = new ListNode(5);
//		p4.next = p5;
//		p5.next = p1;

		boolean res=lc.hasCycle(head);
		System.out.println("res= "+res);
		
		// while(head!=null){
		// System.out.print(head.val+"->");
		// head=head.next;
		// }
	}
}




















