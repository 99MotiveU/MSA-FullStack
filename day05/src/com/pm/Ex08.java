package com.pm;

public class Ex08 {

	public static void main(String[] args) {
		System.out.println(com.am.Ex07.func02()); 
		System.out.println(func02());  //com.pm.Ex08.func02()
			//패키지로 파일 위치 구분 -생략된것임
		com.pm.Ex08 me = new Ex08();
		System.out.println(me.func03());
		me.func04(me);
	}
	public static String func02() {
		return "난 아니지롱~~~";
	}
	
	public String func03() {
		return "non-static";
	}
	
	public void func04(Ex08 me) {
		System.out.println("아래는 func04 호출");
		System.out.println(me.func03());
		System.out.println(this.func03());
		System.out.println(me==this);
		//새로 객체를 만들면 당연히 다르다.
		com.pm.Ex08 me1 = new Ex08();
		System.out.println(me1==this); //레퍼런스 비교 (주소값 비교)
		//if래퍼런스 비교를 해서 같으며 같은 객체를 가리키고 있는것
	}
		
}
