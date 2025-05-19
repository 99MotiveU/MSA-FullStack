package com.pm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Ex01 implements Runnable{
	Socket sock;
	
	public Ex01(Socket sock) {
		this.sock=sock;
	}

	@Override
	public void run() {
//		System.out.println(sock.getRemoteSocketAddress());
		OutputStream os=null;
		InputStream is=null;
		InputStreamReader isr=null;
		BufferedReader br=null;
		try {
			is=sock.getInputStream();
			isr=new InputStreamReader(is);
			br=new BufferedReader(isr);
			String msg=br.readLine();
			msg=msg.split(" ")[1];
			os=sock.getOutputStream();			
			// http/ver HTTP 상태 코드
			os.write("HTTP/1.1 200 ok\n".getBytes());
			os.write("Content-Type: text/html;Charset=MS949\n".getBytes());
			os.write("\n".getBytes());
//			os.write(("<h1>"+msg+"요청</h1>").getBytes());
			File f=new File(msg.substring(1));
			is=new FileInputStream(f);
			while(true) {
				int su=is.read();
				if(su==-1)break;
				os.write(su);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(is!=null)is.close();
				if(os!=null)os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		ServerSocket serv=null;
		try {
			serv=new ServerSocket(80);
			System.out.println("before");
			while(true) {
				Socket sock = serv.accept();
				Ex01 me=new Ex01(sock);
				Thread thr=new Thread(me);
				thr.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(serv!=null)serv.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
