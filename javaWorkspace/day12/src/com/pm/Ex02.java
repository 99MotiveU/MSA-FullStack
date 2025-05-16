package com.pm;

import java.util.*;


public class Ex02 {

	public static void main(String[] args) {
		ArrayList list=new ArrayList(5);
//		LinkedList list=new LinkedList();
		System.out.println(list.isEmpty());
		list.add("첫번째");
		list.add("두번째");
		list.add("세번째");
		list.add("네번째");
		list.add("세번째");
		boolean boo = list.remove("세번째");
//		System.out.println(list.isEmpty());
//		System.out.println(list.indexOf("세번째"));
//		System.out.println(list.contains("세번째"));
//		java.util.Scanner sc=new java.util.Scanner(System.in);
//		System.out.println("세번째"==sc.nextLine());
//		System.out.println(list.contains(sc.nextLine()));// eq
//		list.set(2,"3번째");
		Object obj = list.remove(3);
//		list.add(1,"일과이사이");
//		list.clear();
		for(int i=0; i<list.size(); i++) {
			Object ele=list.get(i);
			System.out.println((String)ele);
		}

	}

}









