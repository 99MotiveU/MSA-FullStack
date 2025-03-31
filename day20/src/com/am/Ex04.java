package com.am;

import java.awt.AWTException;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Ex04 extends Frame {
	
	public Ex04() {
		BufferedImage img=null;
		try {
			Robot robo=new Robot();
			Rectangle screenRect=new Rectangle(1920,0,800,600);
			img=robo.createScreenCapture(screenRect);
			
		} catch (AWTException e) {
			e.printStackTrace();
		}
		JButton btn=new JButton();
		btn.setIcon(new ImageIcon(img));
		add(btn);
		setBounds(1920,100,800,600);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Ex04();
		

	}

}
