package com.pm;

import java.io.IOException;
import java.io.InputStream;

public class Ex05 {
	public static void main(String[] args) {
//		InputStream is = System.in;
//		new Scanner(is);
		
		InputStream is = System.in;
		try {
			System.out.println(is.read());
			System.out.println(is.read()); // \r (window의 개행)
			System.out.println(is.read()); // \n
			System.out.println(is.read());
			//read는 다음 스트림이 들어올때까진 계속 한다
			is.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
