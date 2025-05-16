package com.am;

public class Ex03 implements Runnable{
	static Thread thr;

	public static void main(String[] args) {
		System.out.println("main thread start");
		Ex03 me=new Ex03();
		thr=new Thread(me);
		thr.start();
		for(int i=0; i<100; i++) {
			System.out.println("main thread i="+i );
		}
		System.out.println("main thread end");
	}

	@Override
	public void run() {
		System.out.println(thr.getName()+" thread start");
		for(int i=0; i<100; i++) {
			System.out.println(thr.getName()+" thread i="+i );
		}
		System.out.println(thr.getName()+" thread end");
	}

}
