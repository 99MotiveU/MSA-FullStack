package com.am;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Ex08 {

	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("", "");
//		map.put(1111,"");
//		map.compute("", 2222);
		Set<String> set1 = map.keySet();
		Set<Entry<String, String>> set2 = map.entrySet();
		Iterator<Entry<String, String>> ite = set2.iterator();
	}

}
