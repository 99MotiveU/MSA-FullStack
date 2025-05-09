package com.am;

public class Ex06 {

	public static void main(String[] args) throws ClassNotFoundException {
		Object obj = new Object();
//		obj.clone();
		Object obj2 = new Object();
		Object obj3 = obj;
		System.out.println(obj.equals(obj2));
		System.out.println(obj.equals(obj3));
		
		Class clz = obj.getClass();
		Ex06 me = new Ex06();
		Class clz2 =me.getClass();
		Class clz3 = Ex06.class;
		Class clz4 = Class.forName("com.am.Ex06");
		System.out.println(clz);
		System.out.println(obj);
		System.out.println(obj.hashCode());
		System.out.println(obj.toString());
		

	}

}
