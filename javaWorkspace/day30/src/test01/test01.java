/*
 * 학생성적관리프로그램(ver 0.20.0)
 * 학생인원 제한 없음
 * 과목은 국어, 영어, 수학, 3개 과목
 * 이들의 합계와 평균 그리고 랭크를 출력(내림차순) *
 * 학번은 20250001부터 자동 부여 *
 * 중복된 학번은 존재하지 않으며 
 * 목록_과목별 성적
 * 랭킹_합계 평균 순위 출력 *순위
 * 그외 제한 사항 없음
 * ex) 1.목록 2.랭킹 3.입력 4.수정 5.삭제 0.종료> 
 * 
 * 제출은 이메일로
 *  제목 : 1.자바_홍길동.java
 *  첨부 : 각메뉴별 실행결과 출력 이미지와 소스파일
 * */

package test01;

import java.util.*;

class Stu implements Comparable<Stu> {
	int num;
	int kor;
	int eng;
	int math;
	int tot;
	int avg;
	int rank;

	@Override
	public int compareTo(Stu ord) {
		return ord.num - this.num;
	}
}

public class test01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean boo = true;
		String[] arr = { "학번", "국어", "영어", "수학" };
		Set<Stu> data = new TreeSet<>();

		System.out.println("학생성적관리프로그램 (ver 0.20.0)");
		
		while (boo) {
			System.out.println();
			System.out.print("1.목록 2.랭킹 3.입력 4.수정 5.삭제 0.종료> ");
			
			String choice = sc.nextLine();

			if (choice.equals("0")) {// 종료
				System.out.println("프로그램을 종료합니다. \t 이용해 주셔서 감사합니다.");
				boo = false;
				break;
			}

			
			if (choice.equals("1")) {// 목록
				System.out.println("------------------------------------");
				System.out.println("학번\t국어\t영어\t수학");
				System.out.println("------------------------------------");
				Iterator<Stu> ite = data.iterator();
				while (ite.hasNext()) {
					Stu stu = ite.next();
					System.out.println(String.format("%d\t%d\t%d\t%d", stu.num, stu.kor, stu.eng, stu.math));
				}
			}

			
			if (choice.equals("2")) {// 랭킹
				System.out.println("------------------------------------");
				System.out.println("합계\t평균\t순위");
				System.out.println("------------------------------------");
				System.out.println();
				Iterator<Stu> ite = data.iterator();
				while(ite.hasNext()) {
					Stu stu = ite.next();
					System.out.println(String.format("%d\t%f\t%d", stu.tot, stu.avg, stu.rank));
				}
			}

			
			if (choice.equals("3")) { // 입력
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
					stu.tot = stu.kor+stu.eng+stu.math;
					stu.avg = stu.tot/3;
					data.add(stu);
					System.out.println("입력완료");
				}
			}
			

			if (choice.equals("4")) { // 수정
				System.out.print("수정할 학생의 학번 입력> ");
				int num = sc.nextInt();

				Iterator<Stu> ite = data.iterator();
				while (ite.hasNext()) {
					Stu stu = ite.next();
					if (stu.num == num) {
						System.out.println(arr[1] + "> ");
						stu.kor = sc.nextInt();
						System.out.println(arr[2] + "> ");
						stu.eng = sc.nextInt();
						System.out.println(arr[3] + "> ");
						stu.math = sc.nextInt();
						System.out.println("수정 완료.");
						break;
					}
				}
			}
			

			if (choice.equals("5")) { // 삭제
				System.out.print("삭제할 학생의 학번 입력> ");
				int num = sc.nextInt();

				Iterator<Stu> ite = data.iterator();
				while (ite.hasNext()) {
					if (ite.next().num == num) {
						ite.remove();
						System.out.println("삭제 완료.");
						break;
					}
				}
			}
			
			
		}
	}

}
