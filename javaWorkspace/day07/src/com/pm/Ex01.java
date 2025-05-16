package com.pm;
//다중 배열
public class Ex01 {

	public static void main(String[] args) {
		int[][] arr1;
//		arr1=new int[3][3];
//		arr1[0][0]=1;
//		arr1[0][1]=2;
//		arr1[0][2]=3;
//		arr1[1][0]=4;
//		arr1[1][1]=5;
//		arr1[1][2]=6;
//		arr1[2][0]=7;
//		arr1[2][1]=8;
//		arr1[2][2]=9;
//		arr1=new int[][];{null,null,null}
//		arr1=new int[3][];
//		arr1[0]=new int[3];
//		arr1[0][0]=1;
//		arr1[0][1]=2;
//		arr1[0][2]=3;
//		arr1[1]=new int[2];
//		arr1[1][0]=4;
//		arr1[1][1]=5;
//		arr1[2]=new int[3];
//		arr1[2][0]=7;
//		arr1[2][1]=8;
//		arr1[2][2]=9;
//		arr1=new int[][] {new int[] {1,2,3},new int[] {4,5,6},new int[] {7,8,9}};
		arr1=null;
		arr1=new int[][] {{1,2,3},{4,5,6},{7,8,9}};
		
		for(int i=0; i<arr1.length; i++) {
			for(int j=0; j<arr1[i].length; j++) {
				System.out.print(arr1[i][j]);
			}
			System.out.println();
		}

	}

}













