package com.pm;

public class Ex03 {

	public static void main(String[] args) {
		//Create Read Update Delete
		
		//create
		String msg="ABCDabcd1234";
		//read
		System.out.println(msg.length());
		System.out.println(msg.contains("bc"));
		System.out.println(msg.charAt(4));
		//update
		msg=msg.replace("abcd", "aBCd");
		System.out.println(msg);
		msg=msg.concat("!@#$");//add
		System.out.println(msg); 
		//delete
		msg=msg.replace("aBCd","a");
		System.out.println(msg);
		
		System.out.println(msg.contains("bc"));
	}

}
