package com.am;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Ex02m {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("경로 양식 : [ D:\\"+"\\"+"javaWorkspace\\"+"\\"+"day17 ]");
		System.out.print("경로를 입력하세요 > ");
		String path = sc.nextLine();
		File dir = new File(path);
		String format="yyyy-MM-dd a hh:mm";
		SimpleDateFormat sdf=new SimpleDateFormat(format);

		if (dir.exists() && dir.isDirectory()) {
			File[] files = dir.listFiles();

			if (files != null) {
				for (File file : files) {
					String type = file.isDirectory() ? "<DIR>" : "파일";
					long before=file.lastModified();
					Date after = new Date(before);
					System.out.print(sdf.format(after) +"\t" );
					System.out.printf("%-10s %s\n", type, file.getName());
				}
			}
		} else {
			System.out.println("디렉터리를 찾을 수 없습니다.");
		}
		sc.close();
	}
}
