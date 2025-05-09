package com.am;

public class Ex01 {
	
	//public Ex01() {}  디폴트 생성자
	//public Ex01(String msg) {System.out.println(msg);} 매개변수가 하나라도 들어가면 디폴트 생성자는 사라진다.
	public Ex01() {
//		System.out.println("객체가 생성되는 생성자");
//		System.out.println("객체 생성");
//		System.out.print("매개변수 없음");
//		System.out.println("객체 생성 이전"); this()는 생성자 맨 상단에 위치
		this("없음");
		System.out.println("이후 일 진행"); 
		System.out.println(this);//생성자의 호출 this()와는 다른것임
	}
	public Ex01(int su) {
//		System.out.println("객체 생성");
//		System.out.print("매개변수 ");
//		System.out.println("숫자 : "+su);
//		System.out.println("객체 생성 이전"); this()는 생성자 맨 상단에 위치
		this("숫자 : " + su);
		System.out.println("이후 일 진행");
	}
	public Ex01(String msg) {
		System.out.println("객체가 생성되는 생성자");
		System.out.println("객체 생성");
		System.out.print("매개변수 ");
		System.out.println("문자열 : "+msg);
//		this(); 생성자들중 하나라도 this()이용한 호출이 없는게 존재 해야한다.
	}
	Ex01 me2;  //Ex01 me2 = null;
	public static String msg; // =null, 객체 자체가 없음, 주소값 없음
	public static String msg2=""; //객체는 있는데 item(문자)가 없음
	
	public static void main(String[] args) {
		Ex01 me = new Ex01();
		Ex01 me1 = new Ex01("Hello"); //참조 변수 (클래스 타입)의 디폴트값은 null
		char ch = '\u0000'; //문자 null
		Ex01 me2 =null; // 키워드 상의 null
		me=new Ex01("유니코드 0=> "+ch); 
		me=new Ex01("유니코드 0=> "+me2); 
		me=new Ex01(msg);
		//msg.length(); 
		msg2.length();
		me = new Ex01(123);
		me=new Ex01("문자열");
	
	}

}
