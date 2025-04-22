package com.pm;
// 알수록 좋음
public class Ex05 {

	public static void main(String[] args) {
		String msg = "ABCD abcd ABCD abcd ABCD";
		String msg2 ="";
		
		System.out.println(msg.contains("BC"));
		System.out.println(msg.contains("BCd"));
		System.out.println(msg.hashCode());
		System.out.println(msg2.hashCode());
		System.out.println(msg2==msg);
		
		
		System.out.println(msg.isEmpty());
		System.out.println(msg2.isEmpty());
		System.out.println(msg2.length()==0);
		System.out.println(msg2.length()!=0);
		
		System.out.println(msg.indexOf("BC"));
		System.out.println(msg.lastIndexOf("BC"));
		System.out.println(msg.indexOf("BC",5));
		System.out.println(msg.lastIndexOf("BC",20));
		System.out.println(msg.indexOf("Z"));
		System.out.println(msg.subSequence(5, 9));
		
		//다 스트링으로 만들어주는..
		String result = String.valueOf(new char[] {'a','b','c'});
		System.out.println(result);

	}

}
