package com.am;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class Ex10 {

	public static void main(String[] args) {
//		Properties props=new Properties();
//		props.setProperty("key1", "val1");
//		props.setProperty("key2", "val2");
//		props.setProperty("key3", "val3");
//		props.setProperty("key4", "val4");
//		
//		System.out.println(props.getProperty("key1"));
//		System.out.println(props.getProperty("key2"));
//		System.out.println(props.getProperty("key3"));
//		System.out.println(props.getProperty("key4"));
//		System.out.println(props.getProperty("key5"));
		Properties props2=System.getProperties();
		Set keys=props2.keySet();
		Iterator ite = keys.iterator();
		while(ite.hasNext()) {
			Object key=ite.next();
			System.out.println(key+":");
			System.out.println("\t\t"+props2.getProperty(key.toString()));
		}
	}

}














