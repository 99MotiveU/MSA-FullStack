package com.pm;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.management.Query;

public class Ex04 {

	public static void main(String[] args) {
		ArrayList list1=new ArrayList();
		list1.add(1111);
		list1.add(2222);
		list1.add(3333);
		list1.add(4444);
		LinkedList list2=new LinkedList(list1);
		Queue list3=new LinkedList();
		list3.offer(1111);
		list3.offer(2222);
		list3.offer(3333);
		list3.offer(4444);
		Deque list4=new LinkedList();
		list4.offerLast(1111);
		list4.offerLast(2222);
		list4.offerLast(3333);
		list4.offerLast(4444);
		List list5=new LinkedList();
		list5.add(1111);
		list5.add(2222);
		list5.add(3333);
		list5.add(4444);
		
		for(int i=0; i<list4.size(); i++) {
			System.out.println(list5.get(i));
		}
	}

}












