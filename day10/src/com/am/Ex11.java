package com.am;

public class Ex11 {

	public static void main(String[] args) {
		char target='A';
		//문자냐
		//1.0.2 사용가능하냐 - 코드 작성시에는 모두 사용 가능
		System.out.println(Character.isDefined(target));
		//1.5 문자냐
		System.out.println(Character.isLetter(target));
		//1.7 문자냐
		System.out.println(Character.isAlphabetic(target));
		//숫자냐
		System.out.println(Character.isDigit(target));
		//영문 대문자
		System.out.println(Character.isUpperCase(target));
		//영문 소문자
		System.out.println(Character.isLowerCase(target));
		//띄어쓰기
		System.out.println(Character.isSpace(target));
		System.out.println(Character.isWhitespace(target));
	}

}
