package lc;

public class AppForMinStack {

	public static void main(String[] args) {

		LeetCode155MinStack lc=new LeetCode155MinStack();
		lc.push(10);
		lc.push(15);
		lc.push(3);
	
//		System.out.println(lc.top());
		System.out.println(lc.top.val);
		System.out.println(lc.top.next.val);
		System.out.println(lc.top.next.next.val);
		System.out.println(lc.getMin());
		lc.pop();
		System.out.println(lc.top());
	}

}


//Leetcode 155 - Min Stack - 设计.java
//
//在ArrayList的基础上，使用get(), remove(), add() 实现栈
//
//push:   add 入 stack
//    如果 push 的值比minstack的最小值小，同时 add 入 minstack
//pop:    如果 pop 的值比目前最小值大，仅 remove 出 stack 中的值
//    如果 pop 的值即为目前的最小值，同时 remove 出 stack 和 minstack
//top:    返回 stack 顶部的值
//getMin: 返回 minStack 顶部的值



