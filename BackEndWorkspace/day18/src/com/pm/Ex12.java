package com.pm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.Arrays;

public class Ex12 {

	public static void main(String[] args) {
		File file=new File("data11.bin");
		
		InputStream is=null;
		ObjectInputStream ois=null;
		
		try {
			is=new FileInputStream(file);
			ois=new ObjectInputStream(is);
			
//			Object obj=ois.readObject();
			Ball obj=(Ball) ois.readObject();
			System.out.println(obj);
			obj.play();
			
//			System.out.println(ois.readObject());
//			System.out.println(Arrays.toString((int[])(ois.readObject())));
//			System.out.println(ois.readObject());
//			System.out.println(ois.readObject());
//			System.out.println(ois.readObject());
//			System.out.println(ois.readObject());
			
			ois.close();
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
