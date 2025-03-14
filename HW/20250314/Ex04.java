package com.pm;

import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		// 학생성적관리프로그램(ver 0.5.0)-배열
		// 학생성적관리프로그램(ver 0.6.0)-String
		// 학생성적관리프로그램(ver 0.7.0)-Student 객체
		// 1.보기 2.입력 3.수정 4.삭제 0.종료>
		// 수정할 학번>
		// 국어>
		// ...
		// 삭제할 학번>
		// 1.보기 2.입력 3.수정 4.삭제 0.종료>
		String title = "학생성적관리프로그램(ver 0.6.1)-String";
		String menu = "1.보기 2.입력 3.수정 4.삭제 0.종료> ";
		final String[] role = { "국어", "영어", "수학" };
		Scanner sc = new Scanner(System.in);
		String input = null;
		int cnt = 0;
		String data = "";
		System.out.println(title);
		while (true) {
			System.out.print(menu);
			input = sc.nextLine();
			if (input.equals("0"))
				break;
			if (input.equals("2")) {
				data += ++cnt;
				for (int i = 0; i < role.length; i++) {
					System.out.print(role[i] + "> ");
					data += "\t" + sc.nextLine();
				}
				data += "\n";
			}
			if (input.equals("1")) {
				System.out.println("-----------------------------------");
				System.out.println("학번\t국어\t영어\t수학");
				System.out.println("-----------------------------------");
				System.out.println(data);
			}
			if (input.equals("3")) {
			}
			if (input.equals("4")) {
				System.out.print("삭제할 학번> ");
				input = sc.nextLine();
				int begin = -1;
				int end = -1;
				if (data.startsWith(input + "\t")) {
					begin = -1;
				} else {
					begin = data.indexOf("\n" + input + "\t");
				}
				/////
				end = data.indexOf("\n", begin + 1);
				String target = data.substring(begin + 1, end + 1);
				data = data.replace(target, "");
			}

		}
		sc.close();
		System.out.println("이용해주셔서 감사합니다");
	}

}
