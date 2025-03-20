package com.pm;

public class Ex07 {

	public static Number div(int a, int b) {
		if (a % b == 0)
			return a / b;
		return 1.0 * a / b;
	}

	public static Box<? super Pen> func1(boolean boo) {
		if (boo) {
			return new Box<Object>();
		}
		return new Box<Pen>();
	}

	public static Box<? extends Pen> func2(boolean boo) {
		if (boo) {
			return new Box<Ballpen>();
		}
		return new Box<Pencil>();
	}

	public static Box<?> func3(int boo) {
		if (boo == 1) {
			return new Box<Ballpen>();
		}
		if (boo == 0) {
			return new Box<Pen>();
		}
		else {
			return new Box<Pen>();
		}
	}

	public static void main(String[] args) {
		Number result = div(5, 2);
		System.out.println(result);
	//	Box<Ballpen> box1 = func1(new Box<Ballpen>());
	}

}
