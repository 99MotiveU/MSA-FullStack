package com.pm;

public class Ex01 {

	public static void main(String[] args) {
//		java.util.ArrayList list=new java.util.ArrayList();	//걸린시간:16ms 걸린시간:308ms
		java.util.LinkedList list=new java.util.LinkedList();//걸린시간:16ms 걸린시간:424ms
		for(int i=0; i<100000; i++) {
			list.add("item"+i);
		}
		long before=System.currentTimeMillis();
		String msg="";
		for(int i=0; i<100000;i++) {
			msg+=list.get(i).toString();
		}
		long after=System.currentTimeMillis();
		System.out.println("걸린시간:"+(after-before)+"ms");
		System.out.println("걸린시간:"+(after-before)/1000.0+"s");
		//배열과 객체의 성능은 다르다.
		//자바의 배열과 String은 잘 만들어져있다.
	}

}















