package com.am;
// java.util
// 시간
import java.util.*; // 유틸리티 도구

public class Ex01 {

	public static void main(String[] args) {
		int[] arr1= {1,3,5,7,9};

		String msg1=Arrays.toString(arr1);
		System.out.println(arr1.toString());
		System.out.println(msg1);
		
		int[] arr2=Arrays.copyOf(arr1, 5);
		arr1[1]=2;
		System.out.println(Arrays.toString(arr2));
		int[] arr3 = Arrays.copyOfRange(arr2, 1, 4);
		int[] arr4 = Arrays.copyOfRange(arr2, 0, 5);
		System.out.println(Arrays.toString(arr3));
		System.out.println(Arrays.toString(arr4));
		
		System.out.println(arr2 == arr4);
		System.out.println(arr2.equals(arr4));
		System.out.println(Arrays.equals(arr2, arr4));
		
		int[][] arr5 = {new int[]{1,2,3},new int[]{4,5,6}};
		int[][] arr6 = {{1,2,3},{4,5,6}}; // new int[] 생략 되어있음
		System.out.println(Arrays.equals(arr5, arr6));
		System.out.println(Arrays.deepEquals(arr5, arr6));
		
		Arrays.fill(arr1, 1111);
		System.out.println(Arrays.toString(arr1));
		
		
	}

}





















