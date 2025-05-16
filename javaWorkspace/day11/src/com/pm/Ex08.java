package com.pm;

public class Ex08 {
//sort 알고리즘
	public static void main(String[] args) {
		int[] lotto=new int[45];
		int[] note=new int[6];
		for(int i=0; i<lotto.length; i++) {
			lotto[i]=i+1;
		}
		
		for(int i=0; i<1000; i++) {
			int ran=(int)(Math.random()*45);
			int temp=lotto[0];
			lotto[0]=lotto[ran];
			lotto[ran]=temp;
		}
		
		System.arraycopy(lotto, 0, note, 0, 6);
		
		for(int i=0; i<note.length-1; i++) {
			for(int j=i+1; j<note.length; j++) {
				if(note[i]>note[j]) {
					int temp=note[i];
					note[i]=note[j];
					note[j]=temp;
				}
			}
		}
		
		for(int i=0; i<6; i++) {
			System.out.print(note[i]+ " ");
		}

	}

}








