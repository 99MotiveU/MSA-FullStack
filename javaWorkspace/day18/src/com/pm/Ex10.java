package com.pm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ex10 {

	public static void main(String[] args) {
		File file=new File("data09.txt");

		InputStream is=null;
		java.io.InputStreamReader isr=null;
		BufferedReader br=null;
		try {
			is=new FileInputStream(file);
			isr=new InputStreamReader(is);
			br=new BufferedReader(isr);
			
//			System.out.println(isr.read());
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
