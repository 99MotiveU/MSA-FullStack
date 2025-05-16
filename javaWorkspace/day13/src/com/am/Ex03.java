package com.am;

import java.text.CollationKey;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Ex03 {
	
	static class SortingObj implements Comparator{

		@Override
		public int compare(Object after, Object before) {
			return (Integer)after-(Integer)before;
		}

	}

	public static void main(String[] args) {
		List list1=new ArrayList();
		
		list1.add(1111);
		list1.add(3333);
		list1.add(2222);
		list1.add(5555);
		list1.add(4444);
		
		
//		list1.sort(new Comparator(){
//
//			@Override
//			public int compare(Object after, Object before) {
//				return (Integer)after-(Integer)before;
//			}
//
//		});
		list1.sort((Object a, Object b) ->(Integer)a-(Integer)b); //¶÷´Ù½Ä
		
		
		Iterator ite = list1.iterator();
		while(ite.hasNext()) {
			System.out.println(ite.next());
		}

	}

}








