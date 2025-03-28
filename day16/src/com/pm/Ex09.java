package com.pm;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ex09 extends Frame implements ActionListener{

	public Ex09() {
		Panel p=new Panel();
		TextField tf=new TextField();
		Button btn=new Button("¹öÆ°");
		List cho=new List();
		cho.add("item1");
		cho.add("item2");
		cho.add("item3");
		cho.add("item4");
		p.add(tf);
		p.add(btn);
		p.add(cho);
		cho.addActionListener(this);
		add(p);
		setBounds(100,100,500,300);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Ex09();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
	}

}
