package com.pm;

import java.util.Scanner;

public class Ex02_1 {

	public static void main(String[] args) {

		// 학생성적관리프로그램(ver 0.5.0) -배열
		// 1.보기 2.입력 3.수정 4.삭제 0.종료 >
		// 수정할 학번>
		// 국어 >
		// ...
		// 삭제할 학번 >
		// 1.보기 2.입력 3.수정 4.삭제 0.종료 >
		Scanner sc = new Scanner(System.in);
		System.out.println("학생 성적 관리 프로그램 ver 0.5.0");
		System.out.print("총원 > ");		
		
		// 과목 수 정의
		final int sub = 3;

		// 과목에 대한 인덱스
		final int kor = 0;
		final int eng = 1;
		final int math = 2;
		//총학생수
		int stc = sc.nextInt();
		// 학생 성적을 저장할 배열
		int[][] scores = new int[stc][sub];
		int[] totals = new int[stc];
		double[] avgs = new double[stc];
		while (true) {
			System.out.print("1.입력 2.출력 3.수정 4.삭제 0.종료 > ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				// 성적 입력
				for (int i = 0; i < stc; i++) {
					System.out.println((i + 1) + "번째 학생의 성적을 입력하세요. 정수만 입력가능");
					System.out.print("국어: ");
					scores[i][kor] = sc.nextInt();
					if(scores[i][kor]>100) {
						System.out.println("점수가 잘못 입력되었습니다.");
						break;
					}
				
					System.out.print("영어: ");
					scores[i][eng] = sc.nextInt();
					if(scores[i][eng]>100) {
						System.out.println("점수가 잘못 입력되었습니다.");
						break;
					}
				
					System.out.print("수학: ");
					scores[i][math] = sc.nextInt();
					if(scores[i][kor]>100) {
						System.out.println("점수가 잘못 입력되었습니다.");
						break;
					}
					
					System.out.println(); // 반복 구분
				}
				break;

			case 2:
				// 성적 출력
				System.out.println("-------------------------------------------------");
				System.out.println("학번\t| 국어\t| 영어\t| 수학\t| 합계\t| 평균\t");
				

				for (int i = 0; i < stc; i++) {
					int total = scores[i][kor] + scores[i][eng] + scores[i][math];
					double avg = total / 3.0;

					totals[i] = total;
					avgs[i] = avg;
					
					System.out.println("-------------------------------------------------");
					System.out.println(String.format("%d\t| %d\t| %d\t| %d\t| %d\t| %.2f\t", i + 1, scores[i][kor],
							scores[i][eng], scores[i][math], totals[i], avgs[i]));
				}
				System.out.println("-------------------------------------------------");
				break;

			case 3:
				// 성적 수정
				System.out.print("수정할 학생 번호를 입력하세요 (1~3): ");
				int stn = sc.nextInt() - 1;

				if (stn >= 0 && stn < stc) {
					System.out.println((stn + 1) + "번째 학생의 성적을 수정합니다.");

					System.out.print("국어: ");
					scores[stn][kor] = sc.nextInt();

					System.out.print("영어: ");
					scores[stn][eng] = sc.nextInt();

					System.out.print("수학: ");
					scores[stn][math] = sc.nextInt();
				} else {
					System.out.println("잘못된 학생 번호입니다.");
				}
				break;

			case 4:
				// 성적 삭제
				System.out.print("삭제할 학생 번호를 입력하세요 : ");
				stn = sc.nextInt() - 1;

				if (stn >= 0 && stn < stc) {
					scores[stn][kor] = 0;
					scores[stn][eng] = 0;
					scores[stn][math] = 0;
					totals[stn] = 0;
					avgs[stn] = 0.0;

					System.out.println((stn + 1) + "번째 학생의 성적이 삭제되었습니다.");
				} else {
					System.out.println("잘못된 학생 번호입니다.");
				}
				break;	
				
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
