package com.pm;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Ex02 {

	public static void main(String[] args) {
		GregorianCalendar cal=null;
		cal=new GregorianCalendar(2002,4,1,1,2,3);
		cal.add(Calendar.HOUR_OF_DAY, -23);
		System.out.println(cal.get(GregorianCalendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH)+1+"월");//2
		System.out.println(cal.get(Calendar.DAY_OF_MONTH)+"일");//2
		System.out.println(cal.get(Calendar.DATE)+"일"); //5
		System.out.println(cal.get(Calendar.HOUR_OF_DAY)+"시");
		System.out.println(cal.get(Calendar.MINUTE)+"분"); //12
		System.out.println(cal.get(Calendar.SECOND)+"초");
	}

}
 