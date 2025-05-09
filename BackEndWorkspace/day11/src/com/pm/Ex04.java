package com.pm;

public class Ex04 {
	
	public static void func01(){
		int a=0, b=0;
		if(a==0&&b==0) {
			throw new RuntimeException();
		}
		int su = a/b;
//		int su = 0/0;
//		Class.forName("com.pm.Ex041");
	}
	
	public static void main(String[] args) {
		try {
		func01();
		}catch(RuntimeException e){
			System.out.println(e.getMessage());
		}
	}//main end
}//end
