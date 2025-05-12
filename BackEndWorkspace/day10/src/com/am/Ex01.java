package com.am;

import java.util.Scanner;

class Student {
	static int id;
	int kor;
	int eng;
	int math;
	int total;
	double avg;

//생성자
	public Student(int id, int kor, int eng, int math) {
		this.id = id;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		total();
		avg();
	}
	
	public int getId() {return id;}
	public int getKorean() {return kor;}
	public int getEnglish() {return eng;}
	public int getMath() {return math;}
	public int getTotal() {return total;}
	public double getavg() {return avg;}
	public void total() {
		this.total = kor + eng + math;
	}
	public void avg() {
		this.avg = Math.round(total / 3.0 * 100) / 100.0;
	}
	
	public String toString() {
		return id + "\t|" + kor + "\t|" + eng + "\t|" + math + "\t|" + total + "\t|" + avg + "\t\r\n";
	}
	//성적 수정 메서드
	public void updateScore(int kor, int eng, int math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		total();
		avg();
	}
}//student end

public class Ex01 {
	public static void main(String[] args) {
		/*
		 * 학생성적관리 프로그램(0.7.0) - 배열, string, 객체 1.보기 2.입력 3.수정 4.삭제 0.종료 무결성(0~100) 동적할당
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("학생 성적 관리 프로그램 ver 0.7.0");
		Student[] students = new Student[500]; // 학생 성적을 저장할 배열
		int studentCount = 0; // 학생수
		String menu = "1.입력 2.출력 3.수정 4.삭제 0.종료> ";
		boolean boo = true;
		while (boo) {
			int choice = -1;
			boolean validInput =false;
            while (!validInput) {
                System.out.print(menu);
                if (sc.hasNextInt()) {
                    choice = sc.nextInt();
                    if (choice >= 0 && choice <= 4) {
                        validInput = true; // 유효한 값이 입력되었으면 반복 종료
                    } else {
                        System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
                    }
                } else {
                    System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                    sc.next();
                }
            }
			switch (choice) {

			case 0:
				// 종료
				System.out.println("이용해주셔서 감사합니다\t프로그램을 종료합니다");
				boo = false;
				sc.close();
				break;
			case 1:
				// 보기
				System.out.print("국어> ");
				int kor = sc.nextInt();
				System.out.print("영어> ");
				int eng = sc.nextInt();
				System.out.print("수학> ");
				int math = sc.nextInt();

				if (kor > 100 || eng > 100 || math > 100) {
					System.out.println("점수를 잘못 입력하셨습니다. 메뉴로 돌아갑니다.");
				} else {
					Student newStudent = new Student(studentCount + 1, kor, eng, math);
					students[studentCount++] = newStudent; // 배열에 학생 정보 추가
					System.out.println("학생 성적이 입력되었습니다.");
				}
				System.out.println();
				break;
			case 2:
				// 입력
				System.out.println("학번\t|국어\t|영어\t|수학\t|합계\t|평균");
				System.out.println("----------------------------------------------------");
				for (int i = 0; i < studentCount; i++) {
					System.out.print(students[i]);
				}
				break;
			case 3:
				// 수정
				System.out.println("수정할 학생의 학번을 입력하세요.");
				
				System.out.print("국어> ");
				kor = sc.nextInt();
				System.out.print("영어> ");
				eng = sc.nextInt();
				System.out.print("수학> ");
				math = sc.nextInt();

				if (kor > 100 || eng > 100 || math > 100) {
					System.out.println("점수를 잘못 입력하셨습니다. 메뉴로 돌아갑니다.");
				} else {
					Student newStudent = new Student(studentCount + 1, kor, eng, math);
					students[studentCount++] = newStudent; // 배열에 학생 정보 추가
					System.out.println("학생 성적이 입력되었습니다.");
				}
				System.out.println();
				break;
			case 4:
				// 삭제
				break;
			default: 
				System.out.println("번호를 잘못 입력하셨습니다. 다시 입력하세요");
			}
		}
	}// main end
}// end
