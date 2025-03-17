package com.pm;

import java.util.Scanner;

class Student{
	int num;
	String name;
	int kor;
	int eng;
	int math;
	
	public Student(int num) {this.num=num;}
	public void setKor(String kor) {this.kor=Integer.parseInt(kor);}	
	public void seteng(String eng) {this.eng=Integer.parseInt(eng);}
	public void setmath(String math) {this.math=Integer.parseInt(math);}
	public int tot() {return kor+eng+math;}
	public double avg() {return tot()*100/3/100.0;}
}

public class Ex17 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("학생성적관리 프로그램(ver 0.8.0)");
		String input = null;
		System.out.print("총원> ");
		Student[] data = new Student[Integer.parseInt(sc.nextLine())];
		int cnt = 0;
		while (true) {
			System.out.print("1.보기 2.입력 3.수정 4.삭제 0.종료> ");
			input = sc.nextLine();
			// 종료
			if (input.equals("0")) {
				System.out.println("프로그램이 종료됩니다.");
				break;
			}

			// 보기
			if (input.equals("1")) {
				System.out.println("------------------------------------------------------");
				System.out.println("학번\t이름\t국어\t영어\t수학\t합계\t평균\t");
				System.out.println("------------------------------------------------------");
				for (int i = 0; i < data.length; i++) {
					Student stu = data[i];
					System.out.println(stu.num + "\t" + stu.name + "\t" + stu.kor + "\t" + stu.eng + "\t" + stu.math
							+ "\t" + stu.tot() + "\t" + stu.avg() + "\t");
				}
			}

			// 입력
			if (input.equals("2") && cnt < data.length) {
				Student stu = new Student(202500 + cnt);
				System.out.print("이름> ");
				stu.name = sc.nextLine();
				System.out.print("국어> ");
				input = sc.nextLine();
				stu.setKor(input);
				System.out.print("영어> ");
				input = sc.nextLine();
				stu.seteng(input);
				System.out.print("수학> ");
				input = sc.nextLine();
				stu.setmath(input);
				data[cnt++] = stu;
			}
			// 수정
			if (input.equals("3")) {
				System.out.print("성적을 수정할 학생의 학번을 입력하세요> ");
				
				System.out.println("성적이 수정되었습니다.");
				
				
				
				
				
			}
			// 삭제
			if (input.equals("4")) {
				System.out.print("성적을 삭제할 학생의 학번을 입력하세요> ");
				int delid = sc.nextInt();
				if (delid > 0 && delid <= cnt) {
					for (int i = delid - 1; i < cnt - 1; i++) {
						data[i] = data[i + 1];
					}
					data[cnt - 1] = null;
					cnt--;
					System.out.println("성적이 삭제 되었습니다.");
				} else {
					System.out.println("잘못된 학번입니다.");
				}
			}

		}
	}//main end

}//end
