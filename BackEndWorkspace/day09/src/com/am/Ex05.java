package com.am;

public class Ex05 implements Cloneable{

	public static void main(String[] args) throws CloneNotSupportedException {
//		int[] arr1={2,4,6,8};
//		int[] arr2=arr1;
//		Object copy=arr1.clone();
//		System.out.println(copy);
//		System.out.println(arr1);
//		System.out.println(arr2);
		Ex05 me=new Ex05();
		Object you=me.clone();
	}

}
