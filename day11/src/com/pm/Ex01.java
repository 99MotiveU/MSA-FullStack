package com.pm;

public class Ex01 {
	public static void main(String[] args) {
		// 예외처리
		// try{실행코드} catch(~){예외발생시;}
		int[] arr1 = { 1, 2, 3 };
		try {
			for (int i = 0; i < 3; i++) {
				System.out.println(arr1[i]);
			}

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("에러발생");
		}

	}
}
