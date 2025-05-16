package com.pm;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Ex03 {
	int su1=1111;
	int su2=2222;
	
	public Ex03() {
		// TODO Auto-generated constructor stub
	}
	
	public Ex03(int a) {}

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		// 클래스의 정보를 갖는 객체
		Class ex03=Ex03.class;				// 클래스를 있을 때
		System.out.println(ex03);
		Class clz;
		clz=Class.forName("com.pm.Ex22");	// 클래스를 없을 때
		System.out.println(clz);
		
		Constructor[] constructs = ex03.getConstructors();
		for(int i=0; i<constructs.length; i++) {
			System.out.println(constructs[i]);
		}
		Field[] arr2 = ex03.getDeclaredFields();
		for(int i=0; i<arr2.length; i++) {
			System.out.println(arr2[i]);
		}
		Method[] arr3 = ex03.getDeclaredMethods();
		for(int i=0; i<arr3.length; i++) {
			System.out.println(arr3[i]);
		}
		
		Ex22 me;
		me=(Ex22)(clz.newInstance());
//		me=new Ex22();
		System.out.println(me.su);
		me.func01();
	}

}
















