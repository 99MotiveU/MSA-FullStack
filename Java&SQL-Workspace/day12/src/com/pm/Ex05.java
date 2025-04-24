package com.pm;

import java.util.LinkedList;

public class Ex05 {

	public static void main(String[] args) {
		
		// FIFO (first-in-first-out) 
		java.util.Queue que=new LinkedList();
		que.offer("첫번째");
		que.offer("두번째");
		que.offer("세번째");
		que.offer("네번째");
		que.offer("다섯번째");
		
//		System.out.println(que.poll());
//		System.out.println(que.poll());
//		System.out.println(que.poll());
//		System.out.println(que.poll());
//		System.out.println(que.poll());
//		System.out.println(que.poll());
//		Object obj=null;
//		while((obj=que.poll())!=null) {
//			System.out.println(obj);
//		}
		
//		System.out.println(que.peek());
//		que.poll();
//		System.out.println(que.peek());
//		que.poll();
//		System.out.println(que.peek());
//		que.poll();
//		System.out.println(que.peek());
//		que.poll();
//		System.out.println(que.peek());
//		que.poll();
//		System.out.println(que.peek());
//		que.poll();
		while(que.peek()!=null) {
			System.out.println(que.poll());
		}
	
	}

}












