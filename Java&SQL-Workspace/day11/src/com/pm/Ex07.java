package com.pm;

public class Ex07 {

	public static void main(String[] args) {
		int[] lotto = new int[6];
		for(int i=0; i<lotto.length; i++) {
//			0*45+1<=ran*45+1 <1*45+1
			int temp = (int)(Math.random()*45)+1;
			lotto[i]=temp;
			for(int j=0; j<i; j++) {
				if(lotto[j]==temp) {
					i--;
					break;
				}
			}
		}

		for(int i=0; i<lotto.length; i++) {
			System.out.print(lotto[i]+" ");
		}
	}

}
