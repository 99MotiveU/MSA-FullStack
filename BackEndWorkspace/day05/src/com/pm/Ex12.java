package com.pm;

class Car{
	public String company="����";
	public String model="�̸���";
	public String color="��";
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
		System.out.println(company +" "+color + "�� " + model + " ���� �ӵ��� " + speed+"km");
		//System.out.println(String.format("%s���� %s�� %s ���� �ӵ��� %dkm",company, color, model, speed));
	}
}

public class Ex12 {

	public static void main(String[] args) {
		// ��ü2
		Car myCar = new Car();
		myCar.model = "�ƹݶ�";
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
		//��ü1
		Car myCar2 = new Car();
		myCar2.model = "�ҳ�Ÿ";
		myCar2.max = 180;
		myCar2.color= "����";
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
