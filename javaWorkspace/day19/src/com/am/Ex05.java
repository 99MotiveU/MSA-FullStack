package com.am;

public class Ex05 extends Thread{

	public static void main(String[] args) {
		Ex05 me=new Ex05();
		me.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		me.interrupt();
	}

	@Override
	public void run() {
		System.out.println(getName()+"start");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(getName()+"end");
	}
}
