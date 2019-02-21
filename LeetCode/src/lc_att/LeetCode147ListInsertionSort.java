package lc_att;

public class LeetCode147ListInsertionSort {

	
	 public ListNode insertionSortList(ListNode head) {
		
		 ListNode p1=head;
		 ListNode p2=head.next;
		 ListNode p3=head;
		 int len=0;
		 
//		 while(p1!=null){
//			 p1=p1.next;
//			 len++;
//		 }
//		 System.out.println("len= "+len);
//		 30->3->4->20->5
		 for(int i=0;i<2;i++){
//	     while(p1!=null&p2!=null){
			 ListNode temp1=p1.next;
			 ListNode temp2=p2.next;
			 if(p1.val>p2.val){
//				p2.next.next=p1;
				//p1.pre=p2;
				p1.next=p2;
			} 
			p1=temp1;
			p2=temp2;
//			System.out.println("come");
		 }
//		 while(p2!=null&&p1!=null){
//			 if(p1.val>p2.val){
//				 p2.next=p1;
//				 p1.next=p2;
//			 }
//			 p2=p2.next;
//			 p1=p1.next;
//			 
//			 System.out.println("come");
//		 }
		 
		 System.out.println("p2.val= "+p2.val);
		 System.out.println("p2.next.val= "+p2.next.val);
		 System.out.println("p1.val= "+p1.val);
		 System.out.println("p1.next= "+p1.next.val);
		return null;
	 }
	
	public static void main(String[] args) {
		
		LeetCode147ListInsertionSort lc=new LeetCode147ListInsertionSort();
		
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
