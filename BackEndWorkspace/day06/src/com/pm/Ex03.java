package com.pm;

public class Ex03 {

    public static void main(String[] args) {
        // ���ڿ��� Create, Read, Update, Delete (CRUD) ����

        // create: ���ڿ� ����
        String msg = "ABCDabcd1234";  // �ʱ� ���ڿ��� ����

        // read: ���ڿ��� ������ �б�
        System.out.println(msg.length());  // ���ڿ��� ���� ���
        System.out.println(msg.contains("bc"));  // ���ڿ��� "bc"�� ���ԵǾ� �ִ��� Ȯ�� (true/false)
        System.out.println(msg.charAt(4));  // ���ڿ����� �ε��� 4 ��ġ�� �ִ� ���� ��� ('a')

        // update: ���ڿ��� ���� (������Ʈ)
        msg = msg.replace("abcd", "aBCd");  // "abcd"�� "aBCd"�� ��ü
        System.out.println(msg);  // ��ü�� ���ڿ� ���

        msg = msg.concat("!@#$");  // ���ڿ� ���� "!@#$" �߰�
        System.out.println(msg);  // ����� ���ڿ� ���

        // delete: ���ڿ� ���� (��ü �Ǵ� ����)
        msg = msg.replace("aBCd", "a");  // "aBCd"�� "a"�� ��ü (��ǻ� �����ϴ� ȿ��)
        System.out.println(msg);  // ��ü�� ���ڿ� ���

        // "bc"�� ���ڿ��� ���ԵǾ� �ִ��� �ٽ� Ȯ��
        System.out.println(msg.contains("bc"));  // "bc"�� ���ԵǾ� �ִ��� Ȯ�� (false)
    }
}
