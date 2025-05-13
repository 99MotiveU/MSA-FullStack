package com.pm;

import java.util.*;

class Student implements Comparable<Stu> {
	int id;
	int kor;
	int eng;
	int math;
	int tot = kor+eng+math;
	double avg = Math.round(tot/3.0*100)/100;
	
	@Override
	public int compareTo(Stu o) {
		return o.num -this.id;
	}
}

public class Ex08m {

	public static void main(String[] args) {
		// �л� �������� ���α׷� (ver 0.11.0)
		// SET  
		// �������� �й�
		// �ߺ����� - �й� - �����ϴ� �л��Դϴ�.
		String[] arr={"�й�","����","����","����","����","���"};
		Scanner sc = new Scanner(System.in);
		System.out.println("�л��������� ���α׷� (ver 0.11.0)");
		boolean boo = true;
		Set<Student> data=new TreeSet<>();//������ ����
		while (boo) {
			System.out.print("1.�Է� 2.���� 3.���� 4.���� 0.����> ");
			int choice = sc.nextInt();
			switch (choice) {	// CRUD
				case 0:		// 0.����
					System.out.println("�̿����ּż� �����մϴ�.\t ���α׷��� ����˴ϴ�.");
					boo = false;
					sc.close();
					break;
				case 1:		// 1.�Է�
					Student stu=new Student();
					System.out.print(arr[0]+"> ");
//					input=sc.nextInt();
//					stu.id=input;
					stu.id = sc.nextInt();
					System.out.print(arr[1]+"> ");
//					input=sc.nextInt();
//					stu.kor=input;
					stu.kor = sc.nextInt();
					System.out.print(arr[2]+"> ");
//					input=sc.nextInt();
//					stu.eng=input;
					stu.eng = sc.nextInt();
					System.out.print(arr[3]+"> ");
//					input=sc.nextInt();
//					stu.math=input;
					stu.math = sc.nextInt();
					stu.tot = stu.kor+stu.eng+stu.math;
					stu.avg = Math.round(stu.tot/3.0*100)/100;
					
					break;
				case 2:		// 2.����
					System.out.println("-------------------------------");
					System.out.println("�й�\t����\t����\t����\t����\t���");
					System.out.println("-------------------------------");
					Iterator<Student> ite = data.iterator();
					while(ite.hasNext()) {
//						Student stu = ite.next();
//						System.out.print(stu.id + "\t");
//						System.out.println(stu.kor + "\t");
//						System.out.println(stu.eng + "\t");
//						System.out.println(stu.math+ "\t");
//						System.out.println(stu.tot+ "\t");
//						System.out.println(stu.avg+"\t");
					}
					break;
				case 3:		// 3.����
				
					break;
				case 4:		// 4.����
				
					break;
				default:	// �̿� �Է� ó��
					System.out.println("�Է��� �߸��Ǿ����ϴ�.");
					
			}//switch end

		}//while end

	}//main end

}//end
