package com.pm;

import java.util.Scanner;

public class Ex02 {

    public static void main(String[] args) {
        // 주민번호 체크기 (ver 0.1.0)
        // 주민번호를 입력받아 성별과 나이를 출력하는 프로그램
        
        char[] role= {'영','일','이','삼','사','오','육','칠','팔','구'};  // 숫자 대신 한글을 숫자로 변환하기 위한 배열
        char[] target=new char[10];  // 숫자 문자 배열 생성

        // 숫자 '0'부터 '9'까지 배열에 초기화
        for(int i=0; i<target.length; i++) {
            target[i]=(char)('0'+i);  // '0'부터 '9'까지의 숫자 문자를 target 배열에 넣음
        }

        Scanner sc = new Scanner(System.in);  // 사용자 입력을 받기 위한 스캐너 객체 생성
        char gender = '여';  // 기본 성별을 여성('여')로 설정
        int age = 0;  // 기본 나이를 0으로 설정
        boolean boo1 = true, boo2 = false;  // boo1은 반복문 제어, boo2는 입력 유효성 검사용 변수

        // 사용자로부터 유효한 주민번호를 입력받을 때까지 반복
        while (boo1) {
            boo2 = false;  // boo2 초기화 (유효성 검사)

            System.out.print("주민번호를 입력> ");
            String input = sc.nextLine();  // 사용자로부터 주민번호 입력 받음
            char[] arr1 = input.toCharArray();  // 입력을 문자 배열로 변환

            // 한글 숫자를 실제 숫자로 변환
            for (int i = 0; i < arr1.length; i++) {
                for (int j = 0; j < role.length; j++) {
                    if (arr1[i] == role[j]) {  // 한글 숫자에 해당하는 문자가 있으면
                        arr1[i] = target[j];  // 해당 문자를 숫자로 변경
                    }
                }
            }

            // 입력된 주민번호가 숫자만으로 이루어졌는지 확인
            for (int i = 0; i < arr1.length; i++) {
                if (i != 6 && (arr1[i] < '0' || arr1[i] > '9')) {  // '-'를 제외한 모든 문자가 숫자가 아닐 경우
                    boo2 = true;  // boo2를 true로 설정하여 유효하지 않음을 표시
                }
            }

            // 유효성 검사 (형식 오류 체크)
            if (arr1[6] != '-') {
                System.out.println("입력포멧을 다시 확인하세요 (000000-0000000)");  // '-'가 없으면 오류 메시지 출력
            } else if (arr1.length != 14) {
                System.out.println("입력포멧을 다시 확인하세요 (000000-0000000)");  // 입력 길이가 14자가 아니면 오류 메시지 출력
            } else if (boo2) {
                System.out.println("숫자만 입력하세요");  // 숫자가 아닌 값이 포함된 경우 오류 메시지 출력
            } else {
                // 성별 확인
                if (arr1[7] == '1' || arr1[7] == '3') {  // 주민번호 7번째 자리가 1 또는 3이면 남성
                    gender = '남';
                }
                if (arr1[7] == '2' || arr1[7] == '4') {  // 주민번호 7번째 자리가 2 또는 4이면 여성
                    gender = '여';
                }

                // 출생 연도 계산
                int year = 1900 + (arr1[0] - '0') * 10 + (arr1[1] - '0') * 1;  // 첫 두 자리에서 연도 계산
                if (arr1[7] == '3' || arr1[7] == '4') year += 100;  // 3, 4는 1900년대 생이 아니라 2000년대 생
                age = 2025 - year + 1;  // 나이 계산 (현재 2025년 기준)
                boo1 = false;  // 유효한 주민번호가 입력되었으므로 반복 종료
            }
        }
        
        // 최종 결과 출력
        System.out.println("당신은 " + age + "세 " + gender + "성입니다");
        sc.close();  // 스캐너 객체 종료
    }
}


















