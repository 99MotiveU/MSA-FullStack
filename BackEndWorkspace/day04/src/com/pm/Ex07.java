package com.pm;

public class Ex07 {

	public static void main(String[] args) {
		String title="--------------------------------------\r\n" + 
				"���� ���� �� ����(ver 0.1.0)\r\n" + 
				"--------------------------------------";
		String menu="����(1),����(2),��(3),����(0)> ";
		int a=0,b=0,c=0;
		boolean boo=true,boo2=true;
		java.util.Scanner sc=new java.util.Scanner(System.in);
		
		System.out.println(title);
		while(boo) {
		System.out.print(menu);
			int input=sc.nextInt();
			int com=0;
			while(boo2) {
				double ran=Math.random();
				com=(int)(ran*10);
				if(com==1||com==2||com==3) {
					boo2=false;
				}
			}
			boo2=true;
			System.out.println("com="+com);
			if(input==0) {boo=false;}
			if(input==1) {
				System.out.print("���:����	");
			}
			if(input==2) {
				System.out.print("���:����	");
			}
			if(input==3) {
				System.out.print("���:��	");
			}
			if(com==1) {
				System.out.println("com:����	");
			}
			if(com==2) {
				System.out.println("com:����	");
			}
			if(com==3) {
				System.out.println("com:��	");
			}
			if(input==com) {
				b++;
				System.out.println("�����");
			}else if(input==1&&com==3||input==2&&com==1||input==3&&com==2){
				a++;
				System.out.println("�̰���");
			}else{
				c++;
				System.out.println("����");
			}
			
		}
		System.out.println(a+"�� "+b+"�� "+c+"��");
		System.out.println("�̿����ּż� �����մϴ�");
	}

}











