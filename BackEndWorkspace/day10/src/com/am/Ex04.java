package com.am;
//java reference class
public class Ex04 {

	public static void main(String[] args) {
		Integer target = new Integer(128);
		Integer target2 = new Integer(128);
		System.out.println(target.byteValue()); 
		//1byte = 0~255 -> -128 ~ 127
		System.out.println(target.shortValue());
		System.out.println(target.intValue());
		System.out.println(target.longValue());
		System.out.println(target.floatValue());
		System.out.println(target.doubleValue());
		System.out.println(target==target2);
		System.out.println(target.intValue()==target2.intValue());
		System.out.println(target.equals(target2)); //value 값 비교를 위해선 이렇게
		System.out.println(target+1);
		System.out.println(target.toString()+1);
		System.out.println(Integer.valueOf(target)+1);
		System.out.println(Integer.valueOf(target.toString())+1); // return Integer
		System.out.println(Integer.parseInt(target.toString())+1); // return int
		int su = 10000;
		System.out.println("2진수 "+su+" = "+Integer.toBinaryString(su));
		System.out.println("8진수 "+su+"= 0"+Integer.toOctalString(su));
		System.out.println("16진수 "+su+"= 0x"+Integer.toHexString(su));
		
		System.out.println("min:"+Integer.min(3, 5));
		System.out.println("max:"+Integer.max(3, 5));
		System.out.println("sum:"+Integer.sum(3, 5));
		
		System.out.println(Integer.bitCount(8));
		System.out.println(Integer.bitCount(9));
		//비트 단위로 바꿔버림(보수는 아님: 보수는 비트 단위로 바꾸고 +1 해야함)
		System.out.println(Integer.reverse(Integer.MAX_VALUE)); 
		// a,b a==b:0  a>b:1  a<b:-1 -> 두가지 리턴
		System.out.println(Integer.compare(3, 3));
		System.out.println(Integer.compare(3, 33));
		System.out.println(Integer.compare(3, 333));
		System.out.println(Integer.compare(3, 5));
		System.out.println(Integer.compare(5, 3));
		System.out.println(target.compareTo(target2));
	}

}
