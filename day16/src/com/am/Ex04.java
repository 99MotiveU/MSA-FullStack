package com.am;

import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;

public class Ex04 extends Frame{
	
	public Ex04() {
		
		MenuBar bar=new MenuBar();
		Menu mn1=new Menu("첫번째");
		MenuItem mi1=new MenuItem("1번째");
		MenuItem mi2=new MenuItem("2번째");
		
		Menu mi3=new Menu("3번째");

		MenuItem mi4=new MenuItem("1번째");
		MenuItem mi5=new MenuItem("2번째");
		mi3.add(mi4);
		mi3.add(mi5);
		
		mn1.add(mi1);
		mn1.add(mi2);
		mn1.addSeparator();
		mn1.add(mi3);
		bar.add(mn1);
		bar.add(new Menu("두번째"));
		bar.add(new Menu("세번째"));
		bar.add(new Menu("네번째"));
		
		this.setMenuBar(bar);
		setBounds(100,100,500,300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Ex04();
	}

}
