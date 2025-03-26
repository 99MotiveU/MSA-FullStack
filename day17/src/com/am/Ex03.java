package com.am;

import java.io.File;
import java.io.IOException;

public class Ex03 {

	public static void main(String[] args) {
		String name="target2.txt";
		File file=new File(name);
//		if(file.exists()) {
//			System.out.println("존재함");
//		}else {
			try {
				boolean result = file.createNewFile();
				System.out.println("생성됨 "+result);
			} catch (IOException e) {
				e.printStackTrace();
//			}
		}
	}

}
