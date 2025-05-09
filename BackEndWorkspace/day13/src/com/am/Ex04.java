package com.am;

import java.util.*;

public class Ex04 {

	public static void main(String[] args) {
		//(유저가 정의한)순서가 있고 중복허용
		// 						key, value
		// key -set- 단, 중복을 불허(수정), all type, null 허용
		// value -list- 중복허용, all type, 단 존재하지않는 키값 null
		
		// 추후에는 key 되도록 문자열 사용선호
		Map map1=new HashMap();
//		Map map1=new TreeMap();
		
		map1.put("키1",null);
		map1.put("키2",2);
		map1.put(true,"값3");
		map1.put("키4",null);
		map1.put(5,"값5");
		map1.put(null,"값6");
//		map1.put(null,"edit6");
		map1.replace(null,"edit6");
//		map1.remove(null);
		
		map1.clear();
		
		
		
		System.out.println(map1.containsKey("키2"));
		System.out.println(map1.containsKey("키3"));
// 		없어서 null인 것과 null을 넣어서 null인 경우는 다른 것이다.
		System.out.println(map1.containsKey(null));
		System.out.println(map1.containsKey("키2"));
		
//		System.out.println(map1.get("키1"));
//		System.out.println(map1.get("키2"));
//		System.out.println(map1.get(true));
//		System.out.println(map1.get("키4"));
//		System.out.println(map1.get(5));
//		System.out.println(map1.get(null));
		
	}

}


















