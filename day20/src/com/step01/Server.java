package com.step01;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

	public static void main(String[] args) {
		java.net.ServerSocket serv=null;
		Socket sock=null;
		InputStream is=null;
		OutputStream os=null;
		InputStreamReader isr=null;
		OutputStreamWriter osw=null;
		BufferedReader br=null;
		BufferedWriter bw=null;
		try {
			serv=new ServerSocket(3000);
			sock = serv.accept();
			is=sock.getInputStream();
			os=sock.getOutputStream();
			isr=new InputStreamReader(is);
			osw=new OutputStreamWriter(os);
			br=new BufferedReader(isr);
			bw=new BufferedWriter(osw);
			
			while(true) {
				String msg=br.readLine();
				if(msg.equals("exit"))break;
				msg="re:"+msg;
				bw.write(msg);
				bw.newLine();
				bw.flush();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//  ݵ            
			try {
				if(br!=null)br.close();
				if(bw!=null)bw.close();
				if(osw!=null)osw.close();
				if(isr!=null)isr.close();
				if(os!=null)os.close();
				if(is!=null)is.close();
				if(sock!=null)sock.close();
				if(serv!=null)serv.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
