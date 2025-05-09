package com.am;

import java.io.File;

public class Ex08 {

	public static void main(String[] args) {
		File file = new File("target2.txt");
		File result = new File("target3.txt");
		boolean boo = file.renameTo(result);
		System.out.println(boo);
	}

}
