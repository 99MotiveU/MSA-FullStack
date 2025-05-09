package com.pm;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Vector;

class Ball implements Serializable{
	private static final long serialVersionUID = 1L;
	
	int num;
	transient String color; // 직렬화 대상에서 제외
	
	public Ball(int num) {
		this.num=num;
		if(num>25)color="빨강";
		else color="파랑";
	}
	
	public void play() {
//		System.out.println(num+"번 굴러감");
		System.out.println(color+"색 공"+num+"번 던짐");
	}
	
	@Override
	public String toString() {
		return num+"번 공";
	}
}

public class Ex11 {

	public static void main(String[] args) {
		File file=new File("data11.bin");
		
		OutputStream os=null;
		java.io.ObjectOutputStream oos=null;
		try {
			file.createNewFile();
			os=new FileOutputStream(file);
			oos=new ObjectOutputStream(os);
			
			Ball ball=new Ball(45);
			oos.writeObject(ball);
			
//			oos.writeObject("문자열");
//			int[] arr1= {1,3,5,7};
//			oos.writeObject(arr1);
//			Vector vec=new Vector();
//			vec.add("vec1");
//			vec.add("vec2");
//			vec.add("vec3");
//			oos.writeObject(vec);
//			ArrayList list=new ArrayList();
//			list.add(1111);
//			list.add(2222);
//			list.add(3333);
//			list.add(4444);
//			oos.writeObject(list);
//			HashSet set=new HashSet();
//			set.add(11111);
//			set.add(22222);
//			set.add(33333);
//			set.add(44444);
//			oos.writeObject(set);
//			HashMap map=new HashMap();
//			map.put("key1", "val1");
//			map.put("key2", "val2");
//			map.put("key3", "val3");
//			map.put("key4", "val4");
//			oos.writeObject(map);
			
			oos.close();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}









