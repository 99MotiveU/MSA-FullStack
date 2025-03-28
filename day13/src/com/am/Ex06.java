package com.am;

import java.util.ArrayList;
import java.util.List;

public class Ex06 {

	public static void main(String[] args) {
		// 제네릭 - 제약
		// 1.5~
		// E,K,V,T,...
		// 참조변수타입
		
		List<Integer> list=new ArrayList<Integer>();
		list.add(1111);
		list.add(2222);
		list.add(3333);
		list.add(4444);
		list.add(5555);
//		list.add(3.14);
		
		for(int i=0; i<list.size(); i++) {
			int msg=list.get(i);
			System.out.println(msg);
		}
	}

}



















