package com.pm;
// ����� �޼���� ����
import java.util.Scanner;

public class Ex02_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
     
        String input;
        while (true) {
            System.out.print("�ֹι�ȣ�� �Է�> ");
            input = sc.nextLine();
            
            // ��ȿ�� �˻�
            if (isValid(input)) {
                break;
            }
            System.out.println("�Է������� �ٽ� Ȯ���ϼ��� (000000-0000000), ���� �ڵ�� 1, 2, 3, 4�� �����մϴ�.");
        }

        // ���� �� ���� ��� �� ���
        System.out.println(getAge(input) + "�� " + getGender(input) + "���Դϴ�");
        sc.close();
    } //main end

    // �ֹι�ȣ ��ȿ�� �˻�
    private static boolean isValid(String input) {
        // ���̰� 14���̰�, '-'�� 6��° �ڸ��� �־�� ��
        if (input.length() != 14 || input.charAt(6) != '-') {
            return false;
        }

        // ���ڸ� �����ϰ�, 7��° �ڸ��� ���� �ڵ�(1, 2, 3, 4)���� ��
        for (int i = 0; i < input.length(); i++) {
            if (i != 6 && (input.charAt(i) < '0' || input.charAt(i) > '9')) {
                return false; // ���ڰ� �ƴϸ� �߸��� �Է�
            }
        }

        // 7��° �ڸ��� ���� �ڵ�(1, 2, 3, 4)���� ��
        char genderChar = input.charAt(7);
        if (genderChar != '1' && genderChar != '2' && genderChar != '3' && genderChar != '4') {
            return false; // ���� �ڵ尡 1, 2, 3, 4�� �ƴϸ� �߸��� �Է�
        }

        return true;
    } //isValid end

    // ���� ���
    private static String getGender(String input) {
        return (input.charAt(7) == '1' || input.charAt(7) == '3') ? "��" : "��";
    }

    
    // ���� ���
    private static int getAge(String input) {
        int year = 1900 + (input.charAt(0) - '0') * 10 + (input.charAt(1) - '0');
        if (input.charAt(7) == '3' || input.charAt(7) == '4') {
            year += 100;  // 2000�� ���� ���
        }
        return 2025 - year + 1;  // ���� ���� (2025��) ���� ����
    }
}
