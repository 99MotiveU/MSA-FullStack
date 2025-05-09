package com.pm;

public class Ex16 {
// Create Read Update Delete
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("abc");
		StringBuffer sb2 = new StringBuffer(new StringBuilder("abc"));
		StringBuffer sb3 = new StringBuffer(5);
		System.out.println(sb3.capacity());
		
//		for(int i=0; i<13; i++) {
//			sb3.append('a');
//		}
//		System.out.println(sb3.capacity());
		
		System.out.println(sb3.append("ja"));
		System.out.println(sb3.append("va"));
		//수정
		System.out.println(sb3.replace(1, 3, "AV"));
		//삭제
		System.out.println(sb3.delete(1, 3));
		
		System.out.println(sb3.insert(1,"AV"));
		System.out.println(sb3.insert(4, "WEB"));
		
		System.out.println(sb3.reverse());
		
	}

}
