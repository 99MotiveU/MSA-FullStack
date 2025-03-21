package com.pm;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Ex06t {

	public static void main(String[] args) {
		// 100일 계산 프로그램
		// 날짜를 입력받고 100일을 알려주는 프로그램
		Scanner sc=new Scanner(System.in);
//		System.out.print("년>");
//		int y=sc.nextInt();
//		System.out.print("월>");
//		int m=sc.nextInt();
//		System.out.print("일>");
//		int d=sc.nextInt();
		System.out.print("년.월.일>");
		String input=sc.nextLine();
//		input=input.replace(".", "");
		String[] arr=input.split("\\.");
		int y=Integer.parseInt(arr[0]);
		int m=Integer.parseInt(arr[1]);
		int d=Integer.parseInt(arr[2]);
		
//		GregorianCalendar gc=new GregorianCalendar(y,m-1,d);
//		gc.add(GregorianCalendar.DATE, 100);
		
		Date date=new Date(y-1900,m-1,d);
//		long after=date.getTime()+100*24*60*60*1000;
		
//		date=new Date(date.getTime()+100*24*60*60*1000);
		date.setTime(System.currentTimeMillis()+100*24*60*60*1000L);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd");
//		String msg=sdf.format(gc.getTime());
		String msg=sdf.format(date);
		System.out.println(msg);

	}

}








