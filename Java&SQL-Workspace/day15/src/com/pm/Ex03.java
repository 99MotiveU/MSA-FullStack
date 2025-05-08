package com.pm;

import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.Panel;

public class Ex03 extends Frame{
	
	public Ex03() {
		Panel p=new Panel();
		
		TextArea ta=new TextArea("�ʱⰪ\ndefault",5,20, TextArea.SCROLLBARS_VERTICAL_ONLY);
		p.add(ta);
		
		add(p);
		setLocation(100,100);
		setSize(500,400);
		setVisible(true);
	}

	public static void main(String[] args) {
		new  Ex03();

	}

}
