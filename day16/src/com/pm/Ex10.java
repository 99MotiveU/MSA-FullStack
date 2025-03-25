package com.pm;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex10 extends JFrame implements ActionListener {
	
	public Ex10() {
		setLayout(new BorderLayout());
		Panel center=new Panel();
		Panel down2=new Panel();
		Panel down=new Panel();
		down.setSize(130*3,150);
		down.setLayout(null);
		down.setBackground(Color.GREEN);
		Image img1=Toolkit.getDefaultToolkit().getImage("1.jpg");
		Image img2=Toolkit.getDefaultToolkit().getImage("2.jpg");
		Image img3=Toolkit.getDefaultToolkit().getImage("3.jpg");
		JButton btn1=new JButton("가위",new ImageIcon(img1));
		JButton btn2=new JButton("바위",new ImageIcon(img2));
		JButton btn3=new JButton("보",new ImageIcon(img3));
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		
		btn1.setLocation(130*0, 0);
		btn2.setLocation(130*1, 0);
		btn3.setLocation(130*2, 0);
		btn1.setSize(120, 130);
		btn2.setSize(120, 130);
		btn3.setSize(120, 130);
		btn1.setVisible(true);
		btn2.setVisible(true);
		btn3.setVisible(true);
		down.add(btn1);
		down.add(btn2);
		down.add(btn3);

		down2.add(down);
		add(center,BorderLayout.CENTER);
		add(down2,BorderLayout.SOUTH);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(1920+100, 100, 500, 500);
		setVisible(true);
		revalidate();
	}

	public static void main(String[] args) {
		// 가위바위보게임(ver 0.10.0)
		new Ex10();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(((JButton)e.getSource()).getActionCommand());
		
	}

}
