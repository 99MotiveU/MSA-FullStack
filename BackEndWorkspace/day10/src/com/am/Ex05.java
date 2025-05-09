package com.am;

public class Ex05 {

	public static void main(String[] args) {
		byte su1 = 127;
		Byte su2 = 127;
		Byte su3 = new Byte(su1); // int 타입 불가
		Byte su4 = new Byte("127");
		byte su5 = Byte.parseByte("127");
		
		short su6 = 1;
		Short su7 = 1;
		Short su8 = new Short(su6);
		Short su9 = new Short("1");
	}

}
