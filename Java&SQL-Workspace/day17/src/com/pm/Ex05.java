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
			System.out.println(is.read()); // \r (window�� ����)
			System.out.println(is.read()); // \n
			System.out.println(is.read());
			//read�� ���� ��Ʈ���� ���ö����� ��� �Ѵ�
			is.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
