package com.pm;

public class Ex01 {

	public static void main(String[] args) {
//		java.util.ArrayList list=new java.util.ArrayList();	//�ɸ��ð�:16ms �ɸ��ð�:308ms
		java.util.LinkedList list=new java.util.LinkedList();//�ɸ��ð�:16ms �ɸ��ð�:424ms
		for(int i=0; i<100000; i++) {
			list.add("item"+i);
		}
		long before=System.currentTimeMillis();
		String msg="";
		for(int i=0; i<100000;i++) {
			msg+=list.get(i).toString();
		}
		long after=System.currentTimeMillis();
		System.out.println("�ɸ��ð�:"+(after-before)+"ms");
		System.out.println("�ɸ��ð�:"+(after-before)/1000.0+"s");
		//�迭�� ��ü�� ������ �ٸ���.
		//�ڹ��� �迭�� String�� �� ��������ִ�.
	}

}















