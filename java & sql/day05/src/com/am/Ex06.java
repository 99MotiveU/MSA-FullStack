package com.am;

public class Ex06 {

	public static void main(String[] args) {
		char ch = 'A';
		int su=1;
		for (int j = 0; j < 4; j++) {
			for (int i = 0; i < j; i++) {
				System.out.print(su++);
			}
			System.out.println();
		}

	}

}
