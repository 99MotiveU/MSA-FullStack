package com.pm;

class Lec05<T>{
	
	public T pass(T t) { return t;}
	
}

public class Ex05 {
	
	public Ex05() {
		System.out.println("default");
	}
	public Ex05(int su) {
		System.out.println("argument 1 :"+su);
	}
	public Ex05(Integer su) {
		System.out.println("argument 1 :"+su);
	}

	public static void main(String[] args) throws Exception{
//		Lec05<String> you=new Lec05();
//		Lec05 you=new Lec05<String>();
//		Lec05<String> you=new Lec05<>();
		Lec05<?> you=new Lec05<>();
		Lec05<String>you2=(Lec05<String>) you;
		String msg=you2.pass("aaaaaa");
		System.out.println(msg);
		
		Class<?> clz=Class.forName("com.pm.Ex05");
		Class<Ex05> clz2=(Class<Ex05>) clz;
//		Ex05 me=clz2.newInstance();
		Ex05 me=clz2.getDeclaredConstructor(int.class).newInstance(1111);
		System.out.println(me);

	}

}










