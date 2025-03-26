package com.pm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ex01 {

	public static void main(String[] args) {
		// ByteStream - 1πŸ¿Ã∆Æ(-128~127, 0~255)
		String msg="hello java";
		
		File file=new File("data01.bin");

		if(!file.canExecute())
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		java.io.OutputStream os=null;
		
		try {
			os=new java.io.FileOutputStream(file);
			for(int i=0; i<msg.length(); i++)
				os.write(msg.charAt(i));
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

