package com.pm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ex02 {

	public static void main(String[] args) {
		File file=new File("data01.bin");

		java.io.InputStream is=null;
		if(file.exists()) {
			try {
				is=new java.io.FileInputStream(file);
				int su=-1;
				while((su=is.read())!=-1) {
					System.out.println((char)su);
				};
				is.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

}

