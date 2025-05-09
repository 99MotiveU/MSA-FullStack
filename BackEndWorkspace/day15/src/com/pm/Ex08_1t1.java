package com.pm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

public class Ex08_1t1 extends Frame{
	
	public Ex08_1t1() {
		setLayout(new GridLayout(2,1));
		Panel p1=new Panel();
		Panel p2=new Panel();
		p2.setLayout(new BorderLayout());
		
		p1.setLayout(new GridLayout(5,1));
		FlowLayout fl =new FlowLayout();
		fl.setAlignment(FlowLayout.LEFT);
		Panel row1=new Panel(fl);
		row1.add(new Label("이름"));
		row1.add(new TextField(20));
		p1.add(row1);
		Panel row2=new Panel(fl);
		row2.add(new Label("아이디"));
		row2.add(new TextField(20));
		p1.add(row2);
		Panel row3=new Panel(fl);
		row3.add(new Label("비밀번호"));
		row3.add(new TextField(20));
		p1.add(row3);
		Panel row4=new Panel(fl);
		row4.add(new Label("전화번호"));
		row4.add(new TextField(6));
		row4.add(new Label("-"));
		row4.add(new TextField(6));
		row4.add(new Label("-"));
		row4.add(new TextField(6));
		p1.add(row4);
		Panel row5=new Panel(fl);
		row5.add(new Label("취미"));
		p1.add(row5);
		
		p2.add(new Label("하고자하는말"),BorderLayout.NORTH);
		p2.add(new TextArea(),BorderLayout.CENTER);
		add(p1);
		add(p2);
		
		setLocation(100,100);
		setSize(400,600);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Ex08_1t1();

	}

}
