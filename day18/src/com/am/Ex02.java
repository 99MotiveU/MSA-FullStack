package com.am;

import java.util.LinkedList;

public class Ex02 extends Thread{

	public static void main(String[] args) {

		System.out.println("main thread start");
		Ex02 me=new Ex02();
//		me.run();
		me.start();// 새로운 스레드로 run을 실행
		for(int i=0; i<100; i++) {
			System.out.println("main thread i="+i );
		}
		System.out.println("main thread end");
	}
	
	@Override
	public void run() {
		System.out.println(getName()+" thread start");
		for(int i=0; i<100; i++) {
			System.out.println(getName()+" thread i="+i );
		}
		System.out.println(getName()+" thread end");
		
	}

}