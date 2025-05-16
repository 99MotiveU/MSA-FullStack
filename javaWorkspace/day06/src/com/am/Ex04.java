package com.am;

class Car{
	public String company="국산";
	public String color="흰";
	public final String model;
	public int speed;
	public final int max;
	
	public Car(String msg,int a) {
		color=msg;
		max=a;
		if(a>180) {model="그랜져";}
		else if(a>150) {model="소나타";}
		else if(a>120) {model="아반떼";}
		else {model="모닝";}
	}
	public Car(String msg,String msg2,int a) {
		color=msg;
		model=msg2;
		max=a;
	}
	
	public void speedUp(int a) {
		if(speed+a*10>max) {
			speed=max;
		}else {
			speed+=a*10;
		}
	}
	public void speedDown() {
		if(speed-15<0) {
			speed=0;
		}else {
			speed-=15;
		}
	}
	public void show() {
		System.out.println(color+"색 내 차 "+model+"의 속도는 "+speed+"km");
	}
}

public class Ex04 {

	public static void main(String[] args) {
		Car myCar=new Car("빨강",120);
		for(int i=0; i<10; i++) {
			myCar.speedUp(i);
			myCar.show();
		}

		for(int i=0; i<20; i++) {
			myCar.speedDown();
			myCar.show();
		}
		
		myCar=new Car("검정","그랜져",120);
		for(int i=0; i<10; i++) {
			myCar.speedUp(i);
			if(i==3) {myCar.color="진흙뭍은 검정";}
			myCar.show();
		}

		for(int i=0; i<20; i++) {
			myCar.speedDown();
			myCar.show();
		}
	}

}










