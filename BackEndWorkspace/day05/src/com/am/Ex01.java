package com.am;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// Q01. ������ ���
		for (int i = 2; i < 10; i++) {
			System.out.print(i + "��\t\t"); //������ �ܼ� ����
		}
		System.out.println();
		for (int i = 1; i < 10; i++) {
			for (int j = 2; j < 10; j++) {
				int mul = j * i;
				System.out.print(j + " * " + i + " = " + mul+"\t");// j�� i�� �ٲ� �ܼ� ���·� ������ �ٲ�
			}
			System.out.println();// �� ���� ����� �ٹٲ�
		}
		System.out.println();// Q����
		
		// Q02. A
		// 		BC
		// 		DEF
		// 		GHIJ
		char ch = 'A';
		for (int i = 1; i < 5; i++) {
			for (int j = 0; j < 10; j++) {
				if (j >= i)
					System.out.print(" "); // j�� i ���� ũ�ų� ������ ����, j=0 ���� �����̹Ƿ� �ȶ��� A�� ����
				else {
					System.out.print((char) ch++); //A���� ���� ���� ���
				}
			}
			System.out.println();//�ٹٲ�
		}
		System.out.println();// Q����

		// Q03. ���� ���� �� ����(ver 0.1.0)
		System.out.println("---------------------------\n���� ���� �� ����ver 0.1.0\n---------------------------");
		// String menu = "����(1),����(2),��(3),����(0)> ";
		int wcount = 0, ccount = 0, lcount = 0;
		while (true) {
			System.out.print("����(1),����(2),��(3),����(0)> "); // menu
			int g = sc.nextInt();
			int c = (int) ((Math.random() * 3) + 1); // ���� 1,2,3 �̱�
			// ���(�Է�)
			if (g == 1) {
				System.out.println("����� ����");
			} else if (g == 2) {
				System.out.println("����� ����");
			} else if (g == 3) {
				System.out.println("����� ��");
			} else if (g == 0) { // 1,2,3 �̿ܿ��� ��� ����� ���� || switch-case+����ó���� �����ҵ�
				System.out.println("���� �·�");
				System.out.println(String.format("%d�� %d�� %d��", wcount, ccount, lcount));
				System.out.println("�̿��� �ּż� �����մϴ�.");
				break;
			} else {
				System.out.println("1,2,3,0 �̿��� ���ڸ� �Է��Ͽ� ���α׷��� ����˴ϴ�.");
				System.out.print("���� �·� : " + String.format("%d�� %d�� %d�� ", wcount, ccount, lcount));
				System.out.println("�̿��� �ּż� �����մϴ�.");
				break;
			}
			// ��ǻ��
			if (c == 1) {
				System.out.println("��ǻ�ʹ� ����");
			}
			if (c == 2) {
				System.out.println("��ǻ�ʹ� ����");
			}
			if (c == 3) {
				System.out.println("��ǻ�ʹ� ��");
			} 
				// ��
			if (g == 1 && c == 3 || g == 2 && c == 1 || g == 3 && c == 2) {
				System.out.println("�̰���ϴ�.");
				wcount++;
			} else if (g == 1 && c == 2 || g == 2 && c == 3 || g == 3 && c == 1) {
				System.out.println("�����ϴ�.");
				lcount++;
			} else {
				System.out.println("�����ϴ�.");
				ccount++;
			}
			System.out.println(); // ���� �ݺ� console ����
		}
		sc.close();

	}

}
