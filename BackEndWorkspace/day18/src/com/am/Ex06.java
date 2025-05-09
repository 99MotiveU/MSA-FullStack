package com.am;

public class Ex06 extends Thread {

	public static void main(String[] args) {
		Ex06 me1=new Ex06();
		Ex06 me2=new Ex06();

		me1.start();
		me2.start();
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
