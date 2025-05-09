package com.pm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Ex07 {

	public static void main(String[] args) {
		File f=new File("data01.bin");

		byte[] buf=new byte[8];
		
		InputStream is=null;
		
		try {
			is=new FileInputStream(f);
//			int su=is.read(buf);
//			System.out.println("su="+su);
//			System.out.println("array="+java.util.Arrays.toString(buf));
//			System.out.println(new String(buf,0,su));
//			su=is.read(buf);
//			System.out.println("su="+su);
			int su=-1;
			ArrayList<Byte> list=new ArrayList<>();
			while((su=is.read(buf))!=-1) {
//				System.out.print(new String(buf,0,su));
				for(int i=0;i<su; i++) {
					list.add(buf[i]);
				}
			}
			Byte[] arr2=list.toArray(new Byte[] {});
			byte[] arr3=new byte[arr2.length];
			for(int i=0; i<arr2.length; i++) {
				arr3[i]=arr2[i];
			}
			System.out.println(new String(arr3));
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}








