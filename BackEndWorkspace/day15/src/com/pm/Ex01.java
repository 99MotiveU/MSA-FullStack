package com.pm;

import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;
import java.util.Scanner;

public class Ex01 extends Frame {
	

	public Ex01() {
		Panel p = new Panel();
		TextField tf = new TextField("기본값",10); // 글자갯수(어떤 폰트)
//		tf.setText("글자");
		System.out.println(tf.getText());
//		tf.setFont(new Font("",0,50));
//		tf.setBackground(c);
//		tf.setForeground(c);
		tf.setEchoChar('#');// 비밀번호 등에 사용
		
		p.add(tf);
		add(p);
		setLocation(100, 100);
		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		Ex01 me =  new Ex01();

		
	}

}
