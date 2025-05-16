package com.step01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		java.net.Socket sock;
		byte[] arr= {(byte)172,30,1,71};
		InetAddress addr;
		int port=3000;
		OutputStream os=null;
		InputStream is=null;
		InputStreamReader isr=null;
		OutputStreamWriter osw=null;
		BufferedReader br=null;
		BufferedWriter bw=null;
		try {
			addr=InetAddress.getByAddress(arr);
			sock=new Socket(addr,port);
			os=sock.getOutputStream();
			is=sock.getInputStream();
			isr=new InputStreamReader(is);
			osw=new OutputStreamWriter(os);
			br=new BufferedReader(isr);
			bw=new BufferedWriter(osw);
			
			while(true) {
				System.out.print("> ");
				String msg=sc.nextLine();
				bw.write(msg);
				bw.newLine();
				bw.flush();
				if(msg.equals("exit"))break;
				String result=br.readLine();
				System.out.println(result);
			}
			
			bw.close();
			br.close();
			osw.close();
			isr.close();
			is.close();
			os.close();
			sock.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}








