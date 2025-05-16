package com.am;

import java.util.*;

public class Ex01 {

	public static void main(String[] args) {
		//중복 허용
		List list = new ArrayList();
		list = new LinkedList();
		
		//
		Queue que = new LinkedList();
		Deque que2 = new LinkedList();
		Stack stack = new Stack();
		
		//
		Vector vec1 = new Vector();
		Vector vec2 = new Stack();
		
		//중복 불허
		Set set1 = new HashSet();
		set1.add("첫번째");
		set1.add("두번째");
		set1.add("세번째");
		set1.add("네번째");
		
		Iterator ite = set1.iterator();
		while(ite.hasNext()) {
			System.out.println(ite.next());
		}
	}

}
