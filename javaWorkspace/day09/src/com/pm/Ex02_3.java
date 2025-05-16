package com.pm;

import java.util.Scanner;

// 학생 정보를 관리하는 클래스
class Student {
    private int id;  
    private int korean;  
    private int english;
    private int math; 
    private int total;  
    private double average;  

    // 생성자 : 학생 객체를 생성하고 성적을 초기화
    public Student(int id, int korean, int english, int math) {
        this.id = id;  // 
        this.korean = korean;  
        this.english = english;  
        this.math = math;  
        calculateTotalAndAverage();  // 총점과 평균 계산
    }

    // 각 필드에 대한 getter 메서드 (속성값 반환)
    public int getId() {return id;}

    public int getKorean() {return korean;}

    public int getEnglish() {return english;}

    public int getMath() {return math;}

    public int getTotal() {return total;}

    public double getAverage() {return average;}

    // 총점과 평균을 계산하는 메서드
    private void calculateTotalAndAverage() {
        this.total = korean + english + math;  
        this.average = total / 3.0; 
        this.average = Math.round(this.average * 100) / 100.0; 
    }

    @Override
    public String toString() { // 학생 정보 출력
        return id + "\t|" + korean + "\t|" + english + "\t|" + math + "\t|" + total + "\t|" + average + "\t\r\n";
    }

    // 성적 수정
    public void updateScores(int korean, int english, int math) {
        this.korean = korean; 
        this.english = english; 
        this.math = math;  
        calculateTotalAndAverage();  // 총점과 평균 다시 계산
    }
}

public class Ex02_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  
        System.out.println("학생 성적 관리 프로그램 ver 0.7.0");
        Student[] students = new Student[500];  // 학생 성적을 저장할 배열 
        int studentCount = 0;  //학생수
        String menu = "1.입력 2.출력 3.수정 4.삭제 0.종료> ";

        while (true) {
            System.out.print(menu); 
            int choice = sc.nextInt();  

            if (choice == 1) {
                // 성적 입력
                System.out.print("국어> ");
                int korean = sc.nextInt(); 
                System.out.print("영어> ");
                int english = sc.nextInt();  
                System.out.print("수학> ");
                int math = sc.nextInt(); 

                if (korean > 100 || english > 100 || math > 100) {
                    System.out.println("점수를 잘못 입력하셨습니다. 메뉴로 돌아갑니다.");
                } else {
                    // 새로운 학생 객체 생성 후 배열에 저장
                    Student newStudent = new Student(studentCount + 1, korean, english, math);
                    students[studentCount++] = newStudent;  // 배열에 학생 정보 추가
                    System.out.println("학생 성적이 입력되었습니다.");
                }
            } 

            if (choice == 2) {
                // 성적 출력
                System.out.println("학번\t|국어\t|영어\t|수학\t|합계\t|평균");
                System.out.println("----------------------------------------------------");
                for (int i = 0; i < studentCount; i++) {
                    System.out.print(students[i]); 
                }
            }

            if (choice == 3) {
                // 성적 수정
                System.out.print("수정할 학생의 학번 > ");
                int studentId = sc.nextInt();  
                
                if (studentId > 0 && studentId <= studentCount) {
                    // 학번에 해당하는 학생을 찾으면
                    Student student = students[studentId - 1];  // 학번에 해당하는 학생 객체 찾기
                    System.out.println(studentId + "번 학생의 성적을 수정합니다.");
                    System.out.println("\t학번\t|국어\t|영어\t|수학\t|합계\t|평균");
                    System.out.println("현재 성적: " + student); 

                    System.out.print("국어> ");
                    int newKorean = sc.nextInt();
                    System.out.print("영어> ");
                    int newEnglish = sc.nextInt();
                    System.out.print("수학> ");
                    int newMath = sc.nextInt();

                    if (newKorean > 100 || newEnglish > 100 || newMath > 100) {
                        System.out.println("점수를 잘못 입력하셨습니다. 메뉴로 돌아갑니다.");
                    } else {
                        // 성적 수정
                        student.updateScores(newKorean, newEnglish, newMath);
                        System.out.println("성적 수정이 완료되었습니다.");
                    }
                } else {
                    System.out.println("잘못된 학번입니다.");
                }
            }

            if (choice == 4) {
                // 성적 삭제
                System.out.print("삭제할 학생의 학번 > ");
                int deleteId = sc.nextInt(); 

                if (deleteId > 0 && deleteId <= studentCount) {
                    for (int i = deleteId - 1; i < studentCount - 1; i++) {
                        students[i] = students[i + 1];  // 삭제된 학생 뒤의 학생들을 한 칸씩 앞으로 이동
                    }
                    students[studentCount - 1] = null;  // 마지막 학생 데이터 null로 설정
                    studentCount--;  // 학생 수 감소
                    System.out.println("학번 " + deleteId + "의 성적이 삭제되었습니다.");
                } else {
                    System.out.println("잘못된 학번입니다.");
                }
            }

            if (choice == 0) {
                // 종료
                System.out.println("프로그램을 종료합니다.\n이용해주셔서 감사합니다.");
                sc.close();
                break; 
            }
        }
    } // main end
} // end
