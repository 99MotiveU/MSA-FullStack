package com.am;

public class Ex02 {

	public static void main(String[] args) {
		//return (생성자 메서드) -메모리기준 호출한 쪽으로 돌아가는 것
		//break (반복문, switch문) -반복과 조건(switch에한)의 탈출
		//continue (반복문) - continue이하코드를 무시하고 처음으로 돌아감
		System.out.println("시작");
		func03();
		System.out.println("종료");
//		return;
	}
	public static void func01() {
		for(int i=0; i<10; i++) {
			if(i>5) {break;}
			System.out.println("i="+i);
		}
//		return;
	}
	public static void func02() {
		for(int i=0; i<10; i++) {
			if(i>5)return;// 
			System.out.println("i="+i);
		}
//		return;
	}
	public static void func03() {
		for(int i=0; i<10; i++) {
			if(i>5)continue;
			System.out.println("i="+i);
		}
//		return;
	}

}





