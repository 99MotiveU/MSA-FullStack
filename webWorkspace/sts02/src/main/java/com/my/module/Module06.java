package com.my.module;

import java.util.Map;

public class Module06 implements MyModule {
	Map<String,String> map;
	
	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	@Override
	public void func01() {
		System.out.println(map);
	}

}
