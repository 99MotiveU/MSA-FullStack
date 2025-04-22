package com.pm;

public class Ex07 {

	public static void main(String[] args) {
		String msg = "java\\db|web|framework";
//		msg="java@db@web@framework";
		
		
		String[] arr1 = msg.split("\\\\"); //자르기 , 띄어쓰기. 특정 문자로도 자르기 가능 
		for(int i =0; i< arr1.length;i++) {
			System.out.println(arr1[i]);
		}

	}

}
