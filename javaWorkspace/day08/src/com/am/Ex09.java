package com.am;

public class Ex09 {
// 다형성
	public static void main(String[] args) {
		Carriage car1=new Carriage();
		Cycle car3=new Cycle();
//		car3.show();
		Car car2=new Car("흰색","모닝");
		car1.speedUp();
		car1.show();
//		car1.stop();
		car2.speedUp();
		car2.show();
		car2.stop();
		Object obj = new String();
		
		Carriage car4;
		car4=new Car("검정색","자식");
		
		car4.speedUp();
		car4.show();
//		car4.stop(); 불가? 객체는 stop이라는 메서드를 갖고 있지만 타입이 부모 타입이라 할수 가없다 하려면
		((Car)car4).stop(); // 이렇게 하면 가능
		System.out.println(car4.max); //100이 나올 것이라 생각했지만 부모에서 초기화한 값인 20으로 나옴
		//-> 오버라이드의 대상은 메서드만
	}

}










