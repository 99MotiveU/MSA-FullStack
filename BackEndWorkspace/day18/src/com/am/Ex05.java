package com.am;

public class Ex05 {
	static Thread thr;

	public static void main(String[] args) {
		System.out.println("main thread start");
		thr=new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(thr.getName()+" thread start");
				for(int i=0; i<100; i++) {
					System.out.println(thr.getName()+" thread i="+i );
				}
				System.out.println(thr.getName()+" thread end");
			}
		});
		thr.start();
		for(int i=0; i<100; i++) {
			System.out.println("main thread i="+i );
		}
		System.out.println("main thread end");
	}

}
