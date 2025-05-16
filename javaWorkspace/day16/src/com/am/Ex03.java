package com.am;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;

public class Ex03 {

	public static void main(String[] args) {
		Frame f=new Frame();
		
		Canvas can=new Canvas() {
			public void paint(Graphics g) {
//				g.drawChars(new char[] {'A','B','C'}, 0, 3, 100, 100);
//				g.drawLine(0, 0, 200, 200);
//				g.setColor(Color.RED);
//				g.drawRect(0, 0, 200, 200);
////				g.drawOval(0, 0, 200, 200);
//				g.setColor(Color.BLUE);
//				g.drawArc(0, 0, 200, 200,90,180);
				g.setColor(Color.RED);
				g.fillRect(0, 0, 200, 200);
//				g.drawOval(0, 0, 200, 200);
				g.setColor(Color.BLUE);
				g.fillArc(0, 0, 200, 200,90,180);
			}
		};
		
		f.add(can);
//		f.paint(); 그려라
//		f.repaint(); 다시 그려라
//		f.revalidate(); 바뀐게 있으면 반영하라
		f.setLocation(100, 100);
		Dimension dim=new Dimension(400,300);
		f.setSize(dim);
		f.setVisible(true);

	}

}
