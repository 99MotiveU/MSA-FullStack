package com.am;

import java.awt.Frame;

import javax.swing.JFrame;

public class Ex01 {//extends java.awt.Frame //extends javax.swing.JFrame 

	public static void main(String[] args) {
		/*
		 awt
		- �ڹ� �ʱ� gui
		- �ü�� ����
		- �ڹٰ� ���� x
		- os ������ �Ѱ�
		*/
//		Ex01  me = new Ex01();
		java.awt.Frame me1 = new Frame();
		me1.setVisible(true);
		/*
		 swing
		- awt ���� gui
		- �ü�� ������
		- �ڹٰ� ���� ����
		- os �������� ��ɵ� ���� ����
		*/
		javax.swing.JFrame me2 = new JFrame();
		me2.setVisible(true);

	}

}
