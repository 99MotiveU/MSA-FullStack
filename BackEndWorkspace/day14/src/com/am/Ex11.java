package com.am;

import java.util.Optional;
import java.util.function.Consumer;

public class Ex11 {
	
	public static String func01() {
		return null;
	}
	
	public static Optional func02(int su) {
		if(su<0)
		return Optional.empty();
		return Optional.of("    ");
	}

	public static void main(String[] args) {
		
//		String msg=Ex11.func01();
//		if(msg!=null)
//			msg=msg.trim();
//		System.out.println(msg);
		Optional result = Ex11.func02(11);
		if(result.isPresent())
			System.out.println(result.get());
		else
			System.out.println("없음");
		System.out.println(result.isPresent());
		result.ifPresent(new Consumer() {

			@Override
			public void accept(Object t) {
				System.out.println("실행");
			}
		});
//		result.ifPresent((a) -> System.out.println(a));

	}

}










