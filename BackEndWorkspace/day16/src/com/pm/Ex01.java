package com.pm;

import java.awt.Button;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Panel;

public class Ex01 extends Frame{
	TextField tf;
	Button btn;
	Panel p;
	
	class MyListen implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
//			System.out.println("클릭");
//			tf.setText("");
//			tf.setText("");
//			tf.revalidate();
			System.out.println(e.getSource());// 이벤트가 일어난 컴포넌트 자신
			Component com=e.getComponent();
//			Frame me=(Frame) e.getSource();
//			me.dispose();
			System.out.println(e.getX()+","+e.getY());
			System.out.println(e.getXOnScreen()+","+e.getYOnScreen());
			if(btn==e.getSource())System.out.println("버튼");
			if(p==e.getSource())System.out.println("panel");
			}

		@Override
		public void mousePressed(MouseEvent e) {
//			System.out.println("누를때");
			}

		@Override
		public void mouseReleased(MouseEvent e) {
//			System.out.println("눌리고나서위로올라올때");
			}

		@Override
		public void mouseEntered(MouseEvent e) {
//			System.out.println("컴포넌트 안쪽로");
			}

		@Override
		public void mouseExited(MouseEvent e) {
//			System.out.println("컴포넌트 밖으로");
		}
		
	}

	public Ex01() {
		p=new Panel();
		tf=new TextField("초기값");
		btn=new Button("click");
		p.add(tf);
		p.add(btn);
		add(p);
		p.addMouseListener(new MyListen());
		btn.addMouseListener(new MyListen());
		setBounds(1920+100,100,400,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex01();

	}

}
