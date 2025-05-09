package com.am;

class Ball {
	final int num;
	static int cnt = 1;
	boolean boo;

	public Ball() {
		num = cnt++;
		boo = false;
	}

	public void check() {
		boo = true;
	}
}

public class Ex01 {

	public static void main(String[] args) {
		Ball[] box = new Ball[45];
		int[] note = new int[6];
		for (int i = 0; i < box.length; i++) {
			box[i] = new Ball();
//			System.out.println(box[i].num);
		}
		for (int i = 0; i < note.length; i++) {
			int ran = (int)( Math.random() * 45);
			Ball ball = box[ran];
			int num = ball.num;
//			System.out.println(num);
			if (ball.boo) {
				i--;
			}else {
				note[i] =num;
				ball.check();
				
				
			}
		}
		for(int i=0; i<note.length;i++) {
			System.out.print(note[i]+" ");
		}
	}

}
