package com.pm;

import java.util.Scanner;

public class Ex08 {

	public static void main(String[] args) {
		String title="학생성적관리프로그램(ver 0.3.0)";
		String menu="1.입력 2.출력 0.종료> ";
		String table="-------------------------------------------\r\n" + 
				"학번	|국어	|영어	|수학	|합계	|평균\r\n" + 
				"-------------------------------------------";
		Scanner sc = new Scanner(System.in);
		String input="";
		String data="";
		while(true) {
			System.out.print(menu);
			input=sc.nextLine();
			System.out.println(stringToInt(input)-1);
			if(true)break;
		}
		System.out.println("이용해주셔서 감사합니다");
	}
	
	public static int stringToInt(String msg) {
		int cnt=msg.length();
		int su=1,sum=0;
		while(true) {
			sum+=(msg.charAt(cnt---1)-'0')*su;
			su*=10;
			if(cnt==0)break;
		}
		return sum;
//		if(cnt==3) {
//			return (msg.charAt(0)-'0')*100
//					+(msg.charAt(1)-'0')*10
//					+(msg.charAt(2)-'0')*1;
//		}
//		if(cnt==2) {
//			return (msg.charAt(0)-'0')*10
//					+(msg.charAt(1)-'0')*1;
//		}
//		if(cnt==1) {
//			return (msg.charAt(0)-'0')*1;
//		}
//		
//		return 0;
	}

}
















