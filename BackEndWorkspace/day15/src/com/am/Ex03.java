package com.am;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;

public class Ex03 extends Frame{

	public Ex03() {
		BorderLayout mgr=new BorderLayout();
		setLayout(mgr);
		
		Panel p1=new Panel();//div
		Panel p2=new Panel();
		Panel p3=new Panel();
		Panel p4=new Panel();
		
		Button btn1=new Button("North");
		Button btn2=new Button("South");
		Button btn3=new Button("East");
//		Button btn4=new Button("West");
		Button btn5=new Button("Center");
		p1.setLayout(new GridLayout(1,3));
		p2.setLayout(new FlowLayout());
		p1.add(btn1);
		p1.add(btn2);
		p1.add(btn3);
		p2.add(btn5);
		
		
		add(p1,BorderLayout.NORTH);
//		add(btn2,BorderLayout.SOUTH);
//		add(btn3,BorderLayout.EAST);
//		add(btn4,BorderLayout.WEST);
		add(p2,BorderLayout.CENTER);
		
		setLocation(1920+100,100);
		setSize(500,400);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Ex03();
	}

}
