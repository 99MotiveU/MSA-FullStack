package com.pm;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;

public class Ex08_2t extends Frame{
	
	public Ex08_2t() {
		Font f=new Font("",0,50);
		Panel p=new Panel();
		p.setLayout(new BorderLayout());
		
		Panel top=new Panel();
		Panel cen=new Panel();
		top.setLayout(new GridLayout());
		cen.setLayout(new GridLayout(4,3));
		
		TextField tf = new TextField();
		tf.setFont(f);
		top.add(tf);
		for(int i=1; i<13; i++) {
			if(i<10) {
				cen.add(new Button(""+i));
			}else if(i==10) {
				cen.add(new Button("*"));
			}else if(i==11) {
				cen.add(new Button("0"));
			}else if(i==12) {
				cen.add(new Button("#"));
			}
		}
		p.add(top,BorderLayout.NORTH);
		p.add(cen,BorderLayout.CENTER);
		add(p);
		setLocation(100,100);
		setSize(300,400);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Ex08_2t();
	}

}
