package com.pm;

public class Ex11 {
//속도를 150까지만 올라가도록, 브레이크를 밟았을때 속도가 0이하로 떨어지지 않도록
	public static int speed=0;
	public static int max=0;
	public static void speedup() {
		if(speed+10>max) {
			speed=max;
		}else {
			speed+=10;
		}
		
	}
	
	public static void speedDown() {
		if(speed-10<0) {
			speed=0;
		}else {
			speed-=10;
		}
	}
	
	public static void showSpeed() {
		System.out.println("현재 속도는 "+ speed + "km 입니다.");
	}
	
	public static void main(String[] args) {
		System.out.println("아반떼 타고");
		max=150;
		showSpeed();
		for(int i=0; i<30; i++) {
			speedup();
			showSpeed();
		}
		for(int i=0; i<30; i++) {
			speedDown();
			showSpeed();
		}
		
		System.out.println("소나타 타고");
		max=180;
		showSpeed();
		for(int i=0; i<30; i++) {
			speedup();
			showSpeed();
		}
		for(int i=0; i<30; i++) {
			speedDown();
			showSpeed();
		}


	}

}
