package com.am;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex07 {

	public static void main(String[] args) {
		//StringTokenizer
		String msg = "java, db, web, framework";
		String[] arr1 =msg.split(" ");
		System.out.println(Arrays.toString(arr1));
		
		StringTokenizer stk = new StringTokenizer(msg);
		
		System.out.println("split length: "+arr1.length); //의미없는게 남음 (db와 web사이 띄어쓰기들이 보인다)
		System.out.println("token length: "+stk.countTokens()); // 의미없는 걸 없앰
		//문자열을 많이 다룬다면 StringTokenizer를 많이 쓰겠지만 우리는 split을 주로 사용할 것이다.
		while(stk.hasMoreTokens()) {
			String temp = stk.nextToken();
			System.out.println(temp);
		}
		

	}

}
