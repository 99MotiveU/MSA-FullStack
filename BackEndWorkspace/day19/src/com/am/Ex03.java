package com.am;

public class Ex03 extends Thread {

	public static void main(String[] args) {
		System.out.println("main start");
		Ex03 me=new Ex03();
		me.setDaemon(true);
		me.start();
		
		try {
			Thread.sleep(1000);
//			me.join(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		System.out.println("main end");
	}

	@Override
	public void run() {
		System.out.println(getName()+" start");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(getName()+" end");
	}
}
