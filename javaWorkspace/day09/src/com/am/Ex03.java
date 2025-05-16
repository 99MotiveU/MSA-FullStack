package com.am;

class Lec03{
	public int su1=1111;
	protected int su2=2222;
	int su3=3333;
	private int su4=4444;
}
// protected
// 동일 패키지에서만 접근을 허용(==default)
// 단, 상속을 통해서 접근허용
//public > protected >= default > private
public class Ex03 extends com.am.child.Lec02{

	public static void main(String[] args) {
//		com.am.child.Lec02 par;
//		par=new com.am.child.Lec02();
		Ex03 par=new Ex03();
		System.out.println("public :"+par.su1);
		System.out.println("protected :"+par.su2);
//		System.out.println("default :"+par.su3);
//		System.out.println("private :"+par.su4);

	}

}












