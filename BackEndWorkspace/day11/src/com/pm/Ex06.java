package com.pm;

public class Ex06 {
	public static void main(String[] args) {
		// �ζ� ��ȣ ������(ver 0.1.0)
		// 1���� 45�� ���ڸ� �̾Ƽ� ���

		// ù��° - �밡��
		System.out.println("�ζ� ��ȣ ������ (ver 0.1.0) - �밡��");

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

		// 2��° - �ݺ���
		System.out.println("�ζ� ��ȣ ������ (ver 0.1.1) - �ݺ���");
		int count = 0; // ������ ��ȣ�� ����
		boolean jungbok;
		while (count < 6) {
			int rand = (int) (Math.random() * 45 + 1);
			jungbok = false; // �ߺ� ���� �ʱ�ȭ
			// �ߺ� üũ
			for (int i = 0; i < count; i++) {
				if (rand == i) {
					jungbok = true; // �ߺ��� �ִٸ�
					break;
				}
			}                
			// �ߺ����� ������ ��ȣ ���
			if (!jungbok) {
				System.out.print(rand + " ");
				count++; // ��� ��ȣ ���� ����
			}
		}

		System.out.println("\n");

		// 3���� - �迭
		System.out.println("�ζ� ��ȣ ������ (ver 0.1.2) - �迭");
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

		System.out.println("�ζ� ��ȣ ������ (ver 0.1.3) - ��ü");
		/*
		
		
		
		*/
		System.out.println("\n");

		System.out.println("�ζ� ��ȣ ������ (ver 0.1.0) - �����");
		// 1. 1 ~ 45 �������� ����
		int su = 0;
		while (true) {
			su = (int) (Math.random() * 1000); // 0~99.99999
			if (su > 0 && su < 46)
				break;
		}
		System.out.println(su);
		// 2. ���� ġȯ
		int a = 1111;
		int b = 2222;
		int temp = a;
		a = b;
		b = temp;
		System.out.println(a);
		System.out.println(b);
		System.out.println(a == 2222 && b == 1111);
		// 3. sort �˰���
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
