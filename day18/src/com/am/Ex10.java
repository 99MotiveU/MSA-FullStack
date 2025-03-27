package com.am;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.TableColumn;

public class Ex10 extends Frame implements Runnable,ActionListener{
	static Label la;
	static Thread thr;
	
	public Ex10() {
		setLayout(new BorderLayout());
		la=new Label();
		la.setFont(new Font(Font.MONOSPACED,Font.BOLD,45));
		la.setAlignment(Label.CENTER);
		Panel p=new Panel();
		Button btn1=new Button("start");
		Button btn2=new Button("suspend");
		Button btn3=new Button("resume");
		Button btn4=new Button("stop");
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		
		p.add(btn1);
		p.add(btn2);
		p.add(btn3);
		p.add(btn4);
		add(p,BorderLayout.SOUTH);
		add(la,BorderLayout.CENTER);
		setBounds(100,100,300,200);
		setVisible(true);
		
	}
	
	public void loop() {
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss");
		String text=sdf.format(d);
		//la.setText(text);
	}

	public static void main(String[] args) {
		Ex10 me=new Ex10();
		thr=new Thread(me);
		while(true) {
			la.setText(thr.getState()+"");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void run() {
		while(true) {
			la.setText(thr.getState()+"");
			loop();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		Button btn1=new Button("start");
//		Button btn2=new Button("suspend");
//		Button btn3=new Button("resume");
//		Button btn4=new Button("stop");
		String msg=e.getActionCommand();
		if(msg.equals("start")) {
//			thr=new Thread(this);
			thr.start();
			((Button)e.getSource()).setEnabled(false);
		}
		if(msg.equals("suspend")) {
			thr.suspend();
		}
		if(msg.equals("resume")) {
			thr.resume();
		}
		if(msg.equals("stop")) {
			thr.stop();
		}
	}

}










