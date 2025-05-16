package com.am;

public class Ex02 implements Runnable{
	static int sum;

	public static void main(String[] args) {
		// 1~1000
		// 1~500
		// 501~1000
		Ex02 me=new Ex02();
		
		Thread me1=new Thread(me,"me1");
		Thread me2=new Thread(me,"me2");
		
		me1.start();
		me2.start();
		
		try {
			me1.join(); // me1이 끝나기전까지 lock
			me2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("sum="+sum);//sum=50005000
	}
	
	static Object key=new Object();
	
	public void hap(int a, int b) {
		
		for(int i=a; i<=b; i++) {
			synchronized(this) {
	//			int temp=sum+i;
	//			sum=temp;
				sum+=i;
			}
		}
	}
	public static synchronized void hap2(int a) {
			int temp=sum+a;
			sum=temp;
	}
	
	@Override
	public void run() {
		Thread thr=Thread.currentThread();
		if(thr.getName().equals("me1")) {
			hap(1,500);
		}else if(thr.getName().equals("me2")) {
			hap(501,1000);
		}
			
//			for(int i=begin; i<=end; i++) {
//				hap2(i);
//			}
	}

}
