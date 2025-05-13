package com.am;

class Outter03{
	static int su1=1111;
	int su2=2222;
	
	class Inner03{
		final static int su3=3333;
//		안됨 static int su3=3333;
		//내부클래스라 객체생성 전까지는 없는것 하지만 static이 붙어 메모리에 올라가야하는것 때문에 오류
//		안됨 static void func03() {}
		int su4=4444;
		void func04() {
			System.out.println(su1);
			System.out.println(su2);
			func01();
			func02();
		}
	}//Inner03 end
	
	static void func01() {
//		System.out.println(Inner03.su3);
//		Outter03 me=new Outter03();
//		Inner03 inn=null;
//		inn=me.new Inner03();
//		System.out.println(inn.su4);
//		inn.func04();
	}
	void func02() {
//		System.out.println(Inner03.su3);
//		Inner03 inn=null;
////		inn=this.new Inner03();
//		inn=new Inner03();
//		System.out.println(inn.su4);
	}
}//outter03 end

public class Ex03 {

	public static void main(String[] args) {
		System.out.println(Outter03.Inner03.su3);
		Outter03 outter = new Outter03();
		Outter03.Inner03 inn=null;
		inn=outter.new Inner03();
		System.out.println(inn.su4);
	} // main end

}//end



