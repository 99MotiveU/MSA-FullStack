package com.pm;

import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		// 주민번호 체크기(ver 0.1.0)
		// 주민번호를 입력> 991231-1234567
		// 당신은 27세 남성입니다
		// 주민번호를 입력> 001231-4234567
		// 당신은 26세 여성입니다
		//////////////////////////////
		// 주민번호를 입력> 9912311234567
		// 입력포멧을 다시 확인하세요 (000000-0000000)
		// 다시 입력> 991231-123456
		// 입력포멧을 다시 확인하세요 (000000-0000000)
		// 다시 입력> a91231-1234567
		// 숫자만 입력하세요
		// 번외 : 한글지원
		
		char[] role= {'영','일','이','삼','사','오','육','칠','팔','구'};
		char[] target=new char[10];
		for(int i=0; i<target.length; i++) {
			target[i]=(char)('0'+i);
		}
		
		Scanner sc =new Scanner(System.in);
		char gender='여';
		int age=0;
		boolean boo1=true,boo2=false;
		while(boo1) {
			boo2=false;
			System.out.print("주민번호를 입력> ");
			String input=sc.nextLine();
			char[] arr1=input.toCharArray();
			
			for(int i=0; i<arr1.length; i++) {
				for(int j=0; j<role.length; j++) {
					if(arr1[i]==role[j]) {arr1[i]=target[j];}
				}
			}
			
			for(int i=0;i<arr1.length; i++) {
				if(i!=6&&(arr1[i]<'0'||arr1[i]>'9')) {boo2=true;}
			}
			
			if(arr1[6]!='-') {
				System.out.println("입력포멧을 다시 확인하세요 (000000-0000000)");
			}else if(arr1.length!=14) {
				System.out.println("입력포멧을 다시 확인하세요 (000000-0000000)");
			}else if(boo2) {
				System.out.println("숫자만 입력하세요");
			}else {
				if(arr1[7]=='1'||arr1[7]=='3') {gender='남';}
				if(arr1[7]=='2'||arr1[7]=='4') {gender='여';}
				int year=1900+(arr1[0]-'0')*10+(arr1[1]-'0')*1;
				if(arr1[7]=='3'||arr1[7]=='4')year+=100;
				age=2025-year+1;
				boo1=false;
			}
		}
		System.out.println("당신은 "+age+"세 "+gender+"성입니다");
		sc.close();
	}

}


















