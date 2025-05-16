package com.am;

public class Ex03 {
	//String Array
	public static void main(String[] args) {
		int[] arr1=null; //자바의 배열은 참조 , 배열을 선언만 하고 호출하면 null이 출력된다.
		arr1 = new int[5];
		arr1 = new int[3];
//		for(int i=0; i<arr1.length; i++) {
//			arr1[i]=i*2+2;
//		}
		int arr2[] = new int[5]; //이거 말고 위에꺼 처럼 쓰기
		int[] arr3 = new int[] {1,3,5,7,9};
		
		for(int i=0; i<arr3.length; i++) {
			System.out.println(arr1[i]);
		}
		
		

	}

}
