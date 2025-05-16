package com.am;

// 배열 복사
public class Ex04 {

	public static void main(String[] args) {
		int[] arr1 = new int[] { 2, 4, 6, 8 };

		int[] arr2 = arr1;
//		arr1[1]=3;    -> 얕은 복사  (옅은 복사를 더 많이 쓴다?)

		// -> 깊은 복사
		arr2 = new int[4];
		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = arr1[i];
		}

//		arr1[1]=3;

		for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr2[i]);
		}
		System.out.println();

		arrPrint(arr1);
		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr1[i]);
		}

	}// main end

	public static void arrPrint(int[] arr2) {//int[] arr2=arr1;이 코드는 보이진 않지만 있는것, 호출만 해도 배열의 옅은 복사가 되고 있는 것이다.
		arr2[1] = 3; // 지역변수라 변수의 라이프사이클이 함수 안인데 console을 보면 적용이 되고 있다.
	}
}
