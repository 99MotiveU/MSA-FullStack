package com.am;

public class Ex08 {

	public static void main(String[] args) {
		double su1=3.14;
		Double su2=3.14;
		Double su3=new Double(3.14);
		Double su4=new Double("3.14");
		System.out.println(Double.parseDouble("3.14")+1);
		double a=5;
		double b=0;
		System.out.println(Double.isInfinite(a/b));
		System.out.println(Double.isNaN(a/b));
		a=0;
		System.out.println(Double.isInfinite(a/b));
		System.out.println(Double.isNaN(a/b));
	}

}





