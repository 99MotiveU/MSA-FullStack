package com.pm;

import java.util.*;

class Stu implements Comparable<Stu> {
	int num;
	int kor;
	int eng;
	int math;

	@Override
	public int compareTo(Stu ord) {
		return ord.num - this.num; // �й� �������� ����
	}
}

public class Ex08t {

	public static void main(String[] args) {
		String[] arr = { "�й�", "����", "����", "����" };
		System.out.println("�л������������α׷�(ver 0.11.0)");
		Scanner sc = new Scanner(System.in);
		Set<Stu> data = new TreeSet<>();

		while (true) {
			System.out.print("1.���� 2.�Է� 3.���� 4.���� 0.����> ");
			int input = sc.nextInt();

			if (input == 0)
				break;

			if (input == 1) { // ����
				System.out.println("-------------------------------");
				System.out.println("�й�\t����\t����\t����");
				System.out.println("-------------------------------");
				Iterator<Stu> ite = data.iterator();
				while (ite.hasNext()) {
					Stu stu = ite.next();
					System.out.println(stu.num + "\t" + stu.kor + "\t" + stu.eng + "\t" + stu.math);
				}
			} else if (input == 2) { // �Է�
				Stu stu = new Stu();
				System.out.print(arr[0] + "> ");
				stu.num = sc.nextInt();

				boolean exists = false;
				Iterator<Stu> ite = data.iterator();
				while (ite.hasNext()) {
					if (ite.next().num == stu.num) {
						exists = true;
						break;
					}
				}

				if (exists) {
					System.out.println("�����ϴ� �л��Դϴ�.");
				} else {
					System.out.print(arr[1] + "> ");
					stu.kor = sc.nextInt();
					System.out.print(arr[2] + "> ");
					stu.eng = sc.nextInt();
					System.out.print(arr[3] + "> ");
					stu.math = sc.nextInt();
					data.add(stu);
				}
			} else if (input == 3) { // ����
				System.out.print("������ �й� �Է�> ");
				int num = sc.nextInt();

				Iterator<Stu> ite = data.iterator();
				while (ite.hasNext()) {
					Stu stu = ite.next();
					if (stu.num == num) {
						System.out.print(arr[1] + "> ");
						stu.kor = sc.nextInt();
						System.out.print(arr[2] + "> ");
						stu.eng = sc.nextInt();
						System.out.print(arr[3] + "> ");
						stu.math = sc.nextInt();
						System.out.println("���� �Ϸ�.");
						break;
					}
				}
			} else if (input == 4) { // ����
				System.out.print("������ �й� �Է�> ");
				int num = sc.nextInt();

				Iterator<Stu> ite = data.iterator();
				while (ite.hasNext()) {
					if (ite.next().num == num) {
						ite.remove();
						System.out.println("���� �Ϸ�.");
						break;
					}
				}
			} else {
				System.out.println("�߸��� �Է��Դϴ�.");
			}
		}
		sc.close();
	}
}
