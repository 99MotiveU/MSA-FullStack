package com.am;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

//Vector
//Objects
//StringTokenizer
//Scanner
//Properties
//Optional

public class Ex05 {

	public static void main(String[] args) {
		Vector<String> vec=new Vector<>(); // Stack을 사용 할 수 있지만 하지 마세요.
		vec.addElement("1111");
		vec.addElement("2222");
		vec.add("3333");
		vec.add("4444");
		vec.insertElementAt("5555", 2);
		
		for(int i=0; i<vec.size(); i++) {
//			String msg=vec.elementAt(i);
			String msg=vec.get(i);
			System.out.println(msg);
		}
		
		Enumeration<String> enu = vec.elements();
		while(enu.hasMoreElements()) {
			String msg=enu.nextElement();
			System.out.println(msg);
		}
		Iterator<String> ite = vec.iterator();
		while(ite.hasNext()) {
			String msg=ite.next();
			System.out.println(msg);
		}

		System.out.println(vec.firstElement());
		System.out.println(vec.lastElement());
		
		List<String> list=vec.subList(0, 2);
		System.out.println(list);
		Object[] arr2=vec.toArray(); //매개변수 없는 toArray는 사용 안하게됨
		String[] arr3 = new String[arr2.length];
		System.arraycopy(arr2, 0, arr3, 0, arr2.length);
		System.out.println(Arrays.toString(arr3));
		
		String[] arr=vec.<String>toArray(new String[] {});
		System.out.println(Arrays.toString(arr));
	}

}














