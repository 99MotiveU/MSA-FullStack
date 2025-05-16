package com.am;

import java.util.Scanner;

//Scanner
//Properties
//Optional
public class Ex09 {

	public static void main(String[] args) {
//		java.io.InputStream src=System.in;
//		String src = "java web spring\n11 22 33";
		String src = "1 2 3\n10\t12\r22 100 1000";
		Scanner sc = new Scanner(src);

		System.out.println("input:" + sc.nextLine()); // 개행전까지 스캔
		System.out.println("input:" + (sc.nextInt() + 1)); //spacebar까지 스캔
		System.out.println("input:" + (sc.next()+1)); // 구분자까지 스캔
		
		System.out.println();
		
		while(sc.hasNext()) {
			System.out.println("input:"+(sc.nextInt()+1));
		}

		sc.close();
	}
}
