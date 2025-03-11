package com.am;

import java.util.Scanner;

class Student{
	public int kor,eng,math,tot;
	public double avg;
	
	public Student(int a, int b, int c) {
		kor=a;
		eng=b;
		math=c;
		tot=a+b+c;
		setTot();
		setAvg();
	}
	
	public void setTot() {
		tot=kor+eng+math;
	}
	
	public void show() {
		System.out.println(kor+"\t"+eng+"\t"+math+"\t"+tot);
	}
	
	public void setAvg() {
		avg=tot*100/3/100.0;
	}
}

public class Ex03 {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int kor = userInput("국어");
		int eng = userInput("영어");
		int math = userInput("수학");
		Student stu=new Student(kor,eng,math);
		System.out.println("------------------------------------");
		System.out.println("국어\t영어\t수학\t합계\t평균");
		System.out.println("------------------------------------");
		System.out.println(stu.kor+"\t"+stu.eng+"\t"+stu.math+"\t"+stu.tot+"\t"+stu.avg);
		System.out.println("------------------------------------");
	}//main end
	
	public static int userInput(String msg) {
		System.out.println(msg+"> ");
		return sc.nextInt();
		
	}

}
