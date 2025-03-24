package com.am;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class Ex05 extends Frame {
	
	public Ex05() {
		
		GridBagLayout mgr=new GridBagLayout();
		setLayout(mgr);
		
		Button btn1=new Button("btn01");
		Button btn2=new Button("btn02");
		Button btn3=new Button("btn03");
		Button btn4=new Button("btn04");
		Button btn5=new Button("btn05");
		Button btn6=new Button("btn06");
		Button btn7=new Button("btn07");
		
		GridBagConstraints gbc=new GridBagConstraints();
		gbc.fill=GridBagConstraints.BOTH;	// 어느방향으로 채울지
		gbc.gridx=0;			// x,y 좌표
		gbc.gridy=0;
		gbc.gridwidth=1;		// cell 크기
		gbc.gridheight=1;
		gbc.weightx=1.0;		// 증감시 증감비율
		gbc.weighty=1.0;
		add(btn1,gbc);
		gbc.gridx=1;
		gbc.gridy=0;
		gbc.gridwidth=1;
		gbc.gridheight=1;
		gbc.weightx=1.0;
		gbc.weighty=1.0;
		add(btn2,gbc);
		gbc.gridx=2;
		gbc.gridy=0;
		gbc.gridwidth=1;
		gbc.gridheight=1;
		gbc.weightx=1.0;
		gbc.weighty=1.0;
		add(btn3,gbc);
		gbc.gridx=3;
		gbc.gridy=0;
		gbc.gridwidth=1;
		gbc.gridheight=1;
		gbc.weightx=1.0;
		gbc.weighty=1.0;
		add(btn4,gbc);
		gbc.gridx=0;
		gbc.gridy=1;
		gbc.gridwidth=4;
		gbc.gridheight=1;
		gbc.weightx=1.0;
		gbc.weighty=1.0;
		add(btn5,gbc);
		gbc.gridx=0;
		gbc.gridy=2;
		gbc.gridwidth=3;
		gbc.gridheight=1;
		gbc.weightx=0.75;
		gbc.weighty=1.0;
		add(btn6,gbc);
		gbc.gridx=3;
		gbc.gridy=2;
		gbc.gridwidth=1;
		gbc.gridheight=1;
		gbc.weightx=0.25;
		gbc.weighty=1.0;
		add(btn7,gbc);
		
		setLocation(100,100);
		setSize(400,300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Ex05();
	}

}
