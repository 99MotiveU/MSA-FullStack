package com.am;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Frame;

public class Ex02 {

	public static void main(String[] args) {
		Frame f=new Frame();
		
		f.setLocation(1920+100, 100);
		Dimension dim=new Dimension(400,300);
		f.setSize(dim);
		f.setVisible(true);
		
		Dialog dia1=new Dialog(f);
		dia1.setLocation(1920+500, 100);
		dia1.setSize(dim);
		dia1.setVisible(true);
		
		FileDialog dia2=new FileDialog(f,"열기",0);
		dia2.setLocation(1920+100, 500);
		dia2.setSize(dim);
		dia2.setVisible(true);
		System.out.println(dia2.getDirectory());
		System.out.println(dia2.getFile());
		
		FileDialog dia3=new FileDialog(f,"저장",1);
		dia3.setLocation(1920+500, 500);
		dia3.setSize(dim);
		dia3.setVisible(true);
		System.out.println(dia3.getDirectory());
		System.out.println(dia3.getFile());
	}

}






