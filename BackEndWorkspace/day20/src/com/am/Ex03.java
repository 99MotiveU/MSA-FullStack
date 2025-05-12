package com.am;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Ex03 {

	public static void main(String[] args) {
//		String spec="https://google.com";
		String spec="https://www.7-zip.org/a/7z2409-x64.exe";
		File file=new File("7zip.exe");
		URL url=null;
		URLConnection conn=null;
		try {
			file.createNewFile();
			url=new URL(spec);
			conn=url.openConnection();
			InputStream is = conn.getInputStream();
			OutputStream os=new FileOutputStream(file);
			while(true) {
				int su=is.read();
				if(su==-1)break;
				os.write(su);
			}
			System.out.println("다운로드완료");
			os.close();
			is.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}









