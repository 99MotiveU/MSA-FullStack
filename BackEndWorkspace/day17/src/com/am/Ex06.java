package com.am;

import java.io.File;

public class Ex06 {

	public static void main(String[] args) {
		File file=new File("dir01");
		boolean result=file.delete();
		System.out.println(result);

	}

}