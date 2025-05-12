package com.pm;

import java.util.Scanner;

public class Ex05_2 {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		//문자열-학생 성적 관리 프로그램 ver 0.3.0
		System.out.println("학생 성적 관리 프로그램 ver 0.3.0");
		System.out.print("총원 > ");		
		
		// 과목 수 정의
		final int sub = 3;
		//총학생 수
		int stc =sc.nextInt();
		//과목 인덱스
		final int kor = 0;
		final int eng = 1;
		final int math = 2;
		String[][] scores = new String[stc][sub];
		int [] totals = new int[stc];
		double[] avgs = new double[stc];
		
		while (true) {
			System.out.print("1.입력 2.출력 3.수정 4.삭제 0.종료 > ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				// 성적 입력
				for (int i = 0; i < stc; i++) {
					System.out.println((i + 1) + "번째 학생의 성적을 입력하세요.");
					System.out.print("국어: ");
					scores[i][kor] = sc.nextLine();
//					if(scores[i][kor]>100) {
//						System.out.println("점수가 잘못 입력되었습니다.");
//						break;
//					}
				
					System.out.print("영어: ");
					scores[i][eng] = sc.nextLine();
//					if(scores[i][eng]>100) {
//						System.out.println("점수가 잘못 입력되었습니다.");
//						break;
//					}
				
					System.out.print("수학: ");
					scores[i][math] = sc.nextLine();
//					if(scores[i][kor]>100) {
//						System.out.println("점수가 잘못 입력되었습니다.");
//						break;
//					}
					
					System.out.println(); // 반복 구분
				}
				break;

			case 2:
				// 성적 출력
				System.out.println("-------------------------------------------------");
				System.out.println("학번\t| 국어\t| 영어\t| 수학\t| 합계\t| 평균\t");
				

				for (int i = 0; i < stc; i++) {
					//int total = scores[i][kor] + scores[i][eng] + scores[i][math];
					//double avg = total / 3.0;

					//totals[i] = total;
					//avgs[i] = avg;
					
					System.out.println("-------------------------------------------------");
					System.out.println(String.format("%d\t| %d\t| %d\t| %d\t| %d\t| %.2f\t", i + 1, scores[i][kor],
							scores[i][eng], scores[i][math], totals[i], avgs[i]));
				}
				System.out.println("-------------------------------------------------");
				break;
				
			//case 3:
				
			//case 4:
				
			case 0:
				// 종료
				System.out.println("프로그램을 종료합니다.");
				sc.close();
				return;
				
			default:
				System.out.println("잘못된 입력입니다.");	
			}
		}
	}

}
