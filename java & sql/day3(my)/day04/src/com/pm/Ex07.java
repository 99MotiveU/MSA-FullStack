package com.pm;

public class Ex07 {

	public static void main(String[] args) {
		String title="--------------------------------------\r\n" + 
				"가위 바위 보 게임(ver 0.1.0)\r\n" + 
				"--------------------------------------";
		String menu="가위(1),바위(2),보(3),종료(0)> ";
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
				System.out.print("당신:가위	");
			}
			if(input==2) {
				System.out.print("당신:바위	");
			}
			if(input==3) {
				System.out.print("당신:보	");
			}
			if(com==1) {
				System.out.println("com:가위	");
			}
			if(com==2) {
				System.out.println("com:바위	");
			}
			if(com==3) {
				System.out.println("com:보	");
			}
			if(input==com) {
				b++;
				System.out.println("비겼음");
			}else if(input==1&&com==3||input==2&&com==1||input==3&&com==2){
				a++;
				System.out.println("이겼음");
			}else{
				c++;
				System.out.println("졌음");
			}
			
		}
		System.out.println(a+"승 "+b+"무 "+c+"패");
		System.out.println("이용해주셔서 감사합니다");
	}

}











