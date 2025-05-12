package com.pm;

import java.util.Scanner;

class Student{
	int num;
	String name;
	int kor;
	int eng;
	int math;
	
	public Student(int num) {this.num=num;}
	public void setKor(String kor) {this.kor=Integer.parseInt(kor);}	
	public void setEng(String eng) {this.eng=Integer.parseInt(eng);}
	public void setMath(String math) {this.math=Integer.parseInt(math);}
	public int tot() {return kor+eng+math;}
	public double avg() {return tot()*100/3/100.0;}
}

public class Ex17 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�л��������� ���α׷�(ver 0.8.0)");
		String input = null;
		System.out.print("�ѿ�> ");
		Student[] data = new Student[Integer.parseInt(sc.nextLine())];
		int cnt = 0;
		while (true) {
			System.out.print("1.���� 2.�Է� 3.���� 4.���� 0.����> ");
			input = sc.nextLine();
			// ����
			if (input.equals("0")) {
				System.out.println("���α׷��� ����˴ϴ�.");
				break;
			}
			
			// ����
			if (input.equals("1")) {
				System.out.println("------------------------------------------------------");
				System.out.println("�й�\t�̸�\t����\t����\t����\t�հ�\t���\t");
				System.out.println("------------------------------------------------------");
				for (int i = 0; i < data.length; i++) {
					Student stu = data[i];
					System.out.println(stu.num + "\t" + stu.name + "\t" + stu.kor + "\t" + stu.eng + "\t" + stu.math
							+ "\t" + stu.tot() + "\t" + stu.avg() + "\t");
				}
			}

			// �Է�
			if (input.equals("2") && cnt < data.length) {
				Student stu = new Student(202500 + cnt);
				System.out.print("�̸�> ");
				stu.name = sc.nextLine();
				System.out.print("����> ");
				input = sc.nextLine();
				stu.setKor(input);
				System.out.print("����> ");
				input = sc.nextLine();
				stu.setEng(input);
				System.out.print("����> ");
				input = sc.nextLine();
				stu.setMath(input);
				data[cnt++] = stu;
			}
			// ����
			if (input.equals("3")) {
				System.out.print("������ ������ �л��� �й��� �Է��ϼ���> ");
				int stuid = Integer.parseInt(sc.nextLine());
				boolean found = false;
				for (int i = 0; i < cnt; i++) {
                    if (data[i].num == stuid) {
                        found = true;
                        Student stu = data[i];
                        System.out.print("����(����: " + stu.kor + "): ");
                        input = sc.nextLine();
                        stu.setKor(input);
                        System.out.print("����(����: " + stu.eng + "): ");
                        input = sc.nextLine();
                        stu.setEng(input);
                        System.out.print("����(����: " + stu.math + "): ");
                        input = sc.nextLine();
                        stu.setMath(input);
                        System.out.println("������ �����Ǿ����ϴ�.");
                        break;
                    }
                }
                if (!found) {
                    System.out.println("�ش� �й��� �л��� ã�� �� �����ϴ�.");
                }
            }
			// ����
			if (input.equals("4")) {
				System.out.print("������ ������ �л��� �й��� �Է��ϼ���> ");
				int delid = Integer.parseInt(sc.nextLine());
				boolean found = false;

				for (int i = 0; i < cnt; i++) {
					if (data[i].num == delid) {
						found = true;
						// �л� ���� �� �ڿ� �ִ� �л����� �� ĭ�� ������ �̵�
						for (int j = i; j < cnt - 1; j++) {
							data[j] = data[j + 1];
						}
						data[cnt - 1] = null; // ������ �л��� null�� ����
						cnt--; // �л� �� ����
						System.out.println("������ �����Ǿ����ϴ�.");
						break;
					}
				}
				if (!found) {
					System.out.println("�߸��� �й��Դϴ�.");
				}
			}
		}
	}// main end

}//end
