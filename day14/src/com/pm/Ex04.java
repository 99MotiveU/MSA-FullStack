package com.pm;

import java.text.DateFormat;
import java.util.Date;

public class Ex04 {
	public static void main(String[] args) {
		Date d = new Date();
		System.out.println(d.toString());
//		System.out.println(d.toLocaleString());
		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
		String msg = df.format(d);
		System.out.println(msg);
	}
}
