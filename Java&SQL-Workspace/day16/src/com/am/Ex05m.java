package com.am;
//�޸���
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;

public class Ex05m extends Frame{

	public Ex05m(){
		MenuBar bar=new MenuBar();
		Menu mn1=new Menu("����");
		MenuItem mi1=new MenuItem("������");
		MenuItem mi2=new MenuItem("����");
		MenuItem mi3=new MenuItem("����");
		MenuItem mi4=new MenuItem("�ٸ� �̸����� ����");
		MenuItem mi5=new MenuItem("����");
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
		bar.add(new Menu("����"));


		this.setMenuBar(bar);
		setBounds(100,100,500,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex05m();

	}

}
