package com.pm;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Ex06 {

	public static void main(String[] args) {
		// 100�� ��� ���α׷� ��¥�� �Է¹ް� 100���� �˷��ִ� ���α׷�
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter dday = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		while (true) {
		System.out.println("��¥�� �Է��м���  \t( ex]2025-03-21 ) ���� : q ");
		System.out.print("> ");
		String input = sc.nextLine();
			if(input.equals("q")) {
				System.out.println("���α׷��� �����մϴ�. �̿����ּż� �����մϴ�.");
				break;
			}
			try {
				LocalDate date = LocalDate.parse(input, dday);
				LocalDate bakDlater = date.plusDays(100);
				System.out.println("100�� ���� ��¥ : " + bakDlater.format(dday));
				System.out.println();//�ݺ� ����
			} catch (Exception e) {
				System.out.println("�Է� ����� Ȯ���� �ٽ� �Է��� �ּ���.");
			}
		}
		sc.close();

	}

}
