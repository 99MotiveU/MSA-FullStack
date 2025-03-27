package com.pm;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex02 {

	public static void main(String[] args) {
		File file=new File("data02.bin");
		OutputStream os=null;
		DataOutputStream dos=null;
		try {
			file.createNewFile();
			os=new FileOutputStream(file);
			dos=new  DataOutputStream(os);
			
			dos.write(0);
			int su1=1111;
			dos.writeInt(su1);
			double su2=3.14;
			dos.writeDouble(su2);
			char su3='A';
			dos.writeChar(su3);
			boolean boo=true;
			dos.writeBoolean(boo);
			String msg="hello world";
			dos.writeUTF(msg);
			
			dos.close();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
