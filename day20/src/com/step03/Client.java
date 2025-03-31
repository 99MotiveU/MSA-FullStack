package com.step03;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client extends Frame implements ActionListener {
	static TextArea ta;
	TextField tf;
	static Socket sock;
	static BufferedWriter bw;
	
	public Client() {
		setLayout(new BorderLayout());
		ta=new TextArea();
		ta.setEditable(false);
		tf=new TextField();
		add(ta,BorderLayout.CENTER);
		add(tf,BorderLayout.SOUTH);
		tf.addActionListener(this);
		setBounds(400,100,200,300);
		setVisible(true);
		ta.setFocusable(false);
	}

	public static void main(String[] args) {
		new Client();
		InputStream is=null;
		InputStreamReader isr=null;
		BufferedReader br=null;
		try {
			InetAddress addr=null;
			addr=InetAddress.getByAddress(
						new byte[] {(byte)172,30,1,71}
//						new byte[] {127,0,0,1}
				);
			sock=new Socket(addr,3000);
			
			OutputStream os =null;
			OutputStreamWriter osw=null;
			try {
				os = sock.getOutputStream();
				osw=new OutputStreamWriter(os);
				bw=new BufferedWriter(osw);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			is=sock.getInputStream();
			isr=new InputStreamReader(is);
			br=new BufferedReader(isr);
			while(true) {
				String msg=br.readLine();
				ta.setText(ta.getText()+msg+"\n");
				ta.revalidate();
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		String before=ta.getText();
//		System.out.println(">>>"+before+"<<<<");
		String msg=e.getActionCommand();
		try {
			bw.write(msg);
			bw.newLine();
			bw.flush();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		tf.setText(" ");
		tf.setText("");
		tf.revalidate();
		
	}

}






