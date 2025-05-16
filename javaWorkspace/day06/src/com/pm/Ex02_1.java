package com.pm;
// 기능을 메서드로 묶기
import java.util.Scanner;

public class Ex02_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
     
        String input;
        while (true) {
            System.out.print("주민번호를 입력> ");
            input = sc.nextLine();
            
            // 유효성 검사
            if (isValid(input)) {
                break;
            }
            System.out.println("입력포멧을 다시 확인하세요 (000000-0000000), 성별 코드는 1, 2, 3, 4만 가능합니다.");
        }

        // 성별 및 나이 계산 후 출력
        System.out.println(getAge(input) + "세 " + getGender(input) + "성입니다");
        sc.close();
    } //main end

    // 주민번호 유효성 검사
    private static boolean isValid(String input) {
        // 길이가 14자이고, '-'는 6번째 자리에 있어야 함
        if (input.length() != 14 || input.charAt(6) != '-') {
            return false;
        }

        // 숫자만 포함하고, 7번째 자리가 성별 코드(1, 2, 3, 4)여야 함
        for (int i = 0; i < input.length(); i++) {
            if (i != 6 && (input.charAt(i) < '0' || input.charAt(i) > '9')) {
                return false; // 숫자가 아니면 잘못된 입력
            }
        }

        // 7번째 자리가 성별 코드(1, 2, 3, 4)여야 함
        char genderChar = input.charAt(7);
        if (genderChar != '1' && genderChar != '2' && genderChar != '3' && genderChar != '4') {
            return false; // 성별 코드가 1, 2, 3, 4가 아니면 잘못된 입력
        }

        return true;
    } //isValid end

    // 성별 계산
    private static String getGender(String input) {
        return (input.charAt(7) == '1' || input.charAt(7) == '3') ? "남" : "여";
    }

    
    // 나이 계산
    private static int getAge(String input) {
        int year = 1900 + (input.charAt(0) - '0') * 10 + (input.charAt(1) - '0');
        if (input.charAt(7) == '3' || input.charAt(7) == '4') {
            year += 100;  // 2000년 이후 출생
        }
        return 2025 - year + 1;  // 기준 연도 (2025년) 나이 리턴
    }
}
