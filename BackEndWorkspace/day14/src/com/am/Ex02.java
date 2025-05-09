package com.am;

import java.util.*;

class Ball implements Comparable<Ball>{
	int num;
	public Ball(int num) {
		this.num=num;
	}
	
	@Override
	public int compareTo(Ball ord) {
		return ord.num-this.num;
	}
	
	@Override
	public String toString() {
		return num+"공";
	}
}

public class Ex02 {

	public static void main(String[] args) {
		int[] lotto = {2,44,32,12,38,8};
		String[] arr2 = {"b","Ab","Aa","B"};
		Ball[] arr3 = {new Ball(1), new Ball(3), new Ball(2)};		
		
		Arrays.sort(lotto);
		System.out.println(Arrays.toString(lotto));
		
		Arrays.sort(arr2);
		System.out.println(Arrays.toString(arr2));
				
		Arrays.sort(arr3);
		System.out.println(Arrays.toString(arr3));
		
		System.out.println("---------------------------------------");
		System.out.println(Arrays.binarySearch(lotto, 38)); //index번호 return, 없는 번호를 호출하면 인덱스 번호에 해당할 수 없는 -값이 나온다.ㅜ
	}

}
