package com.pm;

import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		// �ֹι�ȣ üũ��(ver 0.1.0)
		// �ֹι�ȣ�� �Է�> 991231-1234567
		// ����� 27�� �����Դϴ�
		// �ֹι�ȣ�� �Է�> 001231-4234567
		// ����� 26�� �����Դϴ�
		//////////////////////////////
		// �ֹι�ȣ�� �Է�> 9912311234567
		// �Է������� �ٽ� Ȯ���ϼ��� (000000-0000000)
		// �ٽ� �Է�> 991231-123456
		// �Է������� �ٽ� Ȯ���ϼ��� (000000-0000000)
		// �ٽ� �Է�> a91231-1234567
		// ���ڸ� �Է��ϼ���
		// ���� : �ѱ�����
		
		char[] role= {'��','��','��','��','��','��','��','ĥ','��','��'};
		char[] target=new char[10];
		for(int i=0; i<target.length; i++) {
			target[i]=(char)('0'+i);
		}
		
		Scanner sc =new Scanner(System.in);
		char gender='��';
		int age=0;
		boolean boo1=true,boo2=false;
		while(boo1) {
			boo2=false;
			System.out.print("�ֹι�ȣ�� �Է�> ");
			String input=sc.nextLine();
			char[] arr1=input.toCharArray();
			
			for(int i=0; i<arr1.length; i++) {
				for(int j=0; j<role.length; j++) {
					if(arr1[i]==role[j]) {arr1[i]=target[j];}
				}
			}
			
			for(int i=0;i<arr1.length; i++) {
				if(i!=6&&(arr1[i]<'0'||arr1[i]>'9')) {boo2=true;}
			}
			
			if(arr1[6]!='-') {
				System.out.println("�Է������� �ٽ� Ȯ���ϼ��� (000000-0000000)");
			}else if(arr1.length!=14) {
				System.out.println("�Է������� �ٽ� Ȯ���ϼ��� (000000-0000000)");
			}else if(boo2) {
				System.out.println("���ڸ� �Է��ϼ���");
			}else {
				if(arr1[7]=='1'||arr1[7]=='3') {gender='��';}
				if(arr1[7]=='2'||arr1[7]=='4') {gender='��';}
				int year=1900+(arr1[0]-'0')*10+(arr1[1]-'0')*1;
				if(arr1[7]=='3'||arr1[7]=='4')year+=100;
				age=2025-year+1;
				boo1=false;
			}
		}
		System.out.println("����� "+age+"�� "+gender+"���Դϴ�");
		sc.close();
	}

}


















