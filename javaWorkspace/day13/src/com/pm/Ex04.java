package com.pm;

class Lec04{
	
	public static <T> T newInstance(T t) {
		return t;
	}
}

class Lec44{
	public static <T> Box <T> newInstance(T obj) {
		Box<T> box = new Box<T>();
		box.setPen(obj);
		return box;
	}
}

public class Ex04 {

	public static void main(String[] args) {
		String msg1 = Lec04.<String>newInstance("string");
		Box<String> box = Lec44.newInstance("string2");
		String msg2 =box.getPen();
		System.out.println(msg2);
	}

}
