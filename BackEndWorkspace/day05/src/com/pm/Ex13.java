package com.pm;

import java.util.Scanner;

public class Ex13 {

	public static void main(String[] args) {
		/*
		�л��������� ���α׷�(ver 0.1.0)
		�л������� �Է¹ް� ������ ������ ����Ͻÿ�
		
		������ �� 3�������� ���� ���� ����
		�� ������ ������ 100��
		
		�հ�� ����� ���ϵ� ����� �Ҽ� ��°�ڸ� ������ ���
		������ A���� F����
		A:90�̻�, B:80�̻�, C:70�̻�, D:60�̻�, F:50�̻�
		
		�л������������α׷�(ver 0.1.0)
		����> 90
		����> 78
		����> 89
		--------------------------------
		���� | ���� | ���� | �հ� | ��� | ����
		--------------------------------
		90  | 78 | 89 | 000 |00.00| B
		*/
		Scanner sc = new Scanner(System.in);

		System.out.println("�л��������� ���α׷�(ver 0.1.0)");
		int k=0,e=0, m=0, tot = k+e+m;
		double avg = tot/3.0; // double avg = tot*100/3/100.0;
		String grade = "A";
		
		System.out.print("����> ");
		k = sc.nextInt();
		
		System.out.print("����> ");
		e = sc.nextInt();
		
		System.out.print("����> ");
		m = sc.nextInt();		
		//��޳�����  
//		if(avg>=90) {
//			grade="A";
//		}else if(avg>=80) {
//			grade="B";
//		}else if(avg>=70) {
//			grade="c";
//		}else if(avg>=60) {
//			grade="D";
//		}else if(avg<60) {
//			grade="F";
//		} if�� else if�� ���� ������ false�϶� �������� �� 
		int scgrade = (int)avg;
		switch(scgrade/10){
			case 10:
			case 9: grade="A"; break;
			case 8: grade="B"; break;
			case 7: grade="C"; break;
			case 6: grade="D"; break;
			default: grade="F";break;
		} //switch-case��
		System.out.println("-------------------------------------------------------------------------------------------------");
		System.out.println("|\t����\t|\t����\t|\t����\t|\t�հ�\t|\t���\t|\t����\t|");
		System.out.println("-------------------------------------------------------------------------------------------------");
		System.out.println(String.format("|\t%d\t|\t%d\t|\t%d\t|\t%d\t|\t%.2f\t|\t%s\t|",k,e,m,tot,avg,grade));
	
	sc.close();
	}

}
