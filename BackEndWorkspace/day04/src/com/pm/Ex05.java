package com.pm;

import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Q1. *
		// **
		// ***
		// ****
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		// Q2. A
		// BC
		// DEF
		// GHIJ
		
		//*(char)(c); �̿� �ݺ� 1,2,3 �� �Ļ�
		
		// Q3. 1234
		// 567
		// 89
		// 0
		int a = 1;
		for (int i = 4; i > 0; i--) {
			for (int j = 0; j < i; j++) {

				System.out.print(a);
				a++;
			}
			System.out.println();
		}
		System.out.println();
		// Q4. ���������� ���弼��
		// --------------------------
		// mas ������
		// --------------------------
		// ��ǰ �ܰ� ���� �ݾ�
		// --------------------------
		// �����깰 1000 1 1000
		// �ڰ�ġ 1200 2 2400
		// ���� 500 3 1500
		// --------------------------
		// 				�հ� 4900
		// console bat��
		String ji = "�����깰";
		String ja = "�ڰ�ġ";
		String can = "����";
		int rc = 1;
		int jc = 2;
		int cac = 3;
		int r=1000;//�����깰
		int j=1200;//�ڰ�ġ
		int ca=500;//����
		int sum = rc*r+jc*j+cac*ca;
		System.out.println("--------------------------");
		System.out.println("mas ������");
		System.out.println("--------------------------");
		System.out.println("��ǰ�ܰ�\t����\t�ݾ�");
		System.out.println("--------------------------");
		System.out.println(ji +"\t"+rc+"\t"+r*rc);
		System.out.println(ja +"\t"+jc+"\t"+j*jc);
		System.out.println(can +"\t"+cac+"\t"+cac*ca);
		System.out.println("--------------------------");
		System.out.println("\t\t�հ� : "+sum);
		
		System.out.println();
		// Q5.
		// ---------------------------
		// ���� ���� �� ����(ver 0.1.0)
		// ---------------------------
		// ����(1),����(2),��(3),����(0)>1
		// ����� ����
		// ��ǻ�ʹ� ����
		// �����ϴ�.

		// ����(1),����(2),��(3),����(0)>1
		// ����� ����
		// ��ǻ�ʹ� ��
		// �̰���ϴ�.

		// ����(1),����(2),��(3),����(0)>0
		// ���� �·�
		// 1�� 0�� 1��
		// �̿��� �ּż� �����մϴ�.
		System.out.println("---------------------------\n���� ���� �� ����ver 0.1.0\n---------------------------");
		//String menu = "����(1),����(2),��(3),����(0)> ";
		int wcount = 0, ccount = 0, lcount = 0;
		while (true) {
			System.out.print("����(1),����(2),��(3),����(0)> "); //menu
			int g = sc.nextInt();
			int c = (int) ((Math.random() * 3) + 1); // ���� 1,2,3 �̱�
			// ���(�Է�)
			if (g == 1) {
				System.out.println("����� ����");
			} else if (g == 2) {
				System.out.println("����� ����");
			} else if (g == 3) {
				System.out.println("����� ��");
			} else if (g == 0){ // 1,2,3 �̿ܿ��� ��� ����� ���� || switch-case+����ó���� �����ҵ�
				System.out.println("���� �·�");
				System.out.println(String.format("%d�� %d�� %d��", wcount, ccount, lcount));
				System.out.println("�̿��� �ּż� �����մϴ�.");
				break;
			} else {
				System.out.println("1,2,3,0 �̿��� ���ڸ� �Է��Ͽ� ���α׷��� ����˴ϴ�.");
				System.out.print("���� �·� : "+ String.format("%d�� %d�� %d�� ", wcount, ccount, lcount));
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
			} //switch-case�ε� ����
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
			System.out.println(); // ���� �ݺ� console ���п�
		}
		sc.close();

	}

}
