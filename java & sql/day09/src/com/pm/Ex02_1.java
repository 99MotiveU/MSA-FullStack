package com.pm;

import java.util.Scanner;
//���� ó�� �ʿ� - ���� �κп��� 100�̻��� �����Է½� ���� ��ȯ
public class Ex02_1 {

    public static void main(String[] args) {
        // �л������������α׷�(ver 0.5.0) -�迭
        // 1.���� 2.�Է� 3.���� 4.���� 0.���� >
        // ������ �й�>
        // ���� >
        // ...
        // ������ �й� >
        // 1.���� 2.�Է� 3.���� 4.���� 0.���� >
        Scanner sc = new Scanner(System.in);  
        System.out.println("�л� ���� ���� ���α׷� ver 0.5.0");
        System.out.print("�ѿ� > "); 

        // ���� �� ����
        final int sub = 3;  // ���� �� 3 (����, ����, ����)

        // ���� ���� �ε���
        final int kor = 0;  // ���� ���� �ε���
        final int eng = 1;  // ���� ���� �ε���
        final int math = 2;  // ���� ���� �ε���

        // ���л��� �Է� �ޱ�
        int stc = sc.nextInt();  // �л� �� �Է�

        // �л� ������ ������ �迭 ����
        int[][] scores = new int[stc][sub];  // stc���� �л��� ���� 3���� ���� ����
        int[] totals = new int[stc];  // �� �л��� ���� 
        double[] avgs = new double[stc];  // �� �л��� ��� ����

        // ���� ������ ���鼭 �޴� ó��
        while (true) {
            System.out.print("1.�Է� 2.��� 3.���� 4.���� 0.���� > ");  
            int choice = sc.nextInt(); 

            switch (choice) {
            case 1:  // ���� �Է�
                for (int i = 0; i < stc; i++) {  
                    System.out.println((i + 1) + "��° �л��� ������ �Է��ϼ���. ������ �Է°���");
                    System.out.print("����: ");  
                    scores[i][kor] = sc.nextInt();  
                    if (scores[i][kor] > 100) {  // ���� ���� ��ȿ�� �˻�
                        System.out.println("������ �߸� �ԷµǾ����ϴ�.");
                        break; 
                    }

                    System.out.print("����: ");  
                    scores[i][eng] = sc.nextInt(); 
                    if (scores[i][eng] > 100) {  // ���� ���� ��ȿ�� �˻�
                        System.out.println("������ �߸� �ԷµǾ����ϴ�.");
                        break;  // �߸��� ���� �Է� �� �Է� ����
                    }

                    System.out.print("����: ");  
                    scores[i][math] = sc.nextInt();  
                    if (scores[i][kor] > 100) {  // ���� ���� ��ȿ�� �˻�
                        System.out.println("������ �߸� �ԷµǾ����ϴ�.");
                        break;  
                    }
                    System.out.println();
                }
                break;

            case 2:
                // ���� ���
                System.out.println("-------------------------------------------------");
                System.out.println("�й�\t| ����\t| ����\t| ����\t| �հ�\t| ���\t");

                // �� �л��� ���� ���
                for (int i = 0; i < stc; i++) {
                    int total = scores[i][kor] + scores[i][eng] + scores[i][math]; 
                    double avg = total / 3.0;

                    totals[i] = total;  // ���� �迭�� ����
                    avgs[i] = avg;  // ��� �迭�� ����

                    System.out.println("-------------------------------------------------");
                    System.out.println(String.format("%d\t| %d\t| %d\t| %d\t| %d\t| %.2f\t", 
                        i + 1, scores[i][kor], scores[i][eng], scores[i][math], totals[i], avgs[i]));
                }
                System.out.println("-------------------------------------------------");
                break;  // ���� ��� �� �޴��� ���ư�

            case 3:  // ���� ����
                // ������ �л� ��ȣ �Է�
                System.out.print("������ �л� ��ȣ�� �Է��ϼ��� > ");
                int stn = sc.nextInt() - 1;  // �л� ��ȣ �Է¹ް�, �ε��� ���߱� ���� 1�� ���� ����

                if (stn >= 0 && stn < stc) {  // �л� ��ȣ�� ��ȿ���� Ȯ��
                    System.out.println((stn + 1) + "��° �л��� ������ �����մϴ�.");

                    // ������ ���� �Է�
                    System.out.print("����: ");
                    scores[stn][kor] = sc.nextInt();  // ������ ���� ���� �Է�

                    System.out.print("����: ");
                    scores[stn][eng] = sc.nextInt();  // ������ ���� ���� �Է�

                    System.out.print("����: ");
                    scores[stn][math] = sc.nextInt();  // ������ ���� ���� �Է�
                } else {
                    System.out.println("�߸��� �л� ��ȣ�Դϴ�.");  // �߸��� ��ȣ �Է� �� ���� �޽��� ���
                }
                break;  // ���� ���� �� �޴��� ���ư�

            case 4:  // ���� ����
                // ������ �л� ��ȣ �Է�
                System.out.print("������ �л� ��ȣ�� �Է��ϼ��� : ");
                stn = sc.nextInt() - 1;  // �л� ��ȣ �Է¹ް�, �ε��� ���߱� ���� 1�� ���� ����

                if (stn >= 0 && stn < stc) {  // �л� ��ȣ�� ��ȿ���� Ȯ��
                    // ���� ���� (������ ����, ����� 0���� �ʱ�ȭ)
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
                
            case 0:  // ����
                System.out.println("���α׷��� �����մϴ�."); 
                break; 

            default: 
                System.out.println("�߸��� �Է��Դϴ�.");  
            }
        }
    }
}
