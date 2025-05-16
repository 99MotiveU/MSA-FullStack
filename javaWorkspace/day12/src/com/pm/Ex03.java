package com.pm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Ex03 {

	public static void main(String[] args) {
		ArrayList list1=new ArrayList();
		list1.add(1111);
		list1.add(2222);
		list1.add(3333);
		list1.add(4444);
		list1.add(5555);
		Collection list2=new ArrayList(list1);
		List list3=new ArrayList(list1);
		ArrayList list4=(ArrayList) list1.clone();
		
		ArrayList list5=new ArrayList();
		list5.addAll(list1);
		
		List list6=list5.subList(0, list5.size());
		
		Object[] list7=list6.toArray();
		int[] list8=new int[list7.length];
		for(int i=0; i<list7.length; i++) {
			list8[i]=(Integer)list7[i];
		}
		
//		list1.set(2, 3000);
//		list5.removeAll(list1);
		
//		list5.remove(1);
		
		
		for(int i=0; i<list7.length; i++) {
			int obj=(Integer)list7[i];
			System.out.println(obj+1);
		}
	}

}















