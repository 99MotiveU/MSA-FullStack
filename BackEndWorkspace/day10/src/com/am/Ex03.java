package com.am;

public class Ex03 {

	public static void main(String[] args) {
		int a=1111;
		//auto boxing
		Integer b=2222;
		Integer c=new Integer(3333);
		//auto unboxing
		Integer d=new Integer("-4444"); //��ȣ�� ���������� �ٸ� ���ڰ� �� ��� ����
		int e = new Integer("-5555");
		System.out.println(c.intValue()+1);
		System.out.println(c+1);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.SIZE);
		System.out.println(Integer.BYTES);

	}

}
