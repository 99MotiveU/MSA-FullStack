package com.am;

public class Ex02 {
	private static class MyErr extends Exception{
		public MyErr(String msg) {
			super(msg);
		}
	}

	public static void main(String[] args) {
		//학생성적관리프로그램(ver 0.10.0)
		java.util.Scanner sc;
		sc=new java.util.Scanner(System.in);
		System.out.println("학생성적관리프로그램(ver 0.10.0)");
		int input=-1;
	
		
		int tot=0;
		int[][] data=new int[tot][];
		int cnt=0;
	
		while(true) {
			System.out.print("1.보기 2.입력 3.수정 4.삭제 0.종료> ");
			try {
				input=Integer.parseInt(sc.nextLine());
			}catch (NumberFormatException e) {
				System.out.println("입력이 잘못됐습니다");
				continue;
			}
			if(input==0)break;
			if(input==1) {
				System.out.println("--------------------------------");
				System.out.println("학번\t국어\t영어\t수학");
				System.out.println("--------------------------------");
				for(int i=0; i<data.length; i++) {
					int[] stu=data[i];
					if(stu!=null)System.out.println(stu[0]+"\t"+stu[1]+"\t"+stu[2]+"\t"+stu[3]);
				}
				System.out.println("--------------------------------");
			}
			if(input==2) {
				int[][] temp=data;
				data=new int[data.length+1][];
				for(int i=0; i<temp.length; i++) {
					data[i]=temp[i];
				}
				
				int[] stu=new int[4];
				String[] arr1= {"국어","영어","수학"};
				
				stu[0]=cnt+202501;
				for(int i=1; i<stu.length; i++) {
					System.out.print(arr1[i-1]+"> ");
					try {
						stu[i]=Integer.parseInt(sc.nextLine());
						if(stu[i]<0||stu[i]>100) throw new MyErr("점수범위가 아닙니다");
					}catch (NumberFormatException e) {
						System.out.println("입력이 잘못됐습니다");
						i--;
						continue;
					} catch (MyErr e) {
						System.out.println(e.getMessage());
						i--;
						continue;
					}
				}
				
				data[cnt++]=stu;
			}
			if(input==3) {
				System.out.print("수정할 학번> ");
				int num2=Integer.parseInt(sc.nextLine());
				int idx=-1;
				for(int i=0; i<data.length; i++) {
					int[] stu=data[i];
					if(num2==stu[0])idx=i;
				}
				if(idx!=-1){
					int[] stu=new int[4];
					String[] arr1= {"국어","영어","수학"};
					
					stu[0]=num2;
					for(int i=1; i<stu.length; i++) {
						System.out.print(arr1[i-1]+"> ");
						try {
							stu[i]=Integer.parseInt(sc.nextLine());
							if(stu[i]<0||stu[i]>100) throw new MyErr("점수범위가 아닙니다");
						}catch (NumberFormatException e) {
							System.out.println("입력이 잘못됐습니다");
							i--;
							continue;
						} catch (MyErr e) {
							System.out.println(e.getMessage());
							i--;
							continue;
						}
					}
					data[idx]=stu;
				}
			}
			if(input==4) {
				System.out.print("삭제할 학번> ");
				int num2=Integer.parseInt(sc.nextLine());
				int idx=-1;
				for(int i=0; i<data.length; i++) {
					int[] stu=data[i];
					if(num2==stu[0])idx=i;
				}
				if(idx!=-1){
					int[][] before=data;
					data=new int[before.length-1][];
	//				for(int i=0; i<idx; i++) {
	//					data[i]=before[i];
	//				}
	//				for(int i=idx+1; i<before.length; i++) {
	//					data[i-1]=before[i];
	//				}
					System.arraycopy(before, 0, data, 0, idx);
					System.arraycopy(before, idx+1, data, idx, before.length-idx-1);
				}else {
					System.out.println("존재하지 않는 학번입니다");
				}
			}
		}

	}

}

























