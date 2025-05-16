package com.am;

public class Ex09 {

	public static void main(String[] args) {
		System.out.println("start");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("end");
	}

}
