package com.pm;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Ex07 extends Frame implements ComponentListener,FocusListener,ContainerListener{
	static Ex07 me;
	public Ex07() {
		setLayout(new FlowLayout());
		Label la=new Label("test");
		Button btn=new Button("add");
//		la.addComponentListener(this);
//		this.addFocusListener(this);
		this.addContainerListener(this);
		btn.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				me.add(new Button("Ãß°¡"));
				me.revalidate();
//				me.repaint();
			}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {}
		});
		add(la);
		add(btn);
		setBounds(100,100,500,300);
		setVisible(true);
	}

	public static void main(String[] args) {
		me=new Ex07();

	}

	@Override
	public void componentResized(ComponentEvent e) {
		System.out.println("Resize");
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		System.out.println("Move");
		}

	@Override
	public void componentShown(ComponentEvent e) {
		System.out.println("Show");
		}

	@Override
	public void componentHidden(ComponentEvent e) {
		System.out.println("Hidden");
		}

	@Override
	public void focusGained(FocusEvent e) {
		System.out.println("focusIn");
	}

	@Override
	public void focusLost(FocusEvent e) {
		System.out.println("focusOut");
	}

	@Override
	public void componentAdded(ContainerEvent e) {
		System.out.println("add");
	}

	@Override
	public void componentRemoved(ContainerEvent e) {
		System.out.println("remove");
	}

}
