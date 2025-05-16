package com.pm;

import java.awt.Frame;
import java.awt.GridLayout;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Ex01 extends Frame{

	public Ex01() {
		setLayout(new GridLayout(1,6));
		JLabel[] btns=new JLabel[45];
		
		for(int i=0; i<btns.length; i++) {
			btns[i]=new JLabel();
			String num=i+1+"";
			if(num.length()==1)num="0"+num;
			Icon icon=new ImageIcon("imgs/ball_"+num+".png");
			btns[i].setIcon(icon);
		}
		// 0~19
		Random ran=new Random();
		Set<Integer> set=new TreeSet<>();
		while(set.size()<6) {
			int su=ran.nextInt(45);
			set.add(su);
		}
		Iterator<Integer> ite = set.iterator();
		while(ite.hasNext())
			add(btns[ite.next()]);
		
		setBounds(100,100,600,140);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex01();
	}

}
