package com.pm;

import java.util.Scanner;

// �л� ������ �����ϴ� Ŭ����
class Student {
    private int id;  
    private int korean;  
    private int english;
    private int math; 
    private int total;  
    private double average;  

    // ������ : �л� ��ü�� �����ϰ� ������ �ʱ�ȭ
    public Student(int id, int korean, int english, int math) {
        this.id = id;  // 
        this.korean = korean;  
        this.english = english;  
        this.math = math;  
        calculateTotalAndAverage();  // ������ ��� ���
    }

    // �� �ʵ忡 ���� getter �޼��� (�Ӽ��� ��ȯ)
    public int getId() {return id;}

    public int getKorean() {return korean;}

    public int getEnglish() {return english;}

    public int getMath() {return math;}

    public int getTotal() {return total;}

    public double getAverage() {return average;}

    // ������ ����� ����ϴ� �޼���
    private void calculateTotalAndAverage() {
        this.total = korean + english + math;  
        this.average = total / 3.0; 
        this.average = Math.round(this.average * 100) / 100.0; 
    }

    @Override
    public String toString() { // �л� ���� ���
        return id + "\t|" + korean + "\t|" + english + "\t|" + math + "\t|" + total + "\t|" + average + "\t\r\n";
    }

    // ���� ����
    public void updateScores(int korean, int english, int math) {
        this.korean = korean; 
        this.english = english; 
        this.math = math;  
        calculateTotalAndAverage();  // ������ ��� �ٽ� ���
    }
}

public class Ex02_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  
        System.out.println("�л� ���� ���� ���α׷� ver 0.7.0");
        Student[] students = new Student[500];  // �л� ������ ������ �迭 
        int studentCount = 0;  //�л���
        String menu = "1.�Է� 2.��� 3.���� 4.���� 0.����> ";

        while (true) {
            System.out.print(menu); 
            int choice = sc.nextInt();  

            if (choice == 1) {
                // ���� �Է�
                System.out.print("����> ");
                int korean = sc.nextInt(); 
                System.out.print("����> ");
                int english = sc.nextInt();  
                System.out.print("����> ");
                int math = sc.nextInt(); 

                if (korean > 100 || english > 100 || math > 100) {
                    System.out.println("������ �߸� �Է��ϼ̽��ϴ�. �޴��� ���ư��ϴ�.");
                } else {
                    // ���ο� �л� ��ü ���� �� �迭�� ����
                    Student newStudent = new Student(studentCount + 1, korean, english, math);
                    students[studentCount++] = newStudent;  // �迭�� �л� ���� �߰�
                    System.out.println("�л� ������ �ԷµǾ����ϴ�.");
                }
            } 

            if (choice == 2) {
                // ���� ���
                System.out.println("�й�\t|����\t|����\t|����\t|�հ�\t|���");
                System.out.println("----------------------------------------------------");
                for (int i = 0; i < studentCount; i++) {
                    System.out.print(students[i]); 
                }
            }

            if (choice == 3) {
                // ���� ����
                System.out.print("������ �л��� �й� > ");
                int studentId = sc.nextInt();  
                
                if (studentId > 0 && studentId <= studentCount) {
                    // �й��� �ش��ϴ� �л��� ã����
                    Student student = students[studentId - 1];  // �й��� �ش��ϴ� �л� ��ü ã��
                    System.out.println(studentId + "�� �л��� ������ �����մϴ�.");
                    System.out.println("\t�й�\t|����\t|����\t|����\t|�հ�\t|���");
                    System.out.println("���� ����: " + student); 

                    System.out.print("����> ");
                    int newKorean = sc.nextInt();
                    System.out.print("����> ");
                    int newEnglish = sc.nextInt();
                    System.out.print("����> ");
                    int newMath = sc.nextInt();

                    if (newKorean > 100 || newEnglish > 100 || newMath > 100) {
                        System.out.println("������ �߸� �Է��ϼ̽��ϴ�. �޴��� ���ư��ϴ�.");
                    } else {
                        // ���� ����
                        student.updateScores(newKorean, newEnglish, newMath);
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

                if (deleteId > 0 && deleteId <= studentCount) {
                    for (int i = deleteId - 1; i < studentCount - 1; i++) {
                        students[i] = students[i + 1];  // ������ �л� ���� �л����� �� ĭ�� ������ �̵�
                    }
                    students[studentCount - 1] = null;  // ������ �л� ������ null�� ����
                    studentCount--;  // �л� �� ����
                    System.out.println("�й� " + deleteId + "�� ������ �����Ǿ����ϴ�.");
                } else {
                    System.out.println("�߸��� �й��Դϴ�.");
                }
            }

            if (choice == 0) {
                // ����
                System.out.println("���α׷��� �����մϴ�.\n�̿����ּż� �����մϴ�.");
                sc.close();
                break; 
            }
        }
    } // main end
} // end
