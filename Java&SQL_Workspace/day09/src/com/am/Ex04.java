package com.am;

// 인터페이스
// 오직 추상메서드만을 갖는 ...
// 다음의 키워드 생략이 가능 (public,abstract,static)
// 필드,생성자 (X)
// 다형성 극대화
interface Inter05{}
interface Inter01 extends Inter02{
	public static int su1=1111;
	public int su2=2222;
	int su3=3333;
	
	public abstract void func01();
	public void func02();
	void func03();
}
interface Inter02{
	void func01();//구현 필요
}
interface Inter03{
	void func02();//구현 필요
}
//interface Inter04 extends Inter02,Inter03{
//	void func03();//구현 필요 -인터페이스 따로 만듬
//}

public class Ex04 extends Object implements Inter02,Inter03{

	public static void main(String[] args) {
		Ex04 me = new Ex04();
		me.func01();
		Object me2 =new Ex04();
		//me2.func01(); 불가
		Inter02 me3 = new Ex04();
		me3.func01();
		Inter03 me4 =new Ex04();
		me4.func02();
		

	}

	@Override
	public void func01() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void func02() {
		// TODO Auto-generated method stub
		
	}

}










