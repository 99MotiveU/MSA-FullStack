package com.pm;

import java.util.Scanner;

class Machine{
	public void on() {
		System.out.println("켜다");
	}
	public void off() {
		System.out.println("끄다");
	}
	public void work() {
		System.out.println("전기를 가지고 무슨일이든 합니다");
	}
}
class Tv extends Machine{
	public void work() {
		System.out.println("주파수를 잡아 화면을 보여준다");
	}
}
class Audio extends Machine{
	public void work() {
		System.out.println("음악을 들려준다");
	}
}

class Radio extends Machine{
	@Override
	public void work() {
		System.out.println("주파수 잡아 소리를 들려준다");
	}
}

public class Ex04 {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		Scanner sc = new Scanner(System.in);
		
		//다형성
		Machine remote=null;
		
		System.out.print("클래스정보>");
		String input=sc.nextLine();
		remote=(Machine)(Class.forName(input).newInstance());
		
		remote.on();
		remote.work();
		remote.off();
		
		sc.close();
	}

}
