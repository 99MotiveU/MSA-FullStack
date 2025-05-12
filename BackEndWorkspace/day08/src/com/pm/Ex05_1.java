package com.pm;

import java.util.Scanner;

public class Ex05_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*�л��������� ���α׷�(ver 0.2.0) -�迭
		 *�л��������� ���α׷�(ver 0.3.0) -���ڿ�
		 *
		 *3���� (����, ����, ����)
		 *�ѿ� > 3 (�Է¹ޱ�)
		 *1.�Է�  2.��� (3.���� 4.����) 0.���� > 1 (�Է¹ޱ�)
		 *����>
		 *����>
		 *����>
		 *1.�Է� 2.��� 0.���� > 2
		 *---------------------------------
		 *�й� | ���� | ���� | ���� | �հ�  | ��� |
		 *---------------------------------
		 *1	  | 90 | 91  | 92 | 000 | 00.00|
		 *1.�Է� 2.��� 0.���� > 1
		 *---------------------------------
		 *�й� | ���� | ���� | ���� | �հ�  | ��� |
		 *---------------------------------
		 *1	  | 90 | 91 | 92 | 000 | 00.00|
		 *
		 */
		//�迭-�л� ���� ���� ���α׷� ver 0.2.0
		System.out.println("�л� ���� ���� ���α׷� ver 0.2.0");
		System.out.print("�ѿ� > ");		
		
		// ���� �� ����
		final int sub = 3;

		// ���� ���� �ε���
		final int kor = 0;
		final int eng = 1;
		final int math = 2;
		//���л���
		int stc = sc.nextInt();
		// �л� ������ ������ �迭
		int[][] scores = new int[stc][sub];
		int[] totals = new int[stc];
		double[] avgs = new double[stc];
		while (true) {
			System.out.print("1.�Է� 2.��� 3.���� 4.���� 0.���� > ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				// ���� �Է�
				for (int i = 0; i < stc; i++) {
					System.out.println((i + 1) + "��° �л��� ������ �Է��ϼ���. ������ �Է°���");
					System.out.print("����: ");
					scores[i][kor] = sc.nextInt();
					if(scores[i][kor]>100) {
						System.out.println("������ �߸� �ԷµǾ����ϴ�.");
						break;
					}
				
					System.out.print("����: ");
					scores[i][eng] = sc.nextInt();
					if(scores[i][eng]>100) {
						System.out.println("������ �߸� �ԷµǾ����ϴ�.");
						break;
					}
				
					System.out.print("����: ");
					scores[i][math] = sc.nextInt();
					if(scores[i][kor]>100) {
						System.out.println("������ �߸� �ԷµǾ����ϴ�.");
						break;
					}
					
					System.out.println(); // �ݺ� ����
				}
				break;

			case 2:
				// ���� ���
				System.out.println("-------------------------------------------------");
				System.out.println("�й�\t| ����\t| ����\t| ����\t| �հ�\t| ���\t");
				

				for (int i = 0; i < stc; i++) {
					int total = scores[i][kor] + scores[i][eng] + scores[i][math];
					double avg = total / 3.0;

					totals[i] = total;
					avgs[i] = avg;
					
					System.out.println("-------------------------------------------------");
					System.out.println(String.format("%d\t| %d\t| %d\t| %d\t| %d\t| %.2f\t", i + 1, scores[i][kor],
							scores[i][eng], scores[i][math], totals[i], avgs[i]));
				}
				System.out.println("-------------------------------------------------");
				break;

			case 3:
				// ���� ����
				System.out.print("������ �л� ��ȣ�� �Է��ϼ��� (1~3): ");
				int stn = sc.nextInt() - 1;

				if (stn >= 0 && stn < stc) {
					System.out.println((stn + 1) + "��° �л��� ������ �����մϴ�.");

					System.out.print("����: ");
					scores[stn][kor] = sc.nextInt();

					System.out.print("����: ");
					scores[stn][eng] = sc.nextInt();

					System.out.print("����: ");
					scores[stn][math] = sc.nextInt();
				} else {
					System.out.println("�߸��� �л� ��ȣ�Դϴ�.");
				}
				break;

			case 4:
				// ���� ����
				System.out.print("������ �л� ��ȣ�� �Է��ϼ��� : ");
				stn = sc.nextInt() - 1;

				if (stn >= 0 && stn < stc) {
					scores[stn][kor] = 0;
					scores[stn][eng] = 0;
					scores[stn][math] = 0;
					totals[stn] = 0;
					avgs[stn] = 0.0;

					System.out.println((stn + 1) + "��° �л��� ������ �����Ǿ����ϴ�.");
				} else {
					System.out.println("�߸��� �л� ��ȣ�Դϴ�.");
				}
				break;	
				
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
