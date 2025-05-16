package com.am;

public class Ex08 extends Thread{
	
	public Ex08() {
//		super("스레드1");
//		setName("이름1");
	}

	public static void main(String[] args) {
		Ex08 me=new Ex08();
		Ex08 me2=new Ex08();
		Ex08 me3=new Ex08();

		
//		숫자의 격차는 의미가 없음
		me.setPriority(Thread.NORM_PRIORITY);
		me2.setPriority(6); // me.setPriority(Thread.MIN_PRIORITY);
		me.setPriority(Thread.MAX_PRIORITY);
		
		me.start();
		me2.start();
		me3.start();
	}

	@Override
	public void run() {
		System.out.println(getName());
		Thread thr = Thread.currentThread();
		System.out.println(thr.getName());
		System.out.println(thr.getId());
		System.out.println(thr.getState());
		System.out.println(thr.getPriority()); //우선순위
		
		
	}
}
