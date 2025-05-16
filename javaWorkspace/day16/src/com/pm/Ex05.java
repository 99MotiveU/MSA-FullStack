package com.pm;

import java.awt.Frame;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Ex05 extends Frame implements KeyListener{
	JLabel la;
	
	public Ex05() {
		setLayout(null);
		Image img=Toolkit.getDefaultToolkit().getImage("logo.jpg");
		Icon icon=new ImageIcon(img);
		la=new JLabel(icon);
		la.setBounds(10, 50, 70, 50);
		la.setVisible(true);
		this.addKeyListener(this);
		add(la);
		setBounds(100,100,500,300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Ex05();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		Point point = la.getLocation();
		int x=point.x;
		int y=point.y;
		if(e.getKeyCode()==39&&x+10<=500-70)
			x+=10;
		if(e.getKeyCode()==40&&y+10<=300-50)
			y+=10;
		if(e.getKeyCode()==37&&x-10>=0)
			x-=10;
		if(e.getKeyCode()==38&&y-10>=0+40)
			y-=10;
		la.setLocation(x,y);
		
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}


}
