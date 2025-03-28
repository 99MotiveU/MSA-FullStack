package com.am;
//메모장
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;

public class Ex05m extends Frame{

	public Ex05m(){
		MenuBar bar=new MenuBar();
		Menu mn1=new Menu("파일");
		MenuItem mi1=new MenuItem("새파일");
		MenuItem mi2=new MenuItem("열기");
		MenuItem mi3=new MenuItem("저장");
		MenuItem mi4=new MenuItem("다른 이름으로 저장");
		MenuItem mi5=new MenuItem("종료");
		MenuItem mi6=new MenuItem("");
		
		bar.add(mn1);
		mn1.add(mi1);
		mn1.add(mi2);
		mn1.addSeparator();
		mn1.add(mi3);
		mn1.add(mi4);
		mn1.addSeparator();
		mn1.add(mi5);
		mn1.add(mi6);
		bar.add(new Menu("보기"));


		this.setMenuBar(bar);
		setBounds(100,100,500,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex05m();

	}

}
