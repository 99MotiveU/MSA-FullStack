package com.pm;

class Lec03{
	public static <T> T func01(T obj) {
		return obj;
	}
}

public class Ex03 {

	public static void main(String[] args) {
		String msg = "static";
		
//		Lec03.<String>func01(null);
		
		String msg1= Lec03.<String>func01(null);
//		String msg2= Lec03.func01("");
//		String msg3= Lec03.func01(null);
//		System.out.println(msg2);

	}

}
