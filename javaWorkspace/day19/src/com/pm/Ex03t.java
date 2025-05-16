package com.pm;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.ImageCapabilities;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Ex03t extends Frame implements Runnable,ActionListener{
	int tot;
	Label la1,la2;
	JButton[] btns;
	Panel p1;
	static Thread thr;
	Button begin;
	int time=10;
	static Ex03t me;
	
	public Ex03t() {
		btns=new JButton[16];
		setLayout(new BorderLayout());
		p1=new Panel(new GridLayout(4,4));
		Panel p2=new Panel(new GridLayout(2,1));
		la1=new Label("시간:"+time+"초");
		la2=new Label("점수");
		la1.setAlignment(Label.RIGHT);
		la2.setAlignment(Label.CENTER);
		
		for(int i=0; i<btns.length; i++) {
			btns[i] = new JButton(i+"");
			if(i%2==0)btns[i].setIcon(new ImageIcon("imgs/ball01.jpg"));
			if(i%2==1)btns[i].setIcon(new ImageIcon("imgs/ball02.jpg"));
			btns[i].setBackground(Color.WHITE);
			btns[i].setForeground(Color.WHITE);
			p1.add(btns[i]);
			btns[i].addActionListener(this);
			btns[i].setEnabled(false);
		}
		begin = new Button("시작");
		begin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				thr=new Thread(me);
				thr.setDaemon(true);
				begin.setEnabled(false);
				for(int i=0; i<btns.length; i++)
					btns[i].setEnabled(true);
				thr.start();
			}
		});
		p2.add(begin);
		Button end=new Button("끝");
		end.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		p2.add(end);
		
		add(la1,BorderLayout.NORTH);
		add(la2,BorderLayout.SOUTH);
		add(p1,BorderLayout.CENTER);
		add(p2,BorderLayout.EAST);
		setBounds(100,100,550,550);
		setVisible(true);
	}

	public static void main(String[] args) {
		me=new Ex03t();
		
	}

	@Override
	public void run() {
		while(true) {
			
			mix();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			mix();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			time--;
			if(time<0) {
				for(int i=0; i<btns.length; i++)
					btns[i].setEnabled(false);
				begin.setEnabled(true);
				time=10;
				thr.stop();
				revalidate();
				break;
			}
			la1.setText("시간:"+time+"초");
			revalidate();
		}
		
	}
	
	public void mix() {
		Random ran=new Random();
		for(int i=0; i<100; i++) {
		int su1=ran.nextInt(16);
		int su2=ran.nextInt(16);
		
		JButton btn=btns[su1];
		btns[su1]=btns[su2];
		btns[su2]=btn;
		}
		for(int i=0; i<btns.length; i++) {
			p1.add(btns[i]);
		}
		revalidate();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(Integer.parseInt(e.getActionCommand())%2==0)
			tot++;
		else tot-=2;
		
		la2.setText("점수:"+tot);
		revalidate();
	}
}













