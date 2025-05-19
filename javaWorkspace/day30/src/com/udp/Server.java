package com.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {

	public static void main(String[] args) {
		DatagramSocket sock = null;
		DatagramPacket pack = null;
		byte[] buf = new byte[11];
		try {
			sock = new DatagramSocket();
			pack = new DatagramPacket(buf, buf.length);
			sock.receive(pack);
			System.out.println(new String(buf));
		} catch(SocketException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(sock!=null)sock.close();
		}
		
	}

}
