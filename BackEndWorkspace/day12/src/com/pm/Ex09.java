package com.pm;

import java.util.Enumeration;
import java.util.Vector;

public class Ex09 {

	public static void main(String[] args) {
		// Vector
		Vector list = new Vector();
		list.addElement("첫번째");
		list.addElement("두번째");
		list.addElement("세번째");
		list.addElement("네번째");

//		System.out.println(list.elementAt(0));
//		System.out.println(list.elementAt(1));
//		System.out.println(list.elementAt(2));
//		System.out.println(list.elementAt(3));

		Enumeration enu = list.elements();
		while (enu.hasMoreElements()) {
			System.out.println(enu.nextElement());
		}
		enu = list.elements();
		while(enu.hasMoreElements()) {
			System.out.println(enu.nextElement());
		}
	}

}
