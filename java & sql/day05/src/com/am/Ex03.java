package com.am;

public class Ex03 {

	public static void main(String[] args) {
		// if문 - 만약 조건이 참이라면
		if (true) {
			System.out.println("참이라 실행");
		}
//		}if(true) {}
//		else if(true) {} 
//		else {}  //필요한 경우 else if와  else 사용
		//switch문 - 값과 같은 case는
		switch(2){
			case 3: System.out.println(3);break;
			case 2: System.out.println(2);break;
			case 1: System.out.println(1);break;
			default:System.out.println("몰라");break;
			//default는 선택
		}

	}

}
