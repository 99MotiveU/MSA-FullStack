package com.pm;

import java.util.Calendar;

public class Ex01 {

	public static void main(String[] args) {
		
		Calendar cal2=Calendar.getInstance();
		
		Calendar cal = Calendar.getInstance();
		
		cal.set(Calendar.YEAR, 2002);
		cal.set(Calendar.MONTH, 4);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		
		long time1=cal2.getTimeInMillis();
		long time2=System.currentTimeMillis();
		System.out.println(time1);
		System.out.println(time2);
		cal.setTimeInMillis(time2);
		
		System.out.println(cal.get(Calendar.YEAR)+"년");//1
//		switch (cal.get(Calendar.MONTH)) {
//		case Calendar.JANUARY:// 0
//			System.out.println("1월");
//			break;
//		case Calendar.FEBRUARY:// 1
//			System.out.println("2월");
//		break;
//		case Calendar.MARCH:// 2
//			System.out.println("3월");
//		break;
//		case Calendar.APRIL:// 3
//			System.out.println("4월");
//		break;
//
//		default:
//			break;
//		}
		// 0~11
		System.out.println(cal.get(Calendar.MONTH)+1+"월");//2
		System.out.println(cal.get(Calendar.DAY_OF_MONTH)+"일");//2
		System.out.println(cal.get(Calendar.DATE)+"일"); //5
//		System.out.println(cal.get(Calendar.AM_PM)); //5
//		System.out.println(cal.get(Calendar.AM_PM)==Calendar.AM); //5
//		System.out.println(cal.get(Calendar.AM_PM)==Calendar.PM); //5
//		System.out.println(cal.get(Calendar.HOUR)+"시"); //10
		System.out.println(cal.get(Calendar.HOUR_OF_DAY)+"시");
		System.out.println(cal.get(Calendar.MINUTE)+"분"); //12
		System.out.println(cal.get(Calendar.SECOND)+"초"); //13
		System.out.println("-----------------------------------");
		System.out.println("365일 중 "+cal.get(Calendar.DAY_OF_YEAR)+"일"); //13
		System.out.println("일년 중"+cal.get(Calendar.WEEK_OF_YEAR)+"주차"); //13
		System.out.println(""+cal.get(Calendar.WEEK_OF_MONTH)+"주차"); //13
		System.out.println("-----------------------------------");
		// 1~7
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		System.out.println(Calendar.SUNDAY);
//		System.out.println(Calendar.FRIDAY);
//		System.out.println(Calendar.FRIDAY);
		System.out.println("-----------------------------------");
		System.out.println(cal.after(cal2));
		System.out.println(cal.before(cal2));
		System.out.println("-----------------------------------");
		
	}

}














