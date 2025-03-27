package com.pm;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Ex01 {

	// Filter Stream
	// 
	
	public static void main(String[] args) {
		File file=new File("target.txt"); //복사끝:11082ms
		File copy=new File("copy.txt");//복사끝:54ms
		InputStream is=null;	
		OutputStream os=null;
		BufferedInputStream bis=null;
		BufferedOutputStream bos=null;
		byte[] buf=new byte[2];
		try {
			copy.createNewFile();
			is=new FileInputStream(file);
			os=new FileOutputStream(copy);
			bis=new BufferedInputStream(is);
			bos=new BufferedOutputStream(os);
			
			long before=System.currentTimeMillis();
			long cnt=0;
			while(true) {
				int su=bis.read(buf);
				if(su==-1)break;
				bos.write(buf,0,su);
				cnt++;
			}
			bos.flush();// 버퍼가 꽉차지 않아도 밀어냄
			long after=System.currentTimeMillis();
			System.out.println("복사끝:"+(after-before)+"ms");
			System.out.println("복사끝:"+cnt);
//			복사끝:2,107,842
//			복사완료:263,481
//			bis.close();
//			bos.close();
//			is.close();
//			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}











