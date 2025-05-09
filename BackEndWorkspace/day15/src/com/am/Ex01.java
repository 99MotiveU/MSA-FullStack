package com.am;

import java.awt.Frame;

import javax.swing.JFrame;

public class Ex01 {//extends java.awt.Frame //extends javax.swing.JFrame 

	public static void main(String[] args) {
		/*
		 awt
		- 자바 초기 gui
		- 운영체제 종속
		- 자바가 직접 x
		- os 지원외 한계
		*/
//		Ex01  me = new Ex01();
		java.awt.Frame me1 = new Frame();
		me1.setVisible(true);
		/*
		 swing
		- awt 다음 gui
		- 운영체제 비종속
		- 자바가 직접 제작
		- os 지원외의 기능도 직접 구현
		*/
		javax.swing.JFrame me2 = new JFrame();
		me2.setVisible(true);

	}

}
