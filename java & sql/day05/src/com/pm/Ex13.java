package com.pm;

import java.util.Scanner;

public class Ex13 {

	public static void main(String[] args) {
		/*
		학생성적관리 프로그램(ver 0.1.0)
		학생성적을 입력받고 총점과 학점을 출력하시오
		
		과목은 총 3과목으로 국어 영어 수학
		각 과목의 만점은 100점
		
		합계와 평균을 구하되 평균은 소수 둘째자리 까지만 출력
		학점은 A부터 F까지
		A:90이상, B:80이상, C:70이상, D:60이상, F:50이상
		
		학생성적관리프로그램(ver 0.1.0)
		국어> 90
		영어> 78
		수학> 89
		--------------------------------
		국어 | 영어 | 수학 | 합계 | 평균 | 학점
		--------------------------------
		90  | 78 | 89 | 000 |00.00| B
		*/
		Scanner sc = new Scanner(System.in);

		System.out.println("학생성적관리 프로그램(ver 0.1.0)");
		int k=0,e=0, m=0, tot = k+e+m;
		double avg = tot/3.0; // double avg = tot*100/3/100.0;
		String grade = "A";
		
		System.out.print("국어> ");
		k = sc.nextInt();
		
		System.out.print("영어> ");
		e = sc.nextInt();
		
		System.out.print("수학> ");
		m = sc.nextInt();		
		//등급나누기  
//		if(avg>=90) {
//			grade="A";
//		}else if(avg>=80) {
//			grade="B";
//		}else if(avg>=70) {
//			grade="c";
//		}else if(avg>=60) {
//			grade="D";
//		}else if(avg<60) {
//			grade="F";
//		} if문 else if는 위의 조건이 false일때 내려오는 것 
		int scgrade = (int)avg;
		switch(scgrade/10){
			case 10:
			case 9: grade="A"; break;
			case 8: grade="B"; break;
			case 7: grade="C"; break;
			case 6: grade="D"; break;
			default: grade="F";break;
		} //switch-case문
		System.out.println("-------------------------------------------------------------------------------------------------");
		System.out.println("|\t국어\t|\t영어\t|\t수학\t|\t합계\t|\t평균\t|\t학점\t|");
		System.out.println("-------------------------------------------------------------------------------------------------");
		System.out.println(String.format("|\t%d\t|\t%d\t|\t%d\t|\t%d\t|\t%.2f\t|\t%s\t|",k,e,m,tot,avg,grade));
	
	sc.close();
	}

}
