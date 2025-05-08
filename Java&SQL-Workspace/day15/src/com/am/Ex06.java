package com.am;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;

public class Ex06 extends Frame{
	
	public Ex06() {
		Panel p=new Panel();
		p.setLayout(null);
		Button btn1=new Button("btn1");
		btn1.setLocation(150, 100);
		btn1.setSize(100,50);
		p.add(btn1);
		add(p);
		
		setLocation(100,100);
		setSize(400,300);
		setVisible(true);
//		setEnabled(false);
		setResizable(false);
		System.out.println(this.getWidth()-p.getWidth());
		System.out.println(this.getHeight()-p.getHeight()-7);
	}

	public static void main(String[] args) {
		new Ex06();
	}

}
