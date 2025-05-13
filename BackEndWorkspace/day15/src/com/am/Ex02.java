package com.am;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;

public class Ex02 extends Frame{
	
	// 1. 배치관리자 - 화면구성
	// 2. 컴포넌트 종류,특성
	// 3. 이벤트 처리
	
	public Ex02() {
//		java.awt.FlowLayout layout=new FlowLayout();
		// FlowLayout
		// - 가로로 중앙배치
		// - 세로로 위로배치
		// - 옆으로 정렬, 만일 불가시 다음줄로
		java.awt.GridLayout layout=new GridLayout(4,2);
		// 자리 확보 1arg>2arg
		// 자리 배치 1arg<2arg
		// 1 arg - 세로열
		// 2 arg - 가로행
		this.setLayout(layout);
		
		java.awt.Button btn1=new Button("Button01");
		java.awt.Button btn2=new Button("Button02");
		java.awt.Button btn3=new Button("Button03");
		java.awt.Button btn4=new Button("Button04");
		java.awt.Button btn5=new Button("Button05");
//		java.awt.Button btn6=new Button("Button06");
//		java.awt.Button btn7=new Button("Button07");
		
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		this.add(btn4);
		this.add(btn5);
//		this.add(btn6);
//		this.add(btn7);
		
		this.setLocation(500, 300);
		this.setSize(400, 300);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Ex02();
	}

}
