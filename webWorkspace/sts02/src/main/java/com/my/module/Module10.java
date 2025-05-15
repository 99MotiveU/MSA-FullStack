package com.my.module;

public class Module10 implements MyModule2{
	public int su=9999;

	public void func01() {
		System.out.println("run func01()...");
	}
	public void func02(int su) {
		System.out.println("run func02()..."+su);
		System.out.println("run func02()..."+this.su);
	}
	public String func03() {
		System.out.println("run func03()...");
		return "result";
	}
	public void func04() {
		System.out.println("run func04()...");
		int su=0/0;
		System.out.println("run func04()...");
		
	}

}
