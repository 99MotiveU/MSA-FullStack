package com.pm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Ex03 {

	public static void main(String[] args) {
		File target=new File("video01.mp4");
		File copy=new File("copy01.mp4");
		try {
			if(!copy.exists())copy.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		InputStream is=null;
		OutputStream os=null;
		byte[] buf=new byte[8];
//		1:15150ms
//		2:7629ms
//		4:3877ms
//		8:1962ms
		
		try {
			is=new FileInputStream(target);
			os=new FileOutputStream(copy);
			
//			for(long i=0; i<target.length(); i++) {
			long before=System.currentTimeMillis();
			while(true){
//				int su=is.read();
//				System.out.print(su+" ");
//				if(su==-1)break;
//				os.write(su);
				int su=is.read(buf);
				if(su==-1)break;
				os.write(buf,0,su);
			}
			long after=System.currentTimeMillis();
			System.out.println("    Ϸ :"+(after-before)+"ms");
			os.close();
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}











