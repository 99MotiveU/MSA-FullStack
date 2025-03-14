package com.pm;

import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String title = "학생성적관리프로그램(ver 0.5.0)-배열";
		String menu = "1.보기 2.입력 3.수정 4.삭제 0.종료> ";
		final String[] role = { "국어", "영어", "수학" };
		int input = 0;
		int cnt = 0;
		System.out.println(title);
		System.out.print("총원> ");
		int tot = sc.nextInt();
		int[][] arr = new int[tot][];
		while (true) {
			System.out.print(menu);
			input = sc.nextInt();

			if (input == 0)
				break;
			if (input == 2 && tot > cnt) {
				int[] stu = new int[4];
				stu[0] = ++cnt;
				for (int i = 0; i < 3; i++) {
					System.out.print(role[i] + "> ");
					input = sc.nextInt();
					stu[i + 1] = input;
				}
				arr[cnt - 1] = stu;
			} else if (input == 2) {
				System.out.println("입력을 안받음");
			}
			if (input == 1) {
				System.out.println("-----------------------------------");
				System.out.println("학번\t국어\t영어\t수학");
				System.out.println("-----------------------------------");
				for (int i = 0; i < arr.length; i++) {
					int[] stu = arr[i];
					if (stu != null) {
						for (int j = 0; j < stu.length; j++) {
							if (j != 0)
								System.out.print("\t");
							System.out.print(stu[j]);
						}
						System.out.println();
					}
				}
			}
			if (input == 3) {
				System.out.print("수정할 학번> ");
				input = sc.nextInt();
				for (int i = 0; i < arr.length; i++) {
					int[] stu = arr[i];
					if (stu[0] == input) {
						int[] editStu = new int[4];
						editStu[0] = input;
						for (int j = 0; j < 3; j++) {
							System.out.print(role[j] + "> ");
							input = sc.nextInt();
							editStu[j + 1] = input;
						}
						arr[i] = editStu;
					}
				}
			}
			if (input == 4) {
				System.out.print("삭제할 학번> ");
				input = sc.nextInt();
				for (int i = 0; i < arr.length; i++) {
					int[] stu = arr[i];
					if (stu[0] == input) {
						arr[i] = null;
					}
				}
			}
		}
		System.out.println("이용해주셔서 감사합니다");
		sc.close();
	}

}
