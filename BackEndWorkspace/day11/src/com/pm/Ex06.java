package com.pm;

public class Ex06 {
	public static void main(String[] args) {
		// 로또 번호 생성기(ver 0.1.0)
		// 1에서 45번 숫자를 뽑아서 출력

		// 첫번째 - 노가다
		System.out.println("로또 번호 생성기 (ver 0.1.0) - 노가다");

		int rand1 = (int) (Math.random() * 45 + 1);// rand1

		int rand2 = (int) (Math.random() * 45 + 1);
		if (rand1 != rand2) {
			rand2 = (int) (Math.random() * 45 + 1);
		} // rand2

		int rand3 = (int) (Math.random() * 45 + 1);
		if (rand2 != rand3 && rand1 != rand3) {
			rand3 = (int) (Math.random() * 45 + 1);
		} // rand3

		int rand4 = (int) (Math.random() * 45 + 1);
		if (rand3 != rand4 && rand4 != rand1 && rand3 != rand2) {
			rand4 = (int) (Math.random() * 45 + 1);
		} // rand4

		int rand5 = (int) (Math.random() * 45 + 1);
		if (rand4 != rand5 && rand5 != rand3 && rand5 != rand2 && rand5 != rand1) {
			rand5 = (int) (Math.random() * 45 + 1);
		} // rand5

		int rand6 = (int) (Math.random() * 45 + 1);
		if (rand5 != rand6 && rand6 != rand4 && rand6 != rand3 && rand6 != rand2 && rand6 != rand1) {
			rand6 = (int) (Math.random() * 45 + 1);
		} // rand6

		System.out.print(String.format("%d %d %d %d %d %d ", rand1, rand2, rand3, rand4, rand5, rand6));

		System.out.println("\n");

		// 2번째 - 반복문
		System.out.println("로또 번호 생성기 (ver 0.1.1) - 반복문");
		int count = 0; // 생성된 번호의 개수
		boolean jungbok;
		while (count < 6) {
			int rand = (int) (Math.random() * 45 + 1);
			jungbok = false; // 중복 여부 초기화
			// 중복 체크
			for (int i = 0; i < count; i++) {
				if (rand == i) {
					jungbok = true; // 중복이 있다면
					break;
				}
			}                
			// 중복되지 않으면 번호 출력
			if (!jungbok) {
				System.out.print(rand + " ");
				count++; // 출력 번호 개수 증가
			}
		}

		System.out.println("\n");

		// 3번쨰 - 배열
		System.out.println("로또 번호 생성기 (ver 0.1.2) - 배열");
		int[] lottoNumber = new int[6];

		for (int i = 0; i < 6; i++) {
			int number = (int) (Math.random() * 45 + 1);
			for (int j = 0; j < i; j++) {
				if (lottoNumber[j] == number) {
					number = (int) (Math.random() * 45 + 1);
					j--;
				}
			}
			lottoNumber[i] = number;
		}
		for (int number : lottoNumber) {
			System.out.print(number + " ");
		}

		System.out.println("\n");

		System.out.println("로또 번호 생성기 (ver 0.1.3) - 객체");
		/*
		
		
		
		*/
		System.out.println("\n");

		System.out.println("로또 번호 생성기 (ver 0.1.0) - 강사님");
		// 1. 1 ~ 45 랜덤숫자 생성
		int su = 0;
		while (true) {
			su = (int) (Math.random() * 1000); // 0~99.99999
			if (su > 0 && su < 46)
				break;
		}
		System.out.println(su);
		// 2. 값의 치환
		int a = 1111;
		int b = 2222;
		int temp = a;
		a = b;
		b = temp;
		System.out.println(a);
		System.out.println(b);
		System.out.println(a == 2222 && b == 1111);
		// 3. sort 알고리즘
		int[] arr = { 3, 2, 1 };
		int[] temp2 = { 0, 0, 0 };

//		arr[0]=temp2[0];
//		if(arr[0]>temp2[1])arr[0]=temp2[1];
//		if(arr[0]>temp2[2])arr[0]=temp2[2];
		System.out.println(arr[0]);

//		arr[1]=temp2[1];
//		if(arr[1]>temp2[2])arr[1]=temp2[2];
		System.out.println(arr[1]);

//		arr[2]=temp2[2];
		System.out.println(arr[2]);

	}// main end
}// end
