package com.pm;

import java.util.*;

class Stu{
	int id;
	int kor;
	int eng;
	int math;
}

public class Ex07 {

	public static void main(String[] args) {
		//�л������������α׷�(ver 0.12.0) -use map
		System.out.println("�л������������α׷�(ver 0.11.0)");
		Scanner sc = new Scanner(System.in);
		boolean boo = true;
		while (boo) {
			System.out.print("1.���� 2.�Է� 3.���� 4.���� 0.����> ");
			int input = sc.nextInt();
			switch(input) {
			case 0:
				System.out.println("���α׷��� ����˴ϴ�. �̿����ּż� �����մϴ�.");
				boo=false;
				sc.close();
				break;
			case 1://����
				System.out.println("-------------------------------");
				System.out.println("�й�\t����\t����\t����");
				System.out.println("-------------------------------");
				
				
				
				break;
			case 2: //�Է�
//				System.out.print(arr[0] + "> ");
//				int num = sc.nextInt();
//				if(){
//				}else
//				Stu stu = new Stu();
//				stu.num = num;
//				System.out.println(arr[1] + "> ");
				
				
				break;
			case 3:
				
				
				break;
			case 4:
				
				
				break;
			default:
				System.out.println("�Է°� ����, �ٽ� �Է��ϼ���.");
			}
		}
	}

}
