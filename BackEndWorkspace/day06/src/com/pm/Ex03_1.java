package com.pm;
// �ڹٴ� ��ҹ��ڸ� �����ϴµ� ��ҹ��ڿ� ������� ���ڿ��� �����ϰ� ���� �� replace���� replaceAll�� ����ϴ� �� �� �� ����.
public class Ex03_1 {

    public static void main(String[] args) {
        // ���ڿ��� Create, Read, Update, Delete (CRUD) ����

        // create: ���ڿ� ����
        String msg = "ABCDabcd1234";  // �ʱ� ���ڿ��� ����

        // read: ���ڿ��� ������ �б�
        System.out.println(msg.length());  // ���ڿ��� ���� ���
        System.out.println(msg.contains("bc"));  // ���ڿ��� "bc"�� ���ԵǾ� �ִ��� Ȯ��
        System.out.println(msg.charAt(4));  // ���ڿ����� �ε��� 4 ��ġ�� �ִ� ���� ���

        // update: ���ڿ��� ���� (������Ʈ)
        msg = msg.replaceAll("abcd", "aBCd");  // "abcd"�� "aBCd"�� ��ü (��ҹ��� ���� ����)
        System.out.println(msg);  // ��ü�� ���ڿ� ���

        msg = msg.concat("!@#$");  // ���ڿ� ���� "!@#$" �߰�
        System.out.println(msg);  // ����� ���ڿ� ���

        // delete: ���ڿ� ���� (��ü �Ǵ� ����)
        msg = msg.replace("aBCd", "a");  // "aBCd"�� "a"�� ��ü (��ǻ� �����ϴ� ȿ��)
        System.out.println(msg);  // ��ü�� ���ڿ� ���

        // "bc"�� ���ڿ��� ���ԵǾ� �ִ��� �ٽ� Ȯ��
        System.out.println(msg.contains("bc"));  // "bc"�� ���ԵǾ� �ִ��� Ȯ��
    }
}


