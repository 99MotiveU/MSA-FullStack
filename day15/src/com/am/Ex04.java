package com.am;

import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Frame;
import java.util.Scanner;

public class Ex04 extends Frame {

	
	public static void main(String[] args) {
		Ex04 me = new Ex04();
		CardLayout mgr = new CardLayout();
		
		me.setLayout(mgr);
		
		me.add(new Button("btn1"));
		me.add(new Button("btn2"));
		me.add(new Button("btn3"));
		me.add(new Button("btn4"));
		
		
		me.setLocation(100,100);
		me.setSize(300,500);
		me.setVisible(true);
		Scanner sc = new Scanner(System.in);
		while(true) {
			sc.nextLine();
			mgr.next(me);
		}

	}

}
