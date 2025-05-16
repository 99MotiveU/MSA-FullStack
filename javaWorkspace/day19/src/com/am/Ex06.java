package com.am;

class Lec06 implements Runnable {
	Ex06 me;

	@Override
	public void run() {
		for(int i=0; i<10; i++)
			me.func();
	}
}
public class Ex06{

	public synchronized void func() {
		System.out.println(Thread.currentThread().getName()+" start");
		try {
			notify(); // blocking 중 하나를 runnble 바꿈
			wait();					
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" end");
	}
	public static void main(String[] args) {
		Lec06 me=new Lec06();
		Thread thr1=new Thread(me);
		Thread thr2=new Thread(me);
		me.me=new Ex06();
		thr1.start();
		thr2.start();
	}

}
