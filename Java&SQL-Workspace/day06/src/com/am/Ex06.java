package com.am;

public class Ex06 {

	public static void main(String[] args) {
		// 문자열
		// 문자들의 집합
		String msg1;
		msg1 ="java";
		String msg2="java";
		
		String msg3 = new String("java");
		
		System.out.println(msg1);
		System.out.println(msg2);
		System.out.println(msg3);
		System.out.println(msg1==msg3); // msg3는 객체 생성으로 주소값을 나타낸다. reference 비교
		System.out.println(msg3.equals(msg2));
		char[] arr1=msg1.toCharArray();
		for(int i=0; i<arr1.length;i++) {
			System.out.println(arr1[i]);
		}
		for(int i=0; i<msg1.length();i++) {
			System.out.println(arr1[i]);
		}
		
		String msg4 = new String(arr1);
		System.out.println(msg4);
	}

}
