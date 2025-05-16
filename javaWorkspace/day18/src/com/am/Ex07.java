package com.am;

public class Ex07 implements Runnable {

	public static void main(String[] args) {

		Ex07 me=new Ex07();
		
		Thread thr1=new Thread(me);
//		Thread thr2=new Thread(me);
		Thread thr2=new Thread(new Runnable() {
			
			@Override
			public void run() {
				Thread thr=Thread.currentThread();
				System.out.println(thr.getName()+" thread start");
				for(int i=1000; i<1100; i++) {
					System.out.println(thr.getName()+" thread i="+i );
				}
				System.out.println(thr.getName()+" thread end");
				
			}
		});

		thr1.start();
		thr2.start();
	}
	
	@Override
	public void run() {
		Thread thr=Thread.currentThread();
		System.out.println(thr.getName()+" thread start");
		for(int i=0; i<100; i++) {
			System.out.println(thr.getName()+" thread i="+i );
		}
		System.out.println(thr.getName()+" thread end");
	}

}
