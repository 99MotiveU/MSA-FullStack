package com.pm;

import java.util.Scanner;

public class Ex02_2 {

	public static void main(String[] args) {
		// �л������������α׷�(ver 0.5.0) -�迭
		// 1.���� 2.�Է� 3.���� 4.���� 0.���� >
		// ������ �й�>
		// ���� >
		// ...
		// ������ �й� >
		// 1.���� 2.�Է� 3.���� 4.���� 0.���� >

		Scanner sc = new Scanner(System.in);
		int input =0,cnt = 1;
		String data = "";
		int total = 0;
		double avg =0;
		String menu = "1.�Է� 2.��� 3.���� 4.���� 0.����> ";
		String table = "-----------------------------------------------\r\n" + "�й�	|����	|����	|����	|�հ�	|���\r\n"
				+ "-----------------------------------------------";
		System.out.println("�л� ���� ���� ���α׷� (ver 0.5.0)");
		while (true) {
			System.out.print(menu);
			int choice = sc.nextInt();
			
			if(choice==1){
				// �����Է�
				data += cnt++ + "\t|";
				System.out.print("����> ");
				input = sc.nextInt();
				data += input + "\t|";
				int temp1 = input;
				System.out.print("����> ");
				input = sc.nextInt();
				data += input + "\t|";
				int temp2 = input;
				System.out.print("����> ");
				input = sc.nextInt();
				data += input + "\t|";
				int temp3 = input;
				total=temp1+temp2+temp3;
				avg =total/3.0;
				avg =Math.round(avg*100)/100.0;
				data += total + "\t|"+ avg + "\t\r\n";
			}
			if(choice==2){
				// ���� ���
				System.out.println(table);
				System.out.println(data);	
			}

			if(choice==3) {
				//���� ����
				
			}
				
			if(choice==4) {
				//���� ����
				
			}
				
			if(choice==0){
				// ����
				System.out.println("���α׷��� �����մϴ�.\n�̿����ּż� �����մϴ�.");
				break;
			}
		}
	
	}
}
