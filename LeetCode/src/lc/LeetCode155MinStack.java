package lc;

public class LeetCode155MinStack {

	Element top;
	
	public LeetCode155MinStack() {

	}

	public void push(int x) {
		if(top==null){
			top=new Element(x,x);
		}else{
			Element e=new Element(x,Math.min(x,top.min));
			e.next=top;
			top=e;
		}
	}

	public void pop() {
		if(top==null){
			return;
		}else{
			Element temp=top.next;
//			top.next=null;
			top=temp;
		}
	}

	public int top() {
		return top.val;
	}

	public int getMin() {
		return top.min;
	}

}

class Element {

	public int min;
	public int val;
	Element next;

	public Element(int val, int min) {
		this.val = val;
		this.min = min;

	}
}


