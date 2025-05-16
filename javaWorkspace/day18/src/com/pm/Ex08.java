package com.pm;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class Ex08 {

	public static void main(String[] args) {
		File file=new File("data08.txt");
		
		Writer fw=null;
		PrintWriter pw=null;
		try {
			file.createNewFile();
			
			fw=new FileWriter(file);
			pw=new PrintWriter(fw);
			
			pw.print("옆으로");
			pw.print("옆으로");
			pw.print("옆으로");
			pw.println();
			pw.println("다음줄1");
			pw.println("다음줄2");
			pw.println("다음줄3");
			
			pw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}




