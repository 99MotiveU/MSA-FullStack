package com.pm;

import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Ex02 implements MouseListener{
	static JLabel la=new JLabel("*");

	public static void main(String[] args) {
		Image img=Toolkit.getDefaultToolkit().getImage("logo.jpg");
		Icon icon=new ImageIcon(img);
		la.setIcon(icon);
		la.setSize(50, 50);
		la.setVisible(true);
		Frame f=new Frame();
		f.setLayout(null);
		f.add(la);
		f.addMouseListener(new Ex02());
		f.setBounds(1920+100,100,800,600);
		f.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		la.setLocation(e.getX(), e.getY());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}
