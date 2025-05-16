package com.pm;

import java.util.*;

class Stu implements Comparable<Stu> {
	int num;
	int kor;
	int eng;
	int math;

	@Override
	public int compareTo(Stu ord) {
		return ord.num - this.num; // 학번 내림차순 정렬
	}
}

public class Ex08t {

	public static void main(String[] args) {
		String[] arr = { "학번", "국어", "영어", "수학" };
		System.out.println("학생성적관리프로그램(ver 0.11.0)");
		Scanner sc = new Scanner(System.in);
		Set<Stu> data = new TreeSet<>();

		while (true) {
			System.out.print("1.보기 2.입력 3.수정 4.삭제 0.종료> ");
			int input = sc.nextInt();

			if (input == 0)
				break;

			if (input == 1) { // 보기
				System.out.println("-------------------------------");
				System.out.println("학번\t국어\t영어\t수학");
				System.out.println("-------------------------------");
				Iterator<Stu> ite = data.iterator();
				while (ite.hasNext()) {
					Stu stu = ite.next();
					System.out.println(stu.num + "\t" + stu.kor + "\t" + stu.eng + "\t" + stu.math);
				}
			} else if (input == 2) { // 입력
				Stu stu = new Stu();
				System.out.print(arr[0] + "> ");
				stu.num = sc.nextInt();

				boolean exists = false;
				Iterator<Stu> ite = data.iterator();
				while (ite.hasNext()) {
					if (ite.next().num == stu.num) {
						exists = true;
						break;
					}
				}

				if (exists) {
					System.out.println("존재하는 학생입니다.");
				} else {
					System.out.print(arr[1] + "> ");
					stu.kor = sc.nextInt();
					System.out.print(arr[2] + "> ");
					stu.eng = sc.nextInt();
					System.out.print(arr[3] + "> ");
					stu.math = sc.nextInt();
					data.add(stu);
				}
			} else if (input == 3) { // 수정
				System.out.print("수정할 학번 입력> ");
				int num = sc.nextInt();

				Iterator<Stu> ite = data.iterator();
				while (ite.hasNext()) {
					Stu stu = ite.next();
					if (stu.num == num) {
						System.out.print(arr[1] + "> ");
						stu.kor = sc.nextInt();
						System.out.print(arr[2] + "> ");
						stu.eng = sc.nextInt();
						System.out.print(arr[3] + "> ");
						stu.math = sc.nextInt();
						System.out.println("수정 완료.");
						break;
					}
				}
			} else if (input == 4) { // 삭제
				System.out.print("삭제할 학번 입력> ");
				int num = sc.nextInt();

				Iterator<Stu> ite = data.iterator();
				while (ite.hasNext()) {
					if (ite.next().num == num) {
						ite.remove();
						System.out.println("삭제 완료.");
						break;
					}
				}
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		}
		sc.close();
	}
}
