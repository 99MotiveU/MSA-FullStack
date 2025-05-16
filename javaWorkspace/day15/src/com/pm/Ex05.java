package com.pm;

import java.awt.Frame;
import java.awt.List;
import java.awt.Panel;

public class Ex05 extends Frame{
	
	public Ex05() {
		Panel p=new Panel();
		
		List list = new List(4, true); 
		list.add("item1");
		list.add("item2");
		list.add("item3");
		list.add("item4");
		list.add("item5");
		list.add("item6");
	
		list.select(1);
//		list.remove(2);
		
		p.add(list);
		add(p);
		setLocation(100,100);
		setSize(300,400);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Ex05();

	}
}