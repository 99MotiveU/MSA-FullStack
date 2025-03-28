package com.pm;

import java.util.*;

class Student implements Comparable<Stu> {
	int id;
	int kor;
	int eng;
	int math;
	int tot = kor+eng+math;
	double avg = Math.round(tot/3.0*100)/100;
	
	@Override
	public int compareTo(Stu o) {
		return o.num -this.id;
	}
}

public class Ex08m {

	public static void main(String[] args) {
		// 학생 성적관리 프로그램 (ver 0.11.0)
		// SET  
		// 내림차순 학번
		// 중복불허 - 학번 - 존재하는 학생입니다.
		String[] arr={"학번","국어","영어","수학","총점","평균"};
		Scanner sc = new Scanner(System.in);
		System.out.println("학생성적관리 프로그램 (ver 0.11.0)");
		boolean boo = true;
		Set<Student> data=new TreeSet<>();//정렬을 위해
		while (boo) {
			System.out.print("1.입력 2.보기 3.수정 4.삭제 0.종료> ");
			int choice = sc.nextInt();
			switch (choice) {	// CRUD
				case 0:		// 0.종료
					System.out.println("이용해주셔서 감사합니다.\t 프로그램이 종료됩니다.");
					boo = false;
					sc.close();
					break;
				case 1:		// 1.입력
					Student stu=new Student();
					System.out.print(arr[0]+"> ");
//					input=sc.nextInt();
//					stu.id=input;
					stu.id = sc.nextInt();
					System.out.print(arr[1]+"> ");
//					input=sc.nextInt();
//					stu.kor=input;
					stu.kor = sc.nextInt();
					System.out.print(arr[2]+"> ");
//					input=sc.nextInt();
//					stu.eng=input;
					stu.eng = sc.nextInt();
					System.out.print(arr[3]+"> ");
//					input=sc.nextInt();
//					stu.math=input;
					stu.math = sc.nextInt();
					stu.tot = stu.kor+stu.eng+stu.math;
					stu.avg = Math.round(stu.tot/3.0*100)/100;
					
					break;
				case 2:		// 2.보기
					System.out.println("-------------------------------");
					System.out.println("학번\t국어\t영어\t수학\t총점\t평균");
					System.out.println("-------------------------------");
					Iterator<Student> ite = data.iterator();
					while(ite.hasNext()) {
						Student stu = ite.next();
						System.out.print(stu.id + "\t");
						System.out.println(stu.kor + "\t");
						System.out.println(stu.eng + "\t");
						System.out.println(stu.math+ "\t");
						System.out.println(stu.tot+ "\t");
						System.out.println(stu.avg+"\t");
					}
					break;
				case 3:		// 3.수정
				
					break;
				case 4:		// 4.삭제
				
					break;
				default:	// 이외 입력 처리
					System.out.println("입력이 잘못되었습니다.");
					
			}//switch end

		}//while end

	}//main end

}//end
