package com.am;

class Car {
	public String model, color;
	public int speed;
	public final int max;

	public Car(String color, int max) {
		this(color, null, max);
	}

	public Car(String color, String model) {
		this(color, model, 0);
	}

	public Car(String color, String model, int max) {
		this.color = color;
		if (model != null) {
			this.model = model;
		} else {
			if (max > 180) {
				this.model = "그랜져";
			} else if (max > 150) {
				this.model = "아반떼";
			} else if (max > 120) {
				this.model = "케스퍼";
			} else {
				this.model = "모닝";
			}
		}

		if (max != 0) {
			this.max = max;
		} else {
			if (model.equals("그랜져")) {
				this.max = 200;
			} else if (model.equals("아반떼")) {
				this.max = 180;
			} else if (model.equals("케스퍼")) {
				this.max = 150;
			} else {
				this.max = 150;
			}
		}
	}

	public void up() {
		if (speed + 10 > max) {
			speed = max;
		} else {
			speed += 10;
		}
	}

	public void down() {
		if (speed - 10 < 0) {
			speed = 0;
		} else {
			speed -= 10;
		}
	}

	public void show() {
		System.out.println(color + "색 " + model + "의 속도는 " + speed + "km");
	}
}

public class Ex02 {

	public static void main(String[] args) {
		Car myCar = new Car("흰", 200);
		myCar.show();

		for (int i = 0; i < 30; i++) {
			myCar.up();
			myCar.show();
		}
		for (int i = 0; i < 30; i++) {
			myCar.down();
			myCar.show();
		}

	}

}
