package com.pm;

import java.io.IOException;
import java.io.OutputStream;

public class Ex04 {
	public static void main(String[] args) {
		OutputStream os = System.out;
		try {
			os.write(65);
			
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
