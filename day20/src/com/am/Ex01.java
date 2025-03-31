package com.am;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ex01 {

	public static void main(String[] args) {
		/* google
		 * kix07s06-in-f14.1e100.net
		 * 142.250.76.142
		 * 
		 * www.google.com
		 * 142.250.207.100
		 * 
		 * */
		
		java.net.InetAddress[] addrs;
//		byte[] arr1= {(byte)172,30,1,71};
		byte[] arr1= {127,0,0,1};
		try {
//			addr=InetAddress.getByName("google.com");
//			addr=InetAddress.getByName("localhost");
//			addr=InetAddress.getByAddress(arr1);
			
//			System.out.println(addr.getHostName());
//			System.out.println(addr.getHostAddress());
			
			addrs=InetAddress.getAllByName("www.google.com");
			
			for(int i=0; i<addrs.length; i++) {
				InetAddress addr=addrs[i];
				System.out.println(addr.getHostName());
				System.out.println(addr.getHostAddress());
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}




