package com.pm;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

class WindowClose implements WindowListener{

	@Override
	public void windowOpened(WindowEvent e) {
	}

	@Override
	public void windowClosing(WindowEvent e) {
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}
	
}

public class tmemobeta extends Frame implements ActionListener{
	TextArea ta;
	String title="       ";
	String dir="";
	
	public tmemobeta() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		setTitle(title);
		MenuBar bar=new MenuBar();
		
		Menu mn1=new Menu("File");
		Menu mn2=new Menu("Help");
		MenuItem mn1_1=new MenuItem("New");
		MenuItem mn1_2=new MenuItem("Open");
		MenuItem mn1_3=new MenuItem("Save");
		MenuItem mn1_4=new MenuItem("Save as");
		MenuItem mn1_5=new MenuItem("Exit");
		MenuItem mn2_1=new MenuItem("about");
		
		mn1.add(mn1_1);
		mn1.addSeparator();
		mn1.add(mn1_2);
		mn1.addSeparator();
		mn1.add(mn1_3);
		mn1.add(mn1_4);
		mn1.addSeparator();;
		mn1.add(mn1_5);
		mn2.add(mn2_1);
		bar.add(mn1);
		bar.add(mn2);
		
		mn1_1.addActionListener(this);
		mn1_2.addActionListener(this);
		mn1_3.addActionListener(this);
		mn1_4.addActionListener(this);
		mn1_5.addActionListener(this);
		mn2_1.addActionListener(this);
		
		this.setMenuBar(bar);
		setLayout(new BorderLayout());
		ta=new TextArea();
		add(ta,BorderLayout.CENTER);
		setBounds(100,100,500,300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new tmemobeta();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		System.out.println(e.getActionCommand());
		
		if(e.getActionCommand().equals("Exit")) {
			dispose();
		}else if(e.getActionCommand().equals("Open")) {
			FileDialog dia=new FileDialog(this);
			dia.setVisible(true);
			dir=dia.getDirectory();
			title=dia.getFile();
			//
			File file=new File(dir+title);
			InputStream is=null;
			if(file.exists()) {
				setTitle(title);
				byte[] buf=new byte[(int) file.length()];
				try {
					is=new FileInputStream(file);
					for(long i=0; i<file.length(); i++) {
						is.read(buf);
					}
					ta.setText(new String(buf));
					ta.revalidate();
					is.close();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}else if(e.getActionCommand().equals("Save")) {
			if(title.equals("       ")) {
				FileDialog dia=new FileDialog(this,"    ",FileDialog.SAVE);
				dia.setVisible(true);
				if(dia.getDirectory()!=null) {
					dir=dia.getDirectory();
					title=dia.getFile();
				}
			}
			File file=new File(dir+title);
			try {
				file.createNewFile();
				setTitle(title);
				OutputStream os=null;
				try {
					os=new FileOutputStream(file);
					String msg=ta.getText();
					os.write(msg.getBytes());
					os.close();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} catch (IOException e1) {
				System.out.println("        ");
			}
		}else if(e.getActionCommand().equals("Save as")) {
			FileDialog dia=new FileDialog(this,"   ̸         ",FileDialog.SAVE);
			dia.setVisible(true);
			dir=dia.getDirectory();
			title=dia.getFile();				
			File file=new File(dir+title);
			try {
				if(file.createNewFile()) {
					OutputStream os=null;
					try {
						os=new FileOutputStream(file);
						String msg=ta.getText();
						os.write(msg.getBytes());
						os.close();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
				}
			} catch (IOException e1) {
				System.out.println("        ");
			}
		}else if(e.getActionCommand().equals("New")) {
			ta.setText("");
			ta.setText("");
			title="       ";
			dir="";
			setTitle(title);
		}
		
	}

}
