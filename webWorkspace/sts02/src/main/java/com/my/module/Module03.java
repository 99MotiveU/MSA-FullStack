package com.my.module;

import java.util.Date;

public class Module03 implements MyModule {
	int su1;
	double su2;
	char su3;
	boolean boo;
	String msg;
	Date nalja;

	public void setSu1(int su1) {
		this.su1 = su1;
	}
	public void setSu2(double su2) {
		this.su2 = su2;
	}
	public void setSu3(char su3) {
		this.su3 = su3;
	}
	public void setBoo(boolean boo) {
		this.boo = boo;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public void setNalja(Date nalja) {
		this.nalja = nalja;
	}
	
	@Override
	public String toString() {
		return "Module03 [su1=" + su1 + ", su2=" + su2 + ", su3=" + su3 + ", boo=" + boo + ", msg=" + msg + ", nalja="
				+ nalja + "]";
	}
	@Override
	public void func01() {
		System.out.println(this.toString());
	}

}
