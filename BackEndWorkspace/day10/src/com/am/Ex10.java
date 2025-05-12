package com.am;

public class Ex10 {

	public static void main(String[] args) {
		char c1 = 'a';
		Character ch2 = 'b';
		Character ch3 = new Character('c');
		Character ch4 = new Character((char)65);
		char[] arr1 = Character.toChars(123456);
		System.out.println(Integer.MAX_VALUE);
		System.out.println((int)Character.MAX_VALUE);
		for(int i=0; i<arr1.length;i++) {
			System.out.println(arr1[i]);
		}
		System.out.println(Character.toUpperCase('a'));
		System.out.println(Character.toLowerCase('A'));
				

	}

}
