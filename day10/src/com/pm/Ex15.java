package com.pm;

public class Ex15 {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<71; i++) {
			sb.append("a");
			System.out.println(sb+"\t");
			System.out.println(sb.capacity());
		}
		sb.trimToSize(); // 버퍼 용량 정리
		
		System.out.println(sb.capacity());

	}

}
