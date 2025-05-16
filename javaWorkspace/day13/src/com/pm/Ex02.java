package com.pm;

class Lec01 {
	public void func1() {
		System.out.println("f1실행");
	}
}

class Lec02 {
	public void func2() {
		System.out.println("f2실행");
	}
}

class Box2<T, t> {
	T obj1;
	t obj2;

	void setObj1(T obj1) {
		this.obj1 = obj1;
	}

	void setObj2(t obj2) {
		this.obj2 = obj2;
	}

	T getObj1() {
		return obj1;
	}

	t getObj2() {
		return obj2;
	}
}

public class Ex02 {

	public static void main(String[] args) {
		Box2<Lec01, Lec02> box = new Box2<Lec01, Lec02>();

		box.setObj1(new Lec01());
		box.setObj2(new Lec02());

		Lec01 a1 = box.getObj1();
		Lec02 a2 = box.getObj2();

		a1.func1();
		a2.func2();

	}

}
