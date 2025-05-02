package com.pm;

interface Pen {
	void work();
}

class Ballpen implements Pen {

	public void work() {
		System.out.println("���� �ۼ��մϴ�");
	}
}

class Pencil implements Pen {
	public void work() {
		System.out.println("�׸��� �׸��ϴ�");
	}
}

class Signpen implements Pen {
	public void work() {
		System.out.println("�����մϴ�");
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
