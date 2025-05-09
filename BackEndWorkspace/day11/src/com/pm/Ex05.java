package com.pm;

import java.util.Scanner;

public class Ex05 {

	static class UserErr extends Exception {
//		public UserErr() {
//			super("su가 1, 2, 5, 10만 가능");
//		}
		public UserErr(String msg) {
			super(msg);
		}
	}
	public static int func01(int su) throws UserErr {

//		if(!(su==1||su==2||su==5||su==10)) return 0;
		if (!(su == 1 || su == 2 || su == 5 || su == 10))
			throw new UserErr("su가 " +su+ "이므로 안됨");
		return 10 / su;
	}// su 1,2,5,10

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		try {
			int su = func01(input);
			System.out.println(su);
		} catch (UserErr e) {
			//System.out.println("입력오류");
			e.printStackTrace();
		}
//		if(su==0) System.out.println("입력오류"); 
//		else System.out.println(su);
	}
}
