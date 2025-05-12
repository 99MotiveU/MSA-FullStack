package com.pm;

import java.util.Scanner;

public class Ex06 {

	public static void main(String[] args) {
		String title="학생성적관리프로그램(ver 0.2.0)";
		String menu="1.입력 2.출력 (3.수정 4.삭제) 0.종료> ";
		String table="-------------------------------------------\r\n" + 
				"학번	|국어	|영어	|수학	|합계	|평균\r\n" + 
				"-------------------------------------------";
		Scanner sc = new Scanner(System.in);
		System.out.print("총원> ");
		int[][] data=new int[sc.nextInt()][];
		int idx=0;
		while(true) {
			System.out.print(menu);
			int input=sc.nextInt();
			if(input==0)break;
			if(input==1&&data.length>idx) {
				int[] stu=new int[3];
				System.out.print("국어> ");
				stu[0]=sc.nextInt();
				System.out.print("영어> ");
				stu[1]=sc.nextInt();
				System.out.print("수학> ");
				stu[2]=sc.nextInt();
				data[idx++]=stu;
			}else if(input==1) {
				System.out.println("모두 입력하셨습니다");
			}
			if(input==2) {
				System.out.println(table);
				for(int i=0; i<idx; i++) {
					int[] stu=data[i];
					System.out.print(i+1);
					for(int j=0; j<stu.length; j++) {
						System.out.print("	|");
						System.out.print(stu[j]);
					}					
					System.out.print("	|");
					System.out.print(stu[0]+stu[1]+stu[2]);
					System.out.print("	|");
					System.out.print((stu[0]+stu[1]+stu[2])*100/3/100.0);
					System.out.println();
				}
				System.out.println();
			}
		}
		sc.close();
		System.out.println("이용해주셔서 감사합니다");
	}

}
















