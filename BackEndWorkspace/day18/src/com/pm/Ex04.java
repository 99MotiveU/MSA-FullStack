package com.pm;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Ex04 {

	public static void main(String[] args) {
		//String msg="hello world";
		File file=new File("target.txt");
		InputStream is=null;
		ByteArrayInputStream bais=null;
		ByteArrayOutputStream baos=null;
		
		try {	
			is=new FileInputStream(file);
			baos=new ByteArrayOutputStream();
			while(true) {
				int su=is.read();
				if(su==-1)break;
				baos.write(su);
			}
			byte[] arr=baos.toByteArray();
			bais=new ByteArrayInputStream(arr);
			while(true) {
				int su=bais.read();
				if(su==-1)break;
				System.out.print((char)su);
			}
			baos.close();
			bais.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
