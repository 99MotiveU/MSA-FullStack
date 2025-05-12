package com.am;

class Lec04 extends Thread{
	@Override
	public void run() {
		System.out.println("thread start...");
		int sum=0;
		for(int i=0; i<1000000000; i++) {
			sum+=i;
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for(int i=0; i<1000000000; i++) {
			sum+=i;
		}
		System.out.println("thread end...");
	}
}

public class Ex04 {

	public static void main(String[] args) {
		
		Lec04 target=new Lec04();
		
		while(true) {
			java.lang.Thread.State state = target.getState();
			if(state==Thread.State.NEW) {
				target.start();
			}
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(state.toString());
			
			if(state==Thread.State.TERMINATED) {
				break;
			}
		}
	}

}



