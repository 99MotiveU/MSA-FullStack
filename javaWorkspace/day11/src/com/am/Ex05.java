package com.am;

interface Parent{
	void func02();
}
class Lec05{
	static Parent par1=new Parent(){
		public void func02() {
			System.out.println("내부클래스의 기능수행");
		}
	};
	Parent par2=new Parent(){
		public void func02() {
			System.out.println("내부클래스의 기능수행");
		}
	};
	
	
// 클로저
	static Parent func01() {
//		local.func02();
		// 익명클래스
		Parent local=new Parent(){
			public void func02() {
				System.out.println("내부클래스의 기능수행");
			}
		};
		
		Parent local2=()->System.out.println("람다식");
		
		return local2;
	}
}

public class Ex05 {

	public static void main(String[] args) {
		// 익명클래스
		Parent local=Lec05.func01();
		local.func02();
		
//		Lec05.par1.func02();
	}

}
