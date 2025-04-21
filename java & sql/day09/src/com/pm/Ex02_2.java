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
        int input = 0, cnt = 1;
        String data = "";
        int total = 0;
        double avg = 0;
        int temp1 = 0, temp2 = 0, temp3 = 0;
        String menu = "1.�Է� 2.��� 3.���� 4.���� 0.����> ";
        String table = "-----------------------------------------------\r\n" + "�й�	|����	|����	|����	|�հ�	|���\r\n"
                + "-----------------------------------------------";
        System.out.println("�л� ���� ���� ���α׷� (ver 0.5.0)\t <������ �Է��ϼ���>");

        // �л� ���� �����͸� ������ �迭�� ���� 
        String[] studentData = new String[100000]; 

        while (true) {
            System.out.print(menu);
            int choice = sc.nextInt();

            if (choice == 1) {
                // �����Է�
                data = cnt++ + "\t|";  // �й� �߰�

                System.out.print("����> ");
                input = sc.nextInt();
                data += input + "\t|";
                temp1 = input;
                if (temp1 > 100) {
                    System.out.println("������ �߸� �Է��ϼ̽��ϴ�. �޴��� ���ư��ϴ�.");
                } else {
                    System.out.print("����> ");
                    input = sc.nextInt();
                    data += input + "\t|";
                    temp2 = input;
                    if (temp2 > 100) {
                        System.out.println("������ �߸� �Է��ϼ̽��ϴ�. �޴��� ���ư��ϴ�.");
                    } else {
                        System.out.print("����> ");
                        input = sc.nextInt();
                        data += input + "\t|";
                        temp3 = input;
                        if (temp3 > 100) {
                            System.out.println("������ �߸� �Է��ϼ̽��ϴ�. �޴��� ���ư��ϴ�.");
                        } else {
                            total = temp1 + temp2 + temp3;
                            avg = total / 3.0;
                            avg = Math.round(avg * 100) / 100.0;
                            data += total + "\t|" + avg + "\t\r\n";
                            studentData[cnt - 2] = data;  // �迭�� ���� ����
                        }
                    }
                }

            }
            if (choice == 2) {
                // ���� ���
                System.out.println(table);
                for (int i = 0; i < cnt - 1; i++) {
                    System.out.print(studentData[i]);
                }
                System.out.println();
            }

            if (choice == 3) {
                // ���� ����
                System.out.print("������ �л��� �й� > ");
                int studentId = sc.nextInt();

                // �й��� ��ȿ���� Ȯ��
                if (studentId > 0 && studentId < cnt) {
                    System.out.println("�й� " + studentId + "�� ������ �����մϴ�.");

                    // ���� ���� ���
                    System.out.println("���� ����: " + studentData[studentId - 1]);

                    // ������ ���� �׸� �Է�
                    System.out.print("����> ");
                    int newKorean = sc.nextInt();
                    System.out.print("����> ");
                    int newEnglish = sc.nextInt();
                    System.out.print("����> ");
                    int newMath = sc.nextInt();

                    // ���� ��ȿ�� üũ
                    if (newKorean > 100 || newEnglish > 100 || newMath > 100) {
                        System.out.println("������ �߸� �Է��ϼ̽��ϴ�. �޴��� ���ư��ϴ�.");
                    } else {
                        // ������ ��� ���
                        total = newKorean + newEnglish + newMath;
                        avg = total / 3.0;
                        avg = Math.round(avg * 100) / 100.0;

                        // ������ ���� ����
                        studentData[studentId - 1] = studentId + "\t|" + newKorean + "\t|" + newEnglish + "\t|"
                                + newMath + "\t|" + total + "\t|" + avg + "\t\r\n";
                        System.out.println("���� ������ �Ϸ�Ǿ����ϴ�.");
                    }
                } else {
                    System.out.println("�߸��� �й��Դϴ�.");
                }
            }

            if (choice == 4) {
                // ���� ����
                System.out.print("������ �л��� �й� > ");
                int deleteId = sc.nextInt();

                // �й��� ��ȿ���� Ȯ��
                if (deleteId > 0 && deleteId < cnt) {
                    // �����Ϸ��� �л��� �����͸� null�� �����Ͽ� ����
                    studentData[deleteId - 1] = null;
                    System.out.println("�й� " + deleteId + "�� ������ �����Ǿ����ϴ�.");

                    // ���� �� �迭�� ������ (������ �ڸ� �ڷ� ��� �����͸� �� ĭ�� �̵�)
                    for (int i = deleteId - 1; i < cnt - 1; i++) {
                        studentData[i] = studentData[i + 1];
                    }

                    // ������ �л� �����͸� null�� �����Ͽ� ����
                    studentData[cnt - 2] = null;
                    cnt--;  // �л� �� ����
                } else {
                    System.out.println("�߸��� �й��Դϴ�.");
                }
                System.out.println(); // �ݺ�����
            }

            if (choice == 0) {
                // ����
                System.out.println("���α׷��� �����մϴ�.\n�̿����ּż� �����մϴ�.");
                sc.close();
                break;
            }
        }
    }
}
