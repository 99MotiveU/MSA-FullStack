package com.pm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

public class Ex06 {

	// 문자열스트림 2byte
	public static void main(String[] args) {
		File file=new File("data06.txt");
		
		java.io.Writer fw=null;
		java.io.BufferedWriter bw=null;
		try {
			file.createNewFile();
			fw=new FileWriter(file);
			bw=new BufferedWriter(fw);
//			bw.write('A');
//			bw.write('한');
			bw.write("hello world");
			bw.newLine();
			bw.write("hello world");
			bw.newLine();
			bw.write("hello world");
			
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}









