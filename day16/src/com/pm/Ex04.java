package com.pm;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Ex04 extends Frame implements KeyListener {
	// 포커스가 가능한 컴포넌트
	public Ex04() {
		setLayout(new FlowLayout());
		Label la=new Label("test");
		TextField tf=new TextField(10);
		Button btn=new Button();
		this.addKeyListener(this);
		add(la);
//		add(btn);
//		add(tf);
		setBounds(100,100,500,300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Ex04();

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// 키보드 눌린
//		System.out.println(e.getKeyChar());//abcdA
//		System.out.println(e.getKeyCode());//0
//		TextField target=(TextField)e.getSource();
//		System.out.println(target.getText());
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// 키보드 누르는
//		System.out.println(e.getKeyChar());//
//		System.out.println(e.getKeyCode());//대문자기준
//		TextField target=(TextField)e.getSource();
//		System.out.println(target.getText());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//  키보드 눌렸다 때는순간
		System.out.println(e.getKeyChar());//
		System.out.println(e.getKeyCode());//
//		TextField target=(TextField)e.getSource();
//		System.out.println(target.getText());// 안밀림
		}

}
