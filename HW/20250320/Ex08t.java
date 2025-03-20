package com.pm;

import java.util.*;

class Stu implements Comparable<Stu> {
	int num;
	int kor;
	int eng;
	int math;

	@Override
	public int compareTo(Stu ord) {
		return ord.num - this.num; // 내림차순 정렬
	}
}

public class Ex08t {

	public static void main(String[] args) {
		// 학생성적관리프로그램(ver 0.11.0)
		// SET
		// 내림차순 학번
		// 중복불허 - 학번 - 존재하는 학생입니다
		String[] arr = { "학번", "국어", "영어", "수학" };
		System.out.println("학생성적관리프로그램(ver 0.11.0) ");
		Scanner sc = new Scanner(System.in);
		int input = -1;
		Set<Stu> data = new TreeSet<>();
		while (true) {
			System.out.print("1.보기 2.입력 0.종료> ");
			input = sc.nextInt();
			if (input == 0)
				break;
			if (input == 1) {
				System.out.println("-------------------------------");
				System.out.println("학번\t국어\t영어\t수학");
				System.out.println("-------------------------------");
				Iterator<Stu> ite = data.iterator();
				while (ite.hasNext()) {
					Stu stu = ite.next();
					System.out.print(stu.num + "\t");
					System.out.print(stu.kor + "\t");
					System.out.print(stu.eng + "\t");
					System.out.print(stu.math + "\n");
				}
			}
			if (input == 2) {
				Stu stu = new Stu();
				System.out.print(arr[0] + "> ");
				input = sc.nextInt();
				stu.num = input;
				System.out.print(arr[1] + "> ");
				input = sc.nextInt();
				stu.kor = input;
				System.out.print(arr[2] + "> ");
				input = sc.nextInt();
				stu.eng = input;
				System.out.print(arr[3] + "> ");
				input = sc.nextInt();
				stu.math = input;
				boolean result = data.add(stu);
				if (!result)
					System.out.println("중복");
			}
			if (input == 3) {
				// 수정
			}

			if (input == 4) {
				// 삭제
			}
		}
	}

}
