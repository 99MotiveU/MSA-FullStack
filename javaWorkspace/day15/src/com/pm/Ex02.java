package com.pm;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

import javax.swing.JLabel;


public class Ex02 {

	public static void main(String[] args) {
		Panel p=new Panel();
		Frame f=new Frame();
		
		Label la=new Label("力格:");
		TextField tf=new TextField(10);
		Button btn=new Button("茫扁");
		JLabel la2=new JLabel("力格");
		p.add(la);
		p.add(tf);
		p.add(btn);
		p.add(la2);
		
		f.add(p);
		f.setLocation(100, 100);
		f.setSize(300,300);
		f.setVisible(true);
	}

}
