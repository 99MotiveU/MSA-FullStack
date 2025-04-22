package com.pm;

import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Q1. *
		// **
		// ***
		// ****
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		// Q2. A
		// BC
		// DEF
		// GHIJ
		
		//*(char)(c); 이용 반복 1,2,3 비스 파생
		
		// Q3. 1234
		// 567
		// 89
		// 0
		int a = 1;
		for (int i = 4; i > 0; i--) {
			for (int j = 0; j < i; j++) {

				System.out.print(a);
				a++;
			}
			System.out.println();
		}
		System.out.println();
		// Q4. 실행파일을 만드세요
		// --------------------------
		// mas 영수증
		// --------------------------
		// 상품 단가 개수 금액
		// --------------------------
		// 지리산물 1000 1 1000
		// 자갈치 1200 2 2400
		// 사탕 500 3 1500
		// --------------------------
		// 				합계 4900
		// console bat문
		String ji = "지리산물";
		String ja = "자갈치";
		String can = "사탕";
		int rc = 1;
		int jc = 2;
		int cac = 3;
		int r=1000;//지리산물
		int j=1200;//자갈치
		int ca=500;//사탕
		int sum = rc*r+jc*j+cac*ca;
		System.out.println("--------------------------");
		System.out.println("mas 영수증");
		System.out.println("--------------------------");
		System.out.println("상품단가\t개수\t금액");
		System.out.println("--------------------------");
		System.out.println(ji +"\t"+rc+"\t"+r*rc);
		System.out.println(ja +"\t"+jc+"\t"+j*jc);
		System.out.println(can +"\t"+cac+"\t"+cac*ca);
		System.out.println("--------------------------");
		System.out.println("\t\t합계 : "+sum);
		
		System.out.println();
		// Q5.
		// ---------------------------
		// 가위 바위 보 게임(ver 0.1.0)
		// ---------------------------
		// 가위(1),바위(2),보(3),종료(0)>1
		// 당신은 가위
		// 컴퓨터는 바위
		// 졌습니다.

		// 가위(1),바위(2),보(3),종료(0)>1
		// 당신은 가위
		// 컴퓨터는 보
		// 이겼습니다.

		// 가위(1),바위(2),보(3),종료(0)>0
		// 누적 승률
		// 1승 0무 1패
		// 이용해 주셔서 감사합니다.
		System.out.println("---------------------------\n가위 바위 보 게임ver 0.1.0\n---------------------------");
		//String menu = "가위(1),바위(2),보(3),종료(0)> ";
		int wcount = 0, ccount = 0, lcount = 0;
		while (true) {
			System.out.print("가위(1),바위(2),보(3),종료(0)> "); //menu
			int g = sc.nextInt();
			int c = (int) ((Math.random() * 3) + 1); // 랜덤 1,2,3 뽑기
			// 사람(입력)
			if (g == 1) {
				System.out.println("당신은 가위");
			} else if (g == 2) {
				System.out.println("당신은 바위");
			} else if (g == 3) {
				System.out.println("당신은 보");
			} else if (g == 0){ // 1,2,3 이외에는 모두 종료로 설정 || switch-case+예외처리로 가능할듯
				System.out.println("누적 승률");
				System.out.println(String.format("%d승 %d무 %d패", wcount, ccount, lcount));
				System.out.println("이용해 주셔서 감사합니다.");
				break;
			} else {
				System.out.println("1,2,3,0 이외의 숫자를 입력하여 프로그램이 종료됩니다.");
				System.out.print("누적 승률 : "+ String.format("%d승 %d무 %d패 ", wcount, ccount, lcount));
				System.out.println("이용해 주셔서 감사합니다.");
				break;
			}
			// 컴퓨터
			if (c == 1) {
				System.out.println("컴퓨터는 가위");
			}
			if (c == 2) {
				System.out.println("컴퓨터는 바위");
			}
			if (c == 3) {
				System.out.println("컴퓨터는 보");
			} //switch-case로도 가능
			// 비교
			if (g == 1 && c == 3 || g == 2 && c == 1 || g == 3 && c == 2) {
				System.out.println("이겼습니다.");
				wcount++;
			} else if (g == 1 && c == 2 || g == 2 && c == 3 || g == 3 && c == 1) {
				System.out.println("졌습니다.");
				lcount++;
			} else {
				System.out.println("비겼습니다.");
				ccount++;
			}
			System.out.println(); // 다음 반복 console 구분용
		}
		sc.close();

	}

}
