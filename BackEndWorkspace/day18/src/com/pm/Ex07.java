package com.pm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex07 {

	public static void main(String[] args) {
		File file=new File("data06.txt");

		java.io.Reader fr=null;
		java.io.BufferedReader br=null;
		try {
			fr=new FileReader(file);
			br=new BufferedReader(fr);
			while(true) {
//				int su=br.read();
//				if(su==-1)break;
//				System.out.print((char)su);
				String msg=br.readLine();
				if(msg==null)break;
				System.out.println(msg);
			}
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
