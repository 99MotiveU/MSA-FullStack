package com.am;

import java.io.File;

public class Ex05 {

	public static void main(String[] args) {
		File file=new File(".\\dir01\\dir02");
		boolean result=file.mkdir();
		System.out.println(result);

	}

}
