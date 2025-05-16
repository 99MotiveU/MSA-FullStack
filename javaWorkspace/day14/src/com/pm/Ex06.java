package com.pm;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Ex06 {

	public static void main(String[] args) {
		// 100일 계산 프로그램 날짜를 입력받고 100일을 알려주는 프로그램
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter dday = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		while (true) {
		System.out.println("날짜를 입력학세요  \t( ex]2025-03-21 ) 종료 : q ");
		System.out.print("> ");
		String input = sc.nextLine();
			if(input.equals("q")) {
				System.out.println("프로그램을 종료합니다. 이용해주셔서 감사합니다.");
				break;
			}
			try {
				LocalDate date = LocalDate.parse(input, dday);
				LocalDate bakDlater = date.plusDays(100);
				System.out.println("100일 후의 날짜 : " + bakDlater.format(dday));
				System.out.println();//반복 구분
			} catch (Exception e) {
				System.out.println("입력 양식을 확인후 다시 입력해 주세요.");
			}
		}
		sc.close();

	}

}
