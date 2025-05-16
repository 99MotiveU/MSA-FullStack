package com.pm;

import java.awt.Frame;
import java.awt.GridLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Ex02 extends Frame{

	public Ex02() {
		setLayout(new GridLayout());
		JLabel[] btns=new JLabel[45];
		for(int i=0; i<btns.length; i++) {
			btns[i]=new JLabel();
			String num=i+1+"";
			if(num.length()==1)num="0"+num;
			Icon icon=new ImageIcon("imgs/ball_"+num+".png");
			btns[i].setIcon(icon);
			add(btns[i]);
		}
		
		
		setBounds(100,100,600,100);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex02();
	}

}
