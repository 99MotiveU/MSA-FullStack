package com.pm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

public class Ex08 {

	public static void main(String[] args) {
		// 이론상 - 순서가 없다
		// 사실상 - 순서가 있다
		// 중복불허
		List list = new ArrayList();
		list.add("첫번째");
		list.add("두번째");
		list.add("세번째");
		list.add("네번째");
		list.add("다섯번째");
		list.add("첫번째");
		System.out.println("list size : " + list.size());

		java.util.Set set1 = new LinkedHashSet();
		java.util.Set set2 = new HashSet(list);
//		set2.add("여섯번째");

		set1.addAll(list);
		System.out.println("set size : " + set1.size());
		System.out.println(set1.equals(set2));

		java.util.Iterator ite = set1.iterator();
		while (ite.hasNext()) {
			Object obj = ite.next();
			System.out.println(obj);
		}

	}

}
