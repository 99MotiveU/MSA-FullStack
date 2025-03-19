package com.pm;

import java.util.Deque;
import java.util.LinkedList;

public class Ex06 {

	public static void main(String[] args) {
//		Deque que1 = new LinkedList();
//		que1.offerFirst("첫번째");
//		que1.offerFirst("두번째");
//		que1.offerFirst("세번째");
//		
//		while(que1.peekLast()!=null) {
//			System.out.println(que1.pollLast());
//		}
		
//		Deque que2 = new LinkedList();
//		que1.offerFirst("첫번째");
//		que1.offerFirst("두번째");
//		que1.offerFirst("세번째");
//		
//		while(que1.peekLast()!=null) {
//			System.out.println(que1.pollLast());
//		}
		
//		Deque stack1 = new LinkedList();
//		stack1.offerFirst("첫번쨰");
//		stack1.offerFirst("두번째");
//		stack1.offerFirst("세번째");
//		
//		while(stack1.peekFirst()!=null) {
//			System.out.println(stack1.pollFirst());
//		}
		
		Deque stack2 = new LinkedList();
		stack2.offerFirst("첫번쨰");
		stack2.offerFirst("두번째");
		stack2 .offerFirst("세번째");
		
		while(stack2.peekLast()!=null) {
			System.out.println(stack2.pollFirst());
		}
		
	}

}
