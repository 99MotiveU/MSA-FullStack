package com.pm;

public class Ex11 {
//�ӵ��� 150������ �ö󰡵���, �극��ũ�� ������� �ӵ��� 0���Ϸ� �������� �ʵ���
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
		System.out.println("���� �ӵ��� "+ speed + "km �Դϴ�.");
	}
	
	public static void main(String[] args) {
		System.out.println("�ƹݶ� Ÿ��");
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
		
		System.out.println("�ҳ�Ÿ Ÿ��");
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
