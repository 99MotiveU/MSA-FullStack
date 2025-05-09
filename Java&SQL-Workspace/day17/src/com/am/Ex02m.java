package com.am;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Ex02m {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("��� ��� : [ D:\\"+"\\"+"javaWorkspace\\"+"\\"+"day17 ]");
		System.out.print("��θ� �Է��ϼ��� > ");
		String path = sc.nextLine();
		File dir = new File(path);
		String format="yyyy-MM-dd a hh:mm";
		SimpleDateFormat sdf=new SimpleDateFormat(format);

		if (dir.exists() && dir.isDirectory()) {
			File[] files = dir.listFiles();

			if (files != null) {
				for (File file : files) {
					String type = file.isDirectory() ? "<DIR>" : "����";
					long before=file.lastModified();
					Date after = new Date(before);
					System.out.print(sdf.format(after) +"\t" );
					System.out.printf("%-10s %s\n", type, file.getName());
				}
			}
		} else {
			System.out.println("���͸��� ã�� �� �����ϴ�.");
		}
		sc.close();
	}
}
