package com.pm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex06 {

	public static void main(String[] args) {
		String msg="환영합니다 IO입니다";
		File f=new File("data01.bin");
		
		OutputStream os=null;
		
		try {
			os=new FileOutputStream(f);
			
			os.write(msg.getBytes());
//			os.write(new byte[] {97,98,99,100});
//			os.write(97);
//			os.write(98);
//			os.write(99);
//			os.write(100);
			
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}










