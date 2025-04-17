package com.pm;

import java.util.Scanner;

public class Ex02_2 {

    public static void main(String[] args) {
        // 학생성적관리프로그램(ver 0.5.0) -배열
        // 1.보기 2.입력 3.수정 4.삭제 0.종료 >
        // 수정할 학번>
        // 국어 >
        // ...
        // 삭제할 학번 >
        // 1.보기 2.입력 3.수정 4.삭제 0.종료 >

        Scanner sc = new Scanner(System.in);
        int input = 0, cnt = 1;
        String data = "";
        int total = 0;
        double avg = 0;
        int temp1 = 0, temp2 = 0, temp3 = 0;
        String menu = "1.입력 2.출력 3.수정 4.삭제 0.종료> ";
        String table = "-----------------------------------------------\r\n" + "학번	|국어	|영어	|수학	|합계	|평균\r\n"
                + "-----------------------------------------------";
        System.out.println("학생 성적 관리 프로그램 (ver 0.5.0)\t <정수만 입력하세요>");

        // 학생 성적 데이터를 저장할 배열을 생성 
        String[] studentData = new String[100000]; 

        while (true) {
            System.out.print(menu);
            int choice = sc.nextInt();

            if (choice == 1) {
                // 성적입력
                data = cnt++ + "\t|";  // 학번 추가

                System.out.print("국어> ");
                input = sc.nextInt();
                data += input + "\t|";
                temp1 = input;
                if (temp1 > 100) {
                    System.out.println("점수를 잘못 입력하셨습니다. 메뉴로 돌아갑니다.");
                } else {
                    System.out.print("영어> ");
                    input = sc.nextInt();
                    data += input + "\t|";
                    temp2 = input;
                    if (temp2 > 100) {
                        System.out.println("점수를 잘못 입력하셨습니다. 메뉴로 돌아갑니다.");
                    } else {
                        System.out.print("수학> ");
                        input = sc.nextInt();
                        data += input + "\t|";
                        temp3 = input;
                        if (temp3 > 100) {
                            System.out.println("점수를 잘못 입력하셨습니다. 메뉴로 돌아갑니다.");
                        } else {
                            total = temp1 + temp2 + temp3;
                            avg = total / 3.0;
                            avg = Math.round(avg * 100) / 100.0;
                            data += total + "\t|" + avg + "\t\r\n";
                            studentData[cnt - 2] = data;  // 배열에 성적 저장
                        }
                    }
                }

            }
            if (choice == 2) {
                // 성적 출력
                System.out.println(table);
                for (int i = 0; i < cnt - 1; i++) {
                    System.out.print(studentData[i]);
                }
                System.out.println();
            }

            if (choice == 3) {
                // 성적 수정
                System.out.print("수정할 학생의 학번 > ");
                int studentId = sc.nextInt();

                // 학번이 유효한지 확인
                if (studentId > 0 && studentId < cnt) {
                    System.out.println("학번 " + studentId + "의 성적을 수정합니다.");

                    // 기존 성적 출력
                    System.out.println("현재 성적: " + studentData[studentId - 1]);

                    // 수정할 성적 항목 입력
                    System.out.print("국어> ");
                    int newKorean = sc.nextInt();
                    System.out.print("영어> ");
                    int newEnglish = sc.nextInt();
                    System.out.print("수학> ");
                    int newMath = sc.nextInt();

                    // 점수 유효성 체크
                    if (newKorean > 100 || newEnglish > 100 || newMath > 100) {
                        System.out.println("점수를 잘못 입력하셨습니다. 메뉴로 돌아갑니다.");
                    } else {
                        // 총점과 평균 계산
                        total = newKorean + newEnglish + newMath;
                        avg = total / 3.0;
                        avg = Math.round(avg * 100) / 100.0;

                        // 수정된 성적 저장
                        studentData[studentId - 1] = studentId + "\t|" + newKorean + "\t|" + newEnglish + "\t|"
                                + newMath + "\t|" + total + "\t|" + avg + "\t\r\n";
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

                // 학번이 유효한지 확인
                if (deleteId > 0 && deleteId < cnt) {
                    // 삭제하려는 학생의 데이터를 null로 설정하여 삭제
                    studentData[deleteId - 1] = null;
                    System.out.println("학번 " + deleteId + "의 성적이 삭제되었습니다.");

                    // 삭제 후 배열을 재정렬 (삭제된 자리 뒤로 모든 데이터를 한 칸씩 이동)
                    for (int i = deleteId - 1; i < cnt - 1; i++) {
                        studentData[i] = studentData[i + 1];
                    }

                    // 마지막 학생 데이터를 null로 설정하여 관리
                    studentData[cnt - 2] = null;
                    cnt--;  // 학생 수 감소
                } else {
                    System.out.println("잘못된 학번입니다.");
                }
                System.out.println(); // 반복구분
            }

            if (choice == 0) {
                // 종료
                System.out.println("프로그램을 종료합니다.\n이용해주셔서 감사합니다.");
                sc.close();
                break;
            }
        }
    }
}
