package com.pm;

import java.util.Date;

public class Ex03 {

	public static void main(String[] args) {
		Date d1=new Date();
		System.out.println(d1);
		System.out.println(d1.getYear()+1900);
		System.out.println(d1.getMonth()+1);
		System.out.println(d1.getDate());
		System.out.println(d1.getDay());// 0~6
		System.out.println(d1.getHours());
		System.out.println(d1.getMinutes());
		System.out.println(d1.getSeconds());
		System.out.println(d1.getTime());
		System.out.println(System.currentTimeMillis());
		
		
	}

}








