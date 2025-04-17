package com.am;

class Carriage{
	int speed;
	int max;
	public Carriage() {
		max=20;
	}
	void speedUp() {}
	private void speedDown() {}
	public void show() {
		System.out.println("운반 속도를 출력");
	}
}

class Cycle extends Carriage{
	public Cycle() {
		max=40;
	}
//	@Override // 컴파일러가 체크
//	public void show() {
//		System.out.println("열심히 달려봤자 "+speed+"km");
//	}
}

class Car extends Carriage{
	int max = 100;
	String model;
	String color;
	public Car(String color,String model) {
		max=100;
		this.color=color;
		this.model=model;
	}
	// 메서드 오버라이드 - 부모의 기능을 재정의
	// private 오버라이드 못함
	// 접근제한자는 같거나 접근 open의 방향으로는 허용
	@Override // 컴파일러가 체크
	public void show() {
		System.out.println(model+" 속도는 "+speed+"km");
	}
	@Override
	public void speedUp() {}
//	@Override
//	private void speedDown() {}
	
	public void stop() {}
}
// 중복된 코드의 재사용
public class Ex08 {

	public static void main(String[] args) {
		Cycle myCar=new Cycle();
		myCar.speedUp();
//		myCar.speedDown();
	}

}
