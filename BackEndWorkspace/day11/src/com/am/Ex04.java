package com.am;

class Outter04{
	static int su3=3000;
	int su4=4000;
	public final static int su01=1000;
	public int su02=2000;
	static void func03() {}
	void func04() {}
	
	// local class : ~jdk1.7 반드시 final, jdk1.8~ final생략가능
	static void func01(final int su05) {
//		final int su05=5555;
//		su05++;
		class Local01{// 접근제한자x
			public final static int su01=1111;//final이면 램의 상수영역에 저장되므로 가능해짐
			public int su02=2222;
			public void func01() {
				System.out.println(Outter04.su01);
				System.out.println(this.su02);
				System.out.println(Local01.su01);
				System.out.println(new Outter04().su02);
				func02();
				func03();
				Outter04 outt=new Outter04();
				outt.func04();
				System.out.println(su05);
			}
			public void func02() {}
		}
		System.out.println(su05);
		Local01 loc=new Local01();
		System.out.println(Local01.su01);
		System.out.println(loc.su02);
		loc.func01();
		System.out.println(su05);
	}
	void func02() {
		Outter04 outt=this;
		class Local02{// 접근제한자x
			public final static int su01=1111;
			public int su02=2222;
			public void func01() {
				System.out.println(Local02.su01);
				System.out.println(this.su02);
				System.out.println(Outter04.su01);
				System.out.println(outt.su02);
				func02();
				func03();
				func04();
			}
			public void func02() {}
		}//상동
		new Local02().func01();
	}
}

public class Ex04 {

	public static void main(String[] args) {
		new Outter04().func02();
//		Outter04.func01(5555);
	}

}



