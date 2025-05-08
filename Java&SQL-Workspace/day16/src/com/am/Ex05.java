package com.am;

import java.awt.Dialog;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Scanner;



public class Ex05 extends Frame {
	static Ex05 me;
	static Dialog dia;
	
	static class MyListener implements WindowListener{

		@Override
		public void windowOpened(WindowEvent e) {
			System.out.println("창열림");
		}

		@Override
		public void windowClosing(WindowEvent e) {
			System.out.println("창닫기버튼누름");
//			dia.setVisible(true);
////			System.exit(0);
			me.dispose();//UI종료 요청
		}

		@Override
		public void windowClosed(WindowEvent e) {
			System.out.println("UI종료시 후행작업");
		}

		@Override
		public void windowIconified(WindowEvent e) {
			System.out.println("아이콘화-최소화됨");
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			System.out.println("비아이콘화-최소화에서 풀림");
		}

		@Override
		public void windowActivated(WindowEvent e) {
			System.out.println("활성화");
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			System.out.println("비활성화");
		}
		
	}

	public Ex05() {
		WindowListener listener=new MyListener();
		addWindowListener(listener);
		setBounds(1920+600,100,300,200);
		setVisible(true);
		
		dia=new Dialog(this);
		dia.addWindowListener(listener);
		dia.setBounds(1920+600,500,200,200);
//		dia.setVisible(true);
	}
	public static void main(String[] args) {
		me=new Ex05();
//		Scanner sc=new Scanner(System.in); sc.nextLine();
		System.out.println("main return 됨 - 멀티쓰레드 - 동시작업");
	}

}













