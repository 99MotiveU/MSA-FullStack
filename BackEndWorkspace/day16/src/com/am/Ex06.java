package com.am;

import javax.swing.JFrame;

public class Ex06 extends JFrame{
	
	public Ex06() {
//		addWindowListener(new Ex05.MyListener());
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100,100,300,200);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Ex06();

	}

}
