package com.pm;

import java.util.Scanner;

public class Ex05_2 {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		//���ڿ�-�л� ���� ���� ���α׷� ver 0.3.0
		System.out.println("�л� ���� ���� ���α׷� ver 0.3.0");
		System.out.print("�ѿ� > ");		
		
		// ���� �� ����
		final int sub = 3;
		//���л� ��
		int stc =sc.nextInt();
		//���� �ε���
		final int kor = 0;
		final int eng = 1;
		final int math = 2;
		String[][] scores = new String[stc][sub];
		int [] totals = new int[stc];
		double[] avgs = new double[stc];
		
		while (true) {
			System.out.print("1.�Է� 2.��� 3.���� 4.���� 0.���� > ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				// ���� �Է�
				for (int i = 0; i < stc; i++) {
					System.out.println((i + 1) + "��° �л��� ������ �Է��ϼ���.");
					System.out.print("����: ");
					scores[i][kor] = sc.nextLine();
//					if(scores[i][kor]>100) {
//						System.out.println("������ �߸� �ԷµǾ����ϴ�.");
//						break;
//					}
				
					System.out.print("����: ");
					scores[i][eng] = sc.nextLine();
//					if(scores[i][eng]>100) {
//						System.out.println("������ �߸� �ԷµǾ����ϴ�.");
//						break;
//					}
				
					System.out.print("����: ");
					scores[i][math] = sc.nextLine();
//					if(scores[i][kor]>100) {
//						System.out.println("������ �߸� �ԷµǾ����ϴ�.");
//						break;
//					}
					
					System.out.println(); // �ݺ� ����
				}
				break;

			case 2:
				// ���� ���
				System.out.println("-------------------------------------------------");
				System.out.println("�й�\t| ����\t| ����\t| ����\t| �հ�\t| ���\t");
				

				for (int i = 0; i < stc; i++) {
					//int total = scores[i][kor] + scores[i][eng] + scores[i][math];
					//double avg = total / 3.0;

					//totals[i] = total;
					//avgs[i] = avg;
					
					System.out.println("-------------------------------------------------");
					System.out.println(String.format("%d\t| %d\t| %d\t| %d\t| %d\t| %.2f\t", i + 1, scores[i][kor],
							scores[i][eng], scores[i][math], totals[i], avgs[i]));
				}
				System.out.println("-------------------------------------------------");
				break;
				
			//case 3:
				
			//case 4:
				
			case 0:
				// ����
				System.out.println("���α׷��� �����մϴ�.");
				sc.close();
				return;
				
			default:
				System.out.println("�߸��� �Է��Դϴ�.");	
			}
		}
	}

}
