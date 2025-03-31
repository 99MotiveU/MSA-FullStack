//동적할당 - 배열

package com.am;

public class Ex04 {

	public static void main(String[] args) {
		System.out.println("학생성적관리프로그램(ver 0.11.0)");
		java.util.Scanner sc;
		sc=new java.util.Scanner(System.in);
		
//		MyArray data=new MyArray();
		java.util.ArrayList data=new java.util.ArrayList();
		
		int input=0;
		while(true) {
			System.out.print("1.보기 2.입력 3.수정 4.삭제 0.종료> ");
			input=sc.nextInt();
			if(input==0)break;
			if(input==1) {
				for(int i=0; i<data.size(); i++) {
					int[] stu=(int[]) data.get(i);
					System.out.println(stu[0]+"\t"+stu[1]+"\t"+stu[2]+"\t"+stu[3]);
				}
			}
			if(input==2) {
				int[] stu=new int[4];
				System.out.print("학번> ");
				stu[0]=sc.nextInt();
				System.out.print("국어> ");
				stu[1]=sc.nextInt();
				System.out.print("영어> ");
				stu[2]=sc.nextInt();
				System.out.print("수학> ");
				stu[3]=sc.nextInt();
				data.add(stu);
			}
			if(input==3) {
				System.out.print("수정할 학번> ");
				input=sc.nextInt();
				int idx=-1;
				for(idx=0; idx<data.size(); idx++) {
					int[] stu=(int[])(data.get(idx));
					if(stu[0]==input)break;
				}
				if(data.size()!=idx) {
					int[] stu=new int[4];
					stu[0]=input;
					System.out.print("국어> ");
					stu[1]=sc.nextInt();
					System.out.print("영어> ");
					stu[2]=sc.nextInt();
					System.out.print("수학> ");
					stu[3]=sc.nextInt();
					data.set(idx, stu);
				}
			}
			if(input==4) {
				System.out.print("삭제할 학번> ");
				input=sc.nextInt();
				int idx=-1;
				for(idx=0; idx<data.size(); idx++) {
					int[] stu=(int[])(data.get(idx));
					if(stu[0]==input)break;
				}
				if(data.size()!=idx) data.remove(idx);
			}
			
			
			
			
//			if(input==1) {
//				for(int i=0; i<data.size(); i++) {
//					System.out.println(data.get(i++)+"\t"+data.get(i++)
//									+"\t"+data.get(i++)+"\t"+data.get(i));
//				}
//			}
//			if(input==2) {
//				System.out.print("학번> ");
//				input=sc.nextInt();
//				data.add(input);
//				System.out.print("국어> ");
//				input=sc.nextInt();
//				data.add(input);
//				System.out.print("영어> ");
//				input=sc.nextInt();
//				data.add(input);
//				System.out.print("수학> ");
//				input=sc.nextInt();
//				data.add(input);
//			}
		}
	}

}








