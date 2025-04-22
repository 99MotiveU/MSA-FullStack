package com.pm;
//꼭 알아야함
public class Ex04 {

	public static void main(String[] args) {
		String msg1 = "Hello World1234";
//		String msg1 = "한";  자바는 유니코드 체계   |  utf-8/ms949
//		String msg1 = "A";
		System.out.println(msg1.startsWith("He"));
		System.out.println(msg1.endsWith("ld"));
		System.out.println(msg1.startsWith("he"));
		System.out.println(msg1.endsWith("l"));
		System.out.println(msg1 == "Hello World"); // compare value
		System.out.println(msg1.equals("Hello world")); // compare reference

		byte[] arr1 = msg1.getBytes();
		char[] arr2 = msg1.toCharArray();
		System.out.println(arr1.length);
		System.out.println(arr2.length);
		
		char[] arr3 = new char[msg1.length()];
		msg1.getChars(0, 11, arr3, 0);
		for(int i = 0; i<arr3.length; i++) {
			System.out.print(arr3[i]+" ");
		}
		System.out.println();
		
		System.out.println(msg1.indexOf((int)'W'));
		System.out.println(msg1.indexOf("W"));
		System.out.println(msg1.indexOf('W'));
		
		System.out.println();
		System.out.println(11);
		System.out.println(3.14);
		System.out.println(true);
		System.out.println("test");
		System.out.println(msg1.length());
		System.out.println(msg1.replace('H', 'h'));
		System.out.println(msg1.replace("Hello", "HELLO"));
		//일부뽑아내기
		System.out.println(msg1.substring(6));
		System.out.println(msg1.substring(6,9));
		System.out.println(msg1.substring(0,5));
		System.out.println(msg1.substring(6,7));
		System.out.println(msg1.toUpperCase());
		System.out.println(msg1.toLowerCase());
	}

}
