package com.am;

import java.io.File;
import java.io.IOException;

public class Ex03 {

	public static void main(String[] args) {
		String name="target2.txt";
		File file=new File(name);
//		if(file.exists()) {
//			System.out.println("������");
//		}else {
			try {
				boolean result = file.createNewFile();
				System.out.println("������ "+result);
			} catch (IOException e) {
				e.printStackTrace();
//			}
		}
	}

}
