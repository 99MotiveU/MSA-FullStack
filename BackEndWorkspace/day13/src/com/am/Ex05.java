package com.am;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Ex05 {

	public static void main(String[] args) {
		Map map=new HashMap();
		map.put("key1", "val1");
		map.put("key2", "val2");
		map.put("key3", "val3");
		map.put("key4", "val4");
		map.put("key5", "val5");
//		String[] keys1= {"key1","key2","key3","key4","key5"};
//		map.put(keys1[0], "val1");
//		map.put(keys1[1], "val2");
//		map.put(keys1[2], "val3");
//		map.put(keys1[3], "val4");
//		map.put(keys1[4], "val5");
//		for(int i=0; i<keys1.length; i++) {
//			System.out.println(keys1[i]+":"+map.get(keys1[i]));
//		}
		
		Set keys2=map.keySet();
//		Iterator ite = keys2.iterator();
//		while(ite.hasNext()) {
//			Object key=ite.next();
//			Object val=map.get(key);
//			System.out.println(key+":"+val);
//		}
		
//		Object[] keys3=keys2.toArray();
//		for(int i=0; i<keys3.length; i++) {
//			Object key=keys3[i];
//			Object val=map.get(key);
//			System.out.println(key+":"+val);
//		}
		
		Set entrys = map.entrySet();
		Iterator ite2 = entrys.iterator();
		while(ite2.hasNext()) {
			Object obj = ite2.next();
			java.util.Map.Entry entry = (Entry)obj;
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
		
		
	}

}



