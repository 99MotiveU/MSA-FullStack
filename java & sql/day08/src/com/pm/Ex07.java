package com.pm;

import java.util.Scanner;

public class Ex07 {

	public static void main(String[] args) {
		String title="학생성적관리프로그램(ver 0.3.0)";
		String menu="1.입력 2.출력 0.종료> ";
		String table="-------------------------------------------\r\n" + 
				"학번	|국어	|영어	|수학	|합계	|평균\r\n" + 
				"-------------------------------------------";
		System.out.println(title);
		Scanner sc = new Scanner(System.in);
		int input=0,cnt=1;
		String data="";
		while(true) {
			System.out.print(menu);
			input=sc.nextInt();
			if(input==0)break;
			if(input==1) {
				data+=cnt+++"	|";
				System.out.print("국어> ");
				input=sc.nextInt();
				data+=input+"	|";
				System.out.print("영어> ");
				input=sc.nextInt();
				data+=input+"	|";
				System.out.print("수학> ");
				input=sc.nextInt();
				data+=input+"	\n";
			}
			if(input==2) {
				System.out.println(table);
				System.out.println(data);
			}
		}
		System.out.println("이용해주셔서 감사합니다");
	}

}










