package com.pm;

public class Ex01 {

	public static String uppercase(String msg) {
		char[] arr1 = msg.toCharArray();
		int gap = 'A' - 'a';
		for (int i = 0; i < msg.length(); i++) {
			if (arr1[i] >= 'a' && arr1[i] <= 'z') {
				arr1[i] += gap;
			}
		}
		return new String(arr1);
	}

	public static String concat(String msg1, String msg2) {
		char[] arr2 = msg1.toCharArray();//0~length-1
		char[] arr3 = msg1.toCharArray();
		char[] arr4 = new char[arr2.length+arr3.length];
		for (int i = 0; i <= arr2.length; i++) {
			arr4[i]=arr2[i];
		}
		for (int i = 0; i <= arr3.length; i++) {
			arr4[i+arr2.length]=arr3[i];
		}

		return new String(arr4);

	}

	public static void main(String[] args) {
		String msg1 = "ja";
		String msg2 = "va";

//		String msg = "java1234";
//		String result = uppercase(msg);
//		String result = msg.toUpperCase();
		String result = msg1.concat(msg2);
		System.out.println(result);
		
		String msg3="java";
		System.out.println(msg3==msg1+msg2);
		System.out.println(msg1==msg1+msg2);

		String msg5="a";
		for(int i=0; i<20; i++) {
			msg5+=i;
		}
		System.out.println(msg5);
		// System.out.println("JAVA"); 대문자 치환
//		char[] arr1 = msg.toCharArray();
//		for (int i = 0; i < msg.length(); i++) {
//			System.out.print((char) (arr1[i] - 32));
//		}

	}

}
