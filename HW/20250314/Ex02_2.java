package com.pm;

import java.util.Scanner;

public class Ex02_2 {

	public static void main(String[] args) {
		// 학생성적관리프로그램(ver 0.5.0) -배열
		// 1.보기 2.입력 3.수정 4.삭제 0.종료 >
		// 수정할 학번>
		// 국어 >
		// ...
		// 삭제할 학번 >
		// 1.보기 2.입력 3.수정 4.삭제 0.종료 >

		Scanner sc = new Scanner(System.in);
		int input =0,cnt = 1;
		String data = "";
		int total = 0;
		double avg =0;
		String menu = "1.입력 2.출력 3.수정 4.삭제 0.종료> ";
		String table = "-----------------------------------------------\r\n" + "학번	|국어	|영어	|수학	|합계	|평균\r\n"
				+ "-----------------------------------------------";
		System.out.println("학생 성적 관리 프로그램 (ver 0.5.0)");
		while (true) {
			System.out.print(menu);
			int choice = sc.nextInt();
			
			if(choice==1){
				// 성적입력
				data += cnt++ + "\t|";
				System.out.print("국어> ");
				input = sc.nextInt();
				data += input + "\t|";
				int temp1 = input;
				System.out.print("영어> ");
				input = sc.nextInt();
				data += input + "\t|";
				int temp2 = input;
				System.out.print("수학> ");
				input = sc.nextInt();
				data += input + "\t|";
				int temp3 = input;
				total=temp1+temp2+temp3;
				avg =total/3.0;
				avg =Math.round(avg*100)/100.0;
				data += total + "\t|"+ avg + "\t\r\n";
			}
			if(choice==2){
				// 성적 출력
				System.out.println(table);
				System.out.println(data);	
			}

			if(choice==3) {
				//성적 수정
				
			}
				
			if(choice==4) {
				//성적 삭제
				
			}
				
			if(choice==0){
				// 종료
				System.out.println("프로그램을 종료합니다.\n이용해주셔서 감사합니다.");
				break;
			}
		}
	
	}
}
