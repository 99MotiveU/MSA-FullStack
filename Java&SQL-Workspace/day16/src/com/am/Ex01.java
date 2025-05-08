package com.am;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;

public class Ex01 {
	public static void main(String[] args) {
		Frame f = new Frame();

		Toolkit kit = Toolkit.getDefaultToolkit();
		kit.beep(); //비프음을 들려줌
		
		Image img = kit.getImage("logo.jpg");
		f.setIconImage(img);
		System.out.println(kit.getScreenSize());
		int winW = kit.getScreenSize().width;
		int winH = kit.getScreenSize().height;
		
		
		f.setLocation(winW-400, 100);//크기 생각하세요.
		Dimension dim = new Dimension(400, 300);
		f.setSize(dim);
		f.setVisible(true);
	}
}
