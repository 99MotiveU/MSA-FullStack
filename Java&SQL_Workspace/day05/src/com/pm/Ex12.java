package com.pm;

class Car{
	public String company="현대";
	public String model="이름모름";
	public String color="흰";
	public int speed;
	public int max=100;
	
	public void speedUp() {
		if(speed+18>max) {
			speed=max;
		}else {
			speed+=18;
		}
	}
	
	public void speedDown() {
		if(speed-22<0) {
			speed=0;
		}else {
			speed-=22;
		}
	}
	
	public void show() {
		System.out.println(company +" "+color + "색 " + model + " 차의 속도는 " + speed+"km");
		//System.out.println(String.format("%s사의 %s색 %s 차의 속도는 %dkm",company, color, model, speed));
	}
}

public class Ex12 {

	public static void main(String[] args) {
		// 객체2
		Car myCar = new Car();
		myCar.model = "아반떼";
		myCar.max = 150;
		myCar.show();
		for(int i = 0; i<30; i++) {
			myCar.speedUp();
			myCar.show();
		}
		
		for(int i = 0; i<30; i++) {
			myCar.speedDown();
			myCar.show();
		}
		//객체1
		Car myCar2 = new Car();
		myCar2.model = "소나타";
		myCar2.max = 180;
		myCar2.color= "검정";
		myCar2.show();
		for(int i = 0; i<30; i++) {
			myCar2.speedUp();
			myCar2.show();
		}
		
		for(int i = 0; i<30; i++) {
			myCar2.speedDown();
			myCar2.show();
		}

	}

}
