package com.am;

public class Ex06 {

	public static void main(String[] args) {
//		int[] arr1=new int[3];
//		int[] arr1=new int[3] {1,2,3};
//		int[] arr2=new int[] {4,5};
//		int[] arr3=new int[] {7,8,9};
//		int[][] arr4= new int[][]{arr1,arr2,arr3};
		int[][] arr4; //int[][] arr4=null;
//		arr4=new int[3][4];
		arr4=new int[][] {new int[4],new int[4],new int[4]};
//		arr4[0]=new int[] {1,2,3};
//		arr4[1]=new int[] {4,5};
//		arr4[2]=new int[] {7,8,9,6};
		
		String[] arr5=new String[] {"java","web","spring"};
		
		for(int i=0; i<arr4.length; i++) {
			int[] temp=arr4[i];
			for(int j=0; j<temp.length; j++) {
				System.out.print(temp[j]);
			}
			System.out.println();
			
		}
		System.out.println("-------------------------");
		int[][] arr6=arr4;
//		arr4[1]=new int[] {1,2,3};
		for(int i=0; i<arr6.length; i++) {
			int[] temp=arr6[i];
			for(int j=0; j<temp.length; j++) {
				System.out.print(temp[j]);
			}
			System.out.println();
		}
		
		//±íÀº º¹»ç
		System.out.println("-------------------------");
		int[][] arr7=null;
		arr7=new int[3][];
		for(int i=0; i<arr4.length; i++) {
			int[] temp=arr4[i];
			int[] temp2=new int[temp.length];
			for(int j=0; j<temp.length; j++) {
				temp2[j]=temp[j];
			}
			arr7[i]=temp2;
		}
		
		arr4[1][1]=1;
		
		for(int i=0; i<arr7.length; i++) {
			int[] temp=arr7[i];
			for(int j=0; j<temp.length; j++) {
				System.out.print(temp[j]);
			}
			System.out.println();
		}
	}

}













