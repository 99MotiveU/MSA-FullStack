package com.pm;

interface Pen {
	void work();
}

class Ballpen implements Pen {

	public void work() {
		System.out.println("글을 작성합니다");
	}
}

class Pencil implements Pen {
	public void work() {
		System.out.println("그림도 그립니다");
	}
}

class Signpen implements Pen {
	public void work() {
		System.out.println("싸인합니다");
	}
}

class Box<T> {
	private T pen;

	public void setPen(T pen) {
		this.pen = pen;
	}

	public T getPen() {
		return this.pen;
	}

}

public class Ex01 {

	public static void main(String[] args) {

		Box<Pen> box = new Box<Pen>();

		box.setPen(new Signpen());

		Pen my = box.getPen();

		my.work();
	}

}
