package com.pm;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Ex10 {

	public static void main(String[] args) {
		// 로또 (자료 구조 사용)
		System.out.println("로또 번호 추첨기");
		Set lotto = new HashSet();
		while (lotto.size() < 6) {
			int num = (int) (Math.random() * 45) + 1;
			lotto.add(num);
		}
		Iterator note = lotto.iterator();
		while(note.hasNext()){
			System.out.print(note.next()+" ");
		}

	}

}
