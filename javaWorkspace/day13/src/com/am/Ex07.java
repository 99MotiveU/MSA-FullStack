package com.am;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Ex07 {

	public static void main(String[] args) {
		Set<Integer> set=new HashSet<Integer>();	
		set.add(1111);
		set.add(2222);
		set.add(3333);
		set.add(4444);
//		set.add("");
		
		Iterator<Integer> ite = set.iterator();
		while(ite.hasNext()) {
			int val=ite.next();
			System.out.println(val);
		}
		
		Set set2=new TreeSet();
		set2.add(new Ball());
		set2.add(new Ball());
		set2.add(new Ball());

	}

	static class Ball implements Comparable<Ball>{

		@Override
		public int compareTo(Ball o) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
}









