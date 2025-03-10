package com.am;

public class Ex07 {

	public static void main(String[] args) {
		java.util.Scanner sc=new java.util.Scanner(System.in);
		boolean boo=true;
		while(boo) {
			System.out.print("1.가위 2.바위 3.보 0.종료>");
			int me=sc.nextInt();
			if(me==0) {
				boo=false;
			}else {
			int com=func02();
			func01(0,me);
			func01(1,com);			
	
			System.out.println();
			if(me==com) {
				System.out.println("무");
			}
			if(me==1&&com==2) {System.out.println("패");}
			if(me==1&&com==3) {System.out.println("승");}
			
			if(me==2&&com==1) {System.out.println("승");}
			if(me==2&&com==3) {System.out.println("패");}
	
	
			if(me==3&&com==1) {System.out.println("승");}
			if(me==3&&com==2) {System.out.println("패");}
			}
		}
	}
	// 1,2,3
	// 1~3의 10진수 정수값을 랜덤하게 구해주는 기능
	public static int func02() {
		int com=0;
		while(!(com==1||com==2||com==3)) {
			double ran=Math.random()*10; // 0.0<=ran<1.0
			com=(int)ran; // 0~9
		}
		
		return com;
	}
	
	public static void func01(int su,int com) {
		if(su==0) {
			System.out.print("me:");
		}
		if(su==1) {
			System.out.print("com:");
		}
		if(com==1) {
			System.out.print("가위");
		}else if(com==2) {
			System.out.print("바위");
		}else if(com==3) {
			System.out.print("보");
		}
	}

}