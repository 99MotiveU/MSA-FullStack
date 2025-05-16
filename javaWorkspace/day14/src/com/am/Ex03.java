package com.am;

import java.util.Arrays;

public class Ex03 {

	public static void main(String[] args) {
		int[] lotto= {2,44,32,12,38,8};
		Arrays.sort(lotto);
		System.out.println(Arrays.toString(lotto));
		System.out.println(Arrays.binarySearch(lotto,8));
		System.out.println(Arrays.binarySearch(lotto,12));
		//binarySearch는 sort와 함께 써야한다. 정렬이 되어있다해도  sort 후 binarySearch
	}

}
