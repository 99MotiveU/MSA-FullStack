package com.pm;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Ex03 {

	public static void main(String[] args) {
		File file=new File("data02.bin");
		
		InputStream is=null;
		DataInputStream dis=null;
		try {
			is=new FileInputStream(file);
			dis=new DataInputStream(is);
			
			//반드시 쓰기한 순서대로 읽기
			System.out.println(dis.read());
			System.out.println(dis.readInt());
			System.out.println(dis.readDouble());
			System.out.println(dis.readChar());
			System.out.println(dis.readBoolean());
			System.out.println(dis.readUTF());
			dis.close();
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
