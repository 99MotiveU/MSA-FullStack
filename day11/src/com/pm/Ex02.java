package com.pm;

import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 예외처리
		// try {실행코드} catch(~){예외발생시;}
		int[] arr1 = { -2, -1, 0, 1, 2 };
		try {
			for (int i = 0; i < arr1.length; i++) {
				System.out.println(0 / arr1[i]);
			}
		} catch (ArithmeticException e) {
			System.out.println("에러 해결");
		}
		// 반복 탈출
		System.out.println("-----------------------------------------");

		for (int i = 0; i < arr1.length; i++) {
			try {
				System.out.println(0 / arr1[i]);
			} catch (Exception e) {
				System.out.println("에러 해결");
			}
		}
		System.out.println("------------------------------------------");

		for (int i = 0; i < arr1.length; i++) {
			try {
				System.out.println(0 / arr1[i]);
			} catch (java.lang.ArithmeticException e) {
//				String msg=e.getMessage();
//				String msg=e.toString();
//				System.out.println(msg);
				StackTraceElement[] stack = e.getStackTrace();
				for (int j = 0; j < stack.length; j++) {
					StackTraceElement element = stack[j];
					System.out.println(element.getClassName() + "\t");
					System.out.println(element.getMethodName() + "\t");
					System.out.println(element.getLineNumber());
				}
			}
		}
		System.out.println("-----------------------------------------");

//		for(int i=0; i<arr1.length; i++) {
		try {
			sc.nextInt();
//				System.out.println(0/arr1[i]);
		} catch (java.lang.ArithmeticException e) {
		} catch (Exception e) {
			String msg1 = e.getMessage();
			String msg2 = e.toString();
			System.out.println(msg2);
			StackTraceElement[] stack = e.getStackTrace();
			for (int j = 0; j < stack.length; j++) {
				StackTraceElement element = stack[j];
				System.out.print(element.getClassName() + "\t");
				System.out.print(element.getMethodName() + "\t");
				System.out.println(element.getLineNumber());
			}
		}

		System.out.println("-----------------------------------------");
		for (int i = 0; i <= arr1.length; i++) {
			try {
				System.out.println(0 / arr1[i]);
			} catch (java.lang.ArithmeticException e) {
			} catch (Exception e) {
//				String msg=e.getMessage();
//				String msg=e.toString();
//				System.out.println(msg);
//				StackTraceElement[] stack = e.getStackTrace();
//				for(int j=0; j<stack.length; j++) {
//					StackTraceElement element=stack[j];
//					System.out.print(element.getClassName()+"\t");
//					System.out.print(element.getMethodName()+"\t");
//					System.out.println(element.getLineNumber());
//				}
				e.printStackTrace();
			}
		}

	}

}
