package com.am;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ex01 extends Frame implements ActionListener{
	public Ex01() {
		Button btn=new Button("your name?");
		btn.addActionListener(this);
		add(btn);
		setBounds(1920+100,100,500,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// ¾²·¹µå
		new Ex01();
		System.out.println(Thread.currentThread().getName());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(Thread.currentThread().getName());
	}

}
