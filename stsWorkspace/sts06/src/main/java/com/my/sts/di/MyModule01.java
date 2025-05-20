package com.my.sts.di;

import java.util.Date;

import org.springframework.stereotype.Repository;

@Repository
public class MyModule01 implements MyModule {
	int su1;
	double su2;
	char ch3;
	boolean boo;
	String msg;
	Date nalja;
	public int getSu1() {
		return su1;
	}
	public void setSu1(int su1) {
		this.su1 = su1;
	}
	public double getSu2() {
		return su2;
	}
	public void setSu2(double su2) {
		this.su2 = su2;
	}
	public char getCh3() {
		return ch3;
	}
	public void setCh3(char ch3) {
		this.ch3 = ch3;
	}
	public boolean isBoo() {
		return boo;
	}
	public void setBoo(boolean boo) {
		this.boo = boo;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Date getNalja() {
		return nalja;
	}
	public void setNalja(Date nalja) {
		this.nalja = nalja;
	}
	@Override
	public String toString() {
		return "Module01 [su1=" + su1 + ", su2=" + su2 + ", ch3=" + ch3 + ", boo=" + boo + ", msg=" + msg + ", nalja="
				+ nalja + "]";
	}

	@Override
	public void func01() {
		System.out.println(this.toString());
	}
	
}
