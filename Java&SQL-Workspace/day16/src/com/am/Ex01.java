package com.am;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;

public class Ex01 {
	public static void main(String[] args) {
		Frame f = new Frame();

		Toolkit kit = Toolkit.getDefaultToolkit();
		kit.beep(); //�������� �����
		
		Image img = kit.getImage("logo.jpg");
		f.setIconImage(img);
		System.out.println(kit.getScreenSize());
		int winW = kit.getScreenSize().width;
		int winH = kit.getScreenSize().height;
		
		
		f.setLocation(winW-400, 100);//ũ�� �����ϼ���.
		Dimension dim = new Dimension(400, 300);
		f.setSize(dim);
		f.setVisible(true);
	}
}
