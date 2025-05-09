package com.am;

public class Ex09 {

	public static void main(String[] args) {
		boolean boo1=true;
		Boolean boo2=true;
		Boolean boo3=new Boolean(boo1);
		Boolean boo4=new Boolean("true");
		Boolean boo5=new Boolean("TRUE");
		Boolean boo6=new Boolean("True");
		//언어마다 쓰는 패턴이 다른데 문자열로 했을떄는 몇가지 지원하는것들이 있다(대소문자 구분 등)
		Boolean boo7=Boolean.TRUE;
		System.out.println(boo6==Boolean.TRUE);

	}

}


