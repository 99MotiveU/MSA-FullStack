package com.pm;

public class Ex13 {

	public static void main(String[] args) {
		// string 기능을 수행하면 새로운 객체 반환
		// buffer builder 자기자신이 바뀜
		String msg1 = "java";
		String msg2 = new String("java");
		StringBuffer sb1 = new StringBuffer("java");
		StringBuilder sb2 = new StringBuilder("java");
//		StringBuffer sb3 = "java"; 
		System.out.println(sb1 + "Web");
//		StringBuffer sb3 = sb1+"Web"; 참조변수의 +기호는 string에서만 가능
		String msg3 = sb1 + "Web";

		StringBuffer sb3 = sb1.append("Web");
//		System.out.println(sb3);
		System.out.println(sb1);
		StringBuffer sb4 = sb3.append("Spring");
//		System.out.println(sb4);
		System.out.println(sb1);
		System.out.println(sb1.append("DB"));
		System.out.println(sb1.append("Database"));

		System.out.println("시작");
		for (int i = 0; i < 1000; i++) {
			sb1.append(i);
		}
		System.out.println("끝");
		System.out.println(sb1);
	}

}
