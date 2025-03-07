package com.pm;

import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) {
		// Q1.	 *
		// 		**
		// 	   ***
		//    ****
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		// Q2. A
		//     BC
		//     DEF
		//     GHIJ
		
		
		
		// Q3. 1234
		//      567
		//       89
		//        0
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
		// 합계 4900
		// console bat문

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

		System.out.println("---------------------------");
		System.out.println("가위 바위 보 게임(ver 0.1.0)");
		System.out.println("---------------------------");
		String menu = "가위(1),바위(2),보(3),종료(0)>";
		// while(true) {
		while (true) {
			int count = 0;
			Scanner sc = new Scanner(System.in);
			String win = "이겼습니다.";
			String lose = "졌습니다.";
			int g = sc.nextInt();
			int c = (int) ((Math.random() * 3) + 1);
			//사람(입력)
			if (g == 1) {
				System.out.println("당신은 가위");
			} else if (g == 2) {
				System.out.println("당신은 바위");
			} else {
				System.out.println("당신은 보");
			}
			//컴퓨터
			if (c == 1) {
				System.out.println("컴퓨터는 가위");
			} else if (c == 2) {
				System.out.println("컴퓨터는 바위");
			} else {
				System.out.println("컴퓨터는 보");
			}
			//비교
			if (g == c) {
				System.out.println("비겼습니다.");	
			}else if(g==1&&c==2) {
				System.out.println(lose);
			}else if(g==1&&c==3) {
				System.out.println(win);
				break;
			}else if(g==2&&c==1) {
				System.out.println(win);
				break;
			}else if(g==2&&c==3) {
				System.out.println(lose);
			}else if(g==3&&c==1) {
				System.out.println(lose);
			}else {
				System.out.println(win);
				break;
			}
			//count++;
			
			sc.close();
		}
		

	}

}
