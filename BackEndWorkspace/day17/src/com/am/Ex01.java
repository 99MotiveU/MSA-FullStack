package com.am;

import java.io.File;
import java.io.IOException;

public class Ex01 {

	public static void main(String[] args) throws IOException {
		// Input & Output
		java.io.File file;
		// 상대경로
//		file=new File("dir01");
//		file=new File("target.txt");
		file=new File("..\\day17");
		// 절대경로
//		file=new File("D:\\javaWorkspace\\day17\\target.txt");
		// 파일 - 디렉토리&파일
		System.out.println("존재하는가?"+file.exists());
		System.out.println("디렉토리인가?"+file.isDirectory());
		System.out.println("파일인가?"+file.isFile());
		System.out.println("경로?"+file.getParent());
		System.out.println("파일명?"+file.getName());
		System.out.println("path?"+file.getPath());
		System.out.println("절대경로1?"+file.getAbsolutePath());
		System.out.println("절대경로2?"+file.getCanonicalPath());
		System.out.println("r?"+file.canRead());
		System.out.println("w?"+file.canWrite());
		System.out.println("x?"+file.canExecute());
		long time1=file.lastModified();
		System.out.println(new java.util.Date(time1));
		
		String[] list=file.list();
		System.out.println(java.util.Arrays.toString(list));
		
		
	}

}












