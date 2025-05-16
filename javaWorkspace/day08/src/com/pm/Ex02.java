package com.pm;

class Ex22{
	int su=111;
	public void func01() {
		System.out.println("기능 수행");
	}
}

public class Ex02 {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		//Ex22 you = new Ex22();
		Ex22 you;
		you=Ex22.class.newInstance();
		System.out.println(you.su);
		you.func01();

	}

}












