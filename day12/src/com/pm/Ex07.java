package com.pm;

import java.util.Stack;

public class Ex07 {

	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push("첫번쨰");
		stack.push("두번쨰");
		stack.push("세번쨰");
		stack.push("네번쨰");
		System.out.println(stack.search("세번째")); //나오는 순서에 대한 리턴, 없을경우 -1
		while(stack.isEmpty()) {
			System.out.println(stack.peek());
			stack.pop();
		}
		
	}

}
