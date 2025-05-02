package com.pm;

import java.util.*;

class Stu{
	int id;
	int kor;
	int eng;
	int math;
}

public class Ex07 {

	public static void main(String[] args) {
		//학생성적관리프로그램(ver 0.12.0) -use map
		System.out.println("학생성적관리프로그램(ver 0.11.0)");
		Scanner sc = new Scanner(System.in);
		boolean boo = true;
		while (boo) {
			System.out.print("1.보기 2.입력 3.수정 4.삭제 0.종료> ");
			int input = sc.nextInt();
			switch(input) {
			case 0:
				System.out.println("프로그램이 종료됩니다. 이용해주셔서 감사합니다.");
				boo=false;
				sc.close();
				break;
			case 1://보기
				System.out.println("-------------------------------");
				System.out.println("학번\t국어\t영어\t수학");
				System.out.println("-------------------------------");
				
				
				
				break;
			case 2: //입력
//				System.out.print(arr[0] + "> ");
//				int num = sc.nextInt();
//				if(){
//				}else
//				Stu stu = new Stu();
//				stu.num = num;
//				System.out.println(arr[1] + "> ");
				
				
				break;
			case 3:
				
				
				break;
			case 4:
				
				
				break;
			default:
				System.out.println("입력값 오류, 다시 입력하세요.");
			}
		}
	}

}
