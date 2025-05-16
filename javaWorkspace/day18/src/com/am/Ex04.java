package com.am;

public class Ex04 {

	public static void main(String[] args) {
		System.out.println("main thread start");
		Thread thr=new Thread() {
			@Override
			public void run() {
				System.out.println(this.getName()+" thread start");
				for(int i=0; i<100; i++) {
					System.out.println(this.getName()+" thread i="+i );
				}
				System.out.println(this.getName()+" thread end");
			}
		};
		thr.start();
		for(int i=0; i<100; i++) {
			System.out.println("main thread i="+i );
		}
		System.out.println("main thread end");

	}

}
