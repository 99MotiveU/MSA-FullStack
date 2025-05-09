package com.pm;

import java.awt.*;

public class Ex08_2m extends Frame {
	
	public Ex08_2m() {
		Font f = new Font("", 0 ,50);
		Panel p = new Panel();
		p.setLayout(new BorderLayout());
		
		Panel top = new Panel();
		Panel cen = new Panel();
		top.setLayout(new GridLayout());
		cen.setLayout(new GridLayout(4,3));
		
	}

	public static void main(String[] args) {
		
	}
}