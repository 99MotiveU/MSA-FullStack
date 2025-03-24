package com.pm;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;

public class Ex08_3m extends Frame{
	
	public Ex08_3m() {
		Font f=new Font("",0,50);
		Panel p=new Panel();
		p.setLayout(new BorderLayout());
		
		Panel top=new Panel();
		Panel cen=new Panel();
		top.setLayout(new GridLayout());
		cen.setLayout(new GridLayout(5,4));
		
		TextField tf = new TextField();
		tf.setFont(f);
		top.add(tf);
		for(int i=18; i>0; i--) {
			if(i<10) {
				cen.add(new Button(""+i));
			}else if(i==10) {
				cen.add(new Button(""));
			}else if(i==11) {
				cen.add(new Button(""));
			}else if(i==15) {
				cen.add(new Button("<-"));
			}else if(i==16) {
				cen.add(new Button("/"));
			}else if(i==17) {
				cen.add(new Button("*"));
			}else if(i==18) {
				cen.add(new Button("ESC"));
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
		new Ex08_3m();
	}

}
