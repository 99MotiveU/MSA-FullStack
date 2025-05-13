package com.am;

import java.util.Random;

public class Ex04 {

	public static void main(String[] args) {
		// 1~45
		// 0<=Math.random<1.0
		// 0<=Math.random<0.9999999999999999999999999
		// 0*45<=Math.random*45<=0.9999999999999999999999999*45
		// 0<=Math.random*45<45
		// 0+1<=Math.random+1<45+1
		System.out.println((int)(Math.random()*45)+1);
		
		Random ran = new Random(11L);
		System.out.println(Integer.MIN_VALUE+"~"+Integer.MAX_VALUE);
		System.out.println(ran.nextInt()); //int 자료형 범위 내에서 
		System.out.println(ran.nextDouble()); // 0<= <1  ==math.random()과 같다.
		System.out.println(ran.nextBoolean()); // true, false;
		System.out.println(ran.nextLong()); //long 자료형 범위 내에서 
		System.out.println("-----------------------------------------------");
		System.out.println(ran.nextInt(45)+1);
		
		
	}

}
