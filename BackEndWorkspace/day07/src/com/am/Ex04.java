package com.am;

// �迭 ����
public class Ex04 {

	public static void main(String[] args) {
		int[] arr1 = new int[] { 2, 4, 6, 8 };

		int[] arr2 = arr1;
//		arr1[1]=3;    -> ���� ����  (���� ���縦 �� ���� ����?)

		// -> ���� ����
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

	public static void arrPrint(int[] arr2) {//int[] arr2=arr1;�� �ڵ�� ������ ������ �ִ°�, ȣ�⸸ �ص� �迭�� ���� ���簡 �ǰ� �ִ� ���̴�.
		arr2[1] = 3; // ���������� ������ ����������Ŭ�� �Լ� ���ε� console�� ���� ������ �ǰ� �ִ�.
	}
}
